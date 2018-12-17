/*
Using the state pattern in Rust

All Code and Definitions taken from:
https://doc.rust-lang.org/book/2018-edition/ch17-02-trait-objects.html
*/

/*
State

There are two state patterns shown here:
    1. Module state_oop is the object-oriented way
        of doing state
    2. Module state_encoding encodes the states into different
        types.

 Rust is capable of implementing object-oriented design patterns, other patterns,
 such as encoding state into the type system, are also available in Rust.
 These patterns have different trade-offs. Although you might be very familiar with
 object-oriented patterns, rethinking the problem to take advantage of Rust’s features
 can provide benefits, such as preventing some bugs at compile time. Object-oriented
 patterns won’t always be the best solution in Rust due to certain features, like
 ownership, that object-oriented languages don’t have.
*/

/*
States in state_oop:
    1. Draft
    2. PendingReview
    3. Published
*/

mod state_oop {
    trait State {
        fn request_review(self: Box<Self>) -> Box<dyn State>;
        fn approve(self: Box<Self>) -> Box<dyn State>;

        /*
        We add a default implementation for the content method that returns an empty
        string slice. That means we don’t need to implement content on the Draft and
        PendingReview structs.
        */
        fn content<'a>(&self, post: &'a Post) -> &'a str {
            ""
        }
    }

    pub struct Post {
        state: Option<Box<dyn State>>,
        content: String,
    }

    impl Post {
        pub fn new() -> Post {
            Post {
                state: Some(Box::new(Draft {})),
                content: String::new(),
            }
        }

        /*
        takes a mutable reference to self, because we’re changing the Post instance that
        we’re calling add_text on
        */
        pub fn add_text(&mut self, text: &str) {
            self.content.push_str(text);
        }

        /*
        If the state is Published, we want to return the value in the post’s
        content field; otherwise, we want to return an empty string slice, as shown

        We call the as_ref method on the Option because we want a reference to the
        value inside the Option rather than ownership of the value.
         Because state is an Option<Box<dyn State>>, when we call as_ref,
         an Option<&Box<dyn State>> is returned.
        */
        pub fn content(&self) -> &str {
            self.state.as_ref().unwrap().content(&self)
        }

        /*
        Using take() allows taking the value Some out of the state field
        and leave a None. This is allowed because we defined state in the
        Post struct to be Option. This lets us move the state value out of Post
        rather than borrowing it. Then we’ll set the post’s state value to the
        result of this operation.

        Because we temporarily use a None value to get ownership of the state value,
        it ensures that Post cant use the old state value after we've transformed
        it into a new state.
        */
        pub fn request_review(&mut self) {
            if let Some(s) = self.state.take() {
                self.state = Some(s.request_review())
            }
        }

        pub fn approve(&mut self) {
            if let Some(s) = self.state.take() {
                self.state = Some(s.approve())
            }
        }
    }

    struct Draft {}

    impl State for Draft {
        /*
        The request_review method on Draft needs to return a new, boxed instance of
        a new PendingReview struct, which represents the state when a post is
        waiting for a review.
        */
        fn request_review(self: Box<Self>) -> Box<dyn State> {
            Box::new(PendingReview {})
        }

        /*
        Calling the approve method on a Draft will have no effect because it will return self
        */
        fn approve(self: Box<Self>) -> Box<dyn State> {
            self
        }
    }

    struct PendingReview {}

    impl State for PendingReview {
        /*
        Returns itself, because when we request a review on a post already in the
        PendingReview state, it should stay in the PendingReview state.
        */
        fn request_review(self: Box<Self>) -> Box<dyn State> {
            self
        }

        /*
        Returns a new, boxed instance of the Published struct.
        */
        fn approve(self: Box<Self>) -> Box<dyn State> {
            Box::new(Published {})
        }
    }

    struct Published {}

    /*
    The Published struct implements the State trait, and for both the
    request_review method and the approve method, it returns itself,
    because the post should stay in the Published state in those cases.
    */
    impl State for Published {
        fn request_review(self: Box<Self>) -> Box<dyn State> {
            self
        }

        fn approve(self: Box<Self>) -> Box<dyn State> {
            self
        }

        /*
        The Published struct will override the content method and return the value in post.content.

        Needs lifetime traits because we are taking a reference to a
        post as an argument and returning a reference to part of that post,
        so the lifetime of the returned reference is related to the lifetime
        of the post argument.
        */
        fn content<'a>(&self, post: &'a Post) -> &'a str {
            &post.content
        }
    }
}

#[cfg(test)]
mod tests_state_oop {
    use super::*;

    #[test]
    fn basic_test() {
        let mut post = state_oop::Post::new();

        post.add_text("I ate a salad for lunch today");
        assert_eq!("", post.content());

        post.request_review();
        assert_eq!("", post.content());

        post.approve();
        assert_eq!("I ate a salad for lunch today", post.content());
    }
}

/*
State pattern using state encoding and behavior as types

The request_review and approve methods take ownership of self,
thus consuming the DraftPost and PendingReviewPost instances and
transforming them into a PendingReviewPost and a published Post

Setting a Post and Approving a Post
The only way to get a published Post instance that does have a content
method defined is to call the approve method on a PendingReviewPost, and the
only way to get a PendingReviewPost is to call the request_review method
on a DraftPost.

The transformations between the states are no longer encapsulated entirely
within the Post implementation as they were with the object-oriented state pattern.
However, our gain is that invalid states are now impossible because of the type system
and the type checking that happens at compile time.
*/

mod state_encoding {
    pub struct Post {
        content: String,
    }

    impl Post {
        pub fn new() -> DraftPost {
            DraftPost {
                content: String::new(),
            }
        }

        pub fn content(&self) -> &str {
            &self.content
        }
    }

    pub struct DraftPost {
        content: String,
    }

    /*
    A Post will first add the text in a DraftPost using add_text().
    Then calling request_review() will create a new PendingReviewRequest
    of the text and return the PendingReviewRequest. At this point
    is when approve() can be called.

    DraftPost does not implement content() so the method cannot
    be called until approved() is called which sets the Post.
    */
    impl DraftPost {
        pub fn add_text(&mut self, text: &str) {
            self.content.push_str(text);
        }

        pub fn request_review(self) -> PendingReviewPost {
            PendingReviewPost {
                content: self.content,
            }
        }
    }

    pub struct PendingReviewPost {
        content: String,
    }

    impl PendingReviewPost {
        /*
        Approve a PendingReviewPost creating a new Post
        and setting the content.
        */
        pub fn approve(self) -> Post {
            Post {
                content: self.content,
            }
        }
    }
}

#[cfg(test)]
mod tests_state_encoding {
    use super::*;

    #[test]
    fn basic_test() {
        let mut post = state_encoding::Post::new();

        post.add_text("I ate a salad for lunch today");

        // Before request_review or approve(), we cannot
        // call content() because it is not defined in DraftPost
        let post = post.request_review();
        let post = post.approve();

        assert_eq!("I ate a salad for lunch today", post.content());
    }
}
