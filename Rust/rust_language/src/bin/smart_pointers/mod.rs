/*
Smart Pointers

All Code and Definitions from:
https://doc.rust-lang.org/book/2018-edition/ch15-00-smart-pointers.html
https://doc.rust-lang.org/book/2018-edition/ch15-01-box.html
https://doc.rust-lang.org/book/2018-edition/ch15-02-deref.html
https://doc.rust-lang.org/book/2018-edition/ch15-03-drop.html
https://doc.rust-lang.org/book/2018-edition/ch15-04-rc.html
https://doc.rust-lang.org/book/2018-edition/ch15-05-interior-mutability.html
https://doc.rust-lang.org/std/rc/struct.Rc.html

    A pointer is a general concept for a variable that contains an address in memory.
    This address refers to, or “points at,” some other data.

    Smart pointers, on the other hand, are data structures that not only act like a
    pointer but also have additional metadata and capabilities.

References vs Pointers
     References are pointers that only borrow data; in contrast, in many cases,
     smart pointers own the data they point to.

Definitions
    1. Deref Trait
        Allows an instance of the smart pointer struct to behave like a reference so
        you can write code that works with either references or smart pointers.
    2. Drop Trait
        Allows you to customize the code that is run when an instance of the smart
        pointer goes out of scope.
    3. Interior Mutability
        Where an immutable type exposes an API for mutating an interior value.
*/

/*
Box<T>
    Smart pointer that allow storing values on the heap rather then the stack.

    The Box<T> type is a smart pointer because it implements the Deref trait,
    which allows Box<T> values to be treated like references.

    1. Just like any owned value, when a box goes out of scope it will be deallocated.
    2. Putting a single value on the heap isn’t very useful, so you won’t use boxes by
        themselves in this way very often.
   3. Recursive Types
        A type who's size is not known at compile time. Boxes have a known size, so by
        inserting a box in a recursive type definition, you can have recursive types.

Common uses for Box<T>
    1. When you have a type whose size can’t be known at compile time and you want to
        use a value of that type in a context that requires an exact size
    2. When you have a large amount of data and you want to transfer ownership but ensure
        the data won’t be copied when you do so
    3. When you want to own a value and you care only that it’s a type that implements a
        particular trait rather than being of a specific type

*/
fn using_box_pointer() {
    // define the variable b to have the value of a Box that points to the value 5,
    // which is allocated on the heap
    let b = Box::new(5);
    println!("b = {}", b);
}

/*
Deref and * pointers
*/

/*
Creates a reference to an i32 value and then use the dereference operator to
follow the reference to the data
*/
fn using_pointer_to_value() {
    let x = 5;
    let y = &x;

    assert_eq!(5, x);
    assert_eq!(5, *y);
}

/*
The last function can also be written with Box<T>

The difference is that y is set to be an instance of a box pointing to the value
in x rather than a reference pointing to the value of x.
*/
fn using_box_pointer_to_value() {
    let x = 5;
    let y = Box::new(x);

    assert_eq!(5, x);
    assert_eq!(5, *y);
}

/*
Defining a smart pointer
*/

/*
The MyBox type is defined as a tuple struct with one element.

The type Target = T; syntax defines an associated type for the Deref trait to use.
Associated types are a slightly different way of declaring a generic parameter

Without the Deref trait, the compiler can only dereference & references.
The deref method gives the compiler the ability to take a value of any type that
implements Deref and call the deref method to get a & reference that it knows how to dereference.
*/

use std::ops::Deref;

struct MyBox<T>(T);

impl<T> Deref for MyBox<T> {
    // Associated type for the deref trait to use
    type Target = T;

    fn deref(&self) -> &T {
        &self.0
    }
}

/*
Implicit Deref Coercions

Converts a reference to a type that implements Deref into a reference to a type that
Deref can convert the original type into.

    1. Happens automatically when we pass a reference to a particular type’s
        value as an argument to a function or method that doesn't match the parameter
        type in the function or method definition.
   2. A sequence of calls to the deref method converts the type we provided into the
        type the parameter needs.

Rust does deref coercion when it finds types and trait implementations in three cases:
    1. From &T to &U when T: Deref<Target=U>
    2. From &mut T to &mut U when T: DerefMut<Target=U>
    3. From &mut T to &U when T: Deref<Target=U>

// Example: Doesn't compile due to unknown size of str.
// Could possibly be used with std::marker::Sized
fn hello(name: &str) {
    println!("Hello, {}!", name);
}

fn call_hello_with_my_box() {
    let m = MyBox::new(String::from("Rust"));
    hello(&m);
}
*/

/*
Drop trait and smart pointers

    1. The drop trait lets you customize what happens when a value is about to go out of scope.
    2. You can provide an implementation for the Drop trait on any type, and the code you
        specify can be used to release resources like files or network connections.
    3. Implementations of the drop method cannot be explicitly called. Instead you have
        to call the std::mem::drop function provided by the standard library if you want
        to force a value to be dropped before the end of its scope.

Defining the drop trait
    The Drop trait requires you to implement one method named drop that takes a
    mutable reference to self.
*/

struct CustomSmartPointer {
    data: String,
}

impl Drop for CustomSmartPointer {
    fn drop(&mut self) {
        println!("Dropping CustomSmartPointer with data `{}`!", self.data);
    }
}

// Here the last println! will run first because CustomSmartPointer is
// run when this function goes out of scope.
fn using_custom_smart_pointer() {
    let c = CustomSmartPointer {
        data: String::from("my stuff"),
    };
    let d = CustomSmartPointer {
        data: String::from("other stuff"),
    };
    println!("CustomSmartPointers created.");
}

/*
Cleaning up a value early using std::mem::drop

The std::mem::drop function is different than the drop method in the Drop trait.
We call it by passing the value we want to force to be dropped early as an argument.
*/
fn clean_up_drop_value_early() {
    let c = CustomSmartPointer {
        data: String::from("some data"),
    };
    println!("CustomSmartPointer created.");
    drop(c);
    println!("CustomSmartPointer dropped before the end of main.");
}

/*
Rc<T> Type

Enables multiple ownership by keeping track of the number of references to a
value which determines whether or not a value is still in use. If there are
zero references to a value, the value can be cleaned up without any references
becoming invalid.

NOTE: Rc<T> is only for use in single-threaded scenarios.

    1. Rc is an abbreviation for reference counting
    2. Common use case for Rc<T> type is when we want to allocate some data on
        the heap for multiple parts of our program to read and we can’t determine at
        compile time which part will finish using the data last.
   3. The reference count does not have to be decremented as Rc<T> implements the
        drop trait which automatically decreases the reference count when an
        Rc<T> goes out of scope.
   4. Rc<T> allows sharing immutable references across multiple parts of a
        program. However, it does not allow sharing multiple mutable references
        as this can cause data races and inconsistencies.

Example of using multiple lists to clone list a to list b thereby having two
references to the same list. (Uses fake types so does not compile, just an example):

    enum List {
        Cons(i32, Rc<List>),
        Nil,
    }

    use List::{Cons, Nil};
    use std::rc::Rc;


    fn main() {
        let a = Rc::new(Cons(5, Rc::new(Cons(10, Rc::new(Nil)))));
        let b = Cons(3, Rc::clone(&a));
        let c = Cons(4, Rc::clone(&a));
    }

The implementation of Rc::clone doesn't make a deep copy of all the data like
most types’ implementations of clone do. The call to Rc::clone only increments
the reference count, which doesn't take much time.

Deep copies of data can take a lot of time. By using Rc::clone for reference
counting, we can visually distinguish between the deep-copy kinds of clones and the
kinds of clones that increase the reference count. When looking for performance problems
in the code, we only need to consider the deep-copy clones and can disregard
calls to Rc::clone.
*/

use std::rc::Rc;

// Basic usage of Rc<T>
fn using_rc() {
    let five = Rc::new(5);
}

/*
RefCell<T> Type

Represents single ownership over the data it holds.

The RefCell<T> type is useful when you’re sure your code follows the borrowing rules
but the compiler is unable to understand and guarantee that. In essence, RefCell<T>
uses the advantages of borrowing rules at runtime discussed below.

An advantage of RecCell<T> is that it can mutate the value inside an immutable value
known as interior mutability.

Interior mutability
A design pattern in Rust that allows you to mutate data even when there are
immutable references to that data; normally, this action is disallowed by
the borrowing rules.

    1. To mutate data, the pattern uses unsafe code inside a data structure to
        bend Rust’s usual rules that govern mutation and borrowing.
    2. We can use types that use the interior mutability pattern when we can ensure
        that the borrowing rules will be followed at runtime, even though the compiler
        can’t guarantee that. The unsafe code involved is then wrapped in a safe API,
        and the outer type is still immutable.

Borrowing rules advantages for compile time vs runtime

Advantages of borrowing rules at compile time
    1. Checking the borrowing rules at compile time means errors will be
        caught sooner in the development process.
    2. There is no impact on runtime performance because all the analysis
        is completed beforehand.

Advantages of borrowing rules at runtime
    1. Certain memory-safe scenarios are then allowed, whereas they are
        disallowed by the compile-time checks.

RefCell<T> Rules:
    1. At any given time, you can have either (but not both of) one mutable reference
        or any number of immutable references.
    2. References must always be valid.

Box<T> vs RefCell<T>
    With references and Box<T>, the borrowing rules’ invariants are enforced at
    compile time. With RefCell<T>, these invariants are enforced at runtime.

Box<T> vs Rc<T> vs RefCell<T>
    1. Rc<T> enables multiple owners of the same data; Box<T> and RefCell<T>
        have single owners.
    2.  Box<T> allows immutable or mutable borrows checked at compile time; Rc<T>
        allows only immutable borrows checked at compile time; RefCell<T> allows
        immutable or mutable borrows checked at runtime.
    3. Because RefCell<T> allows mutable borrows checked at runtime, you can mutate
        the value inside the RefCell<T> even when the RefCell<T> is immutable. As
        discussed earlier, mutating the value inside an immutable reference is the
        interior mutability pattern.

Definitions:
    1. borrow()
        Borrow an immutable reference (&). Returns the smart pointer type Ref<T>.
        Implements Deref, so it can be treated like regular references.
    2. borrow_mut()
        Borrow a a mutable reference (&mut). Returns the smart pointer type RefMut<T>.
        Implements Deref, so it can be treated like regular references.
    3. BorrowMutError
        Panic error caused by having more then one mutable reference in the same
        scope when using RefCell<T>

Tracking Ref<T> and RefMut<T> smart pointers

    1. The RefCell<T> keeps track of how many Ref<T> and RefMut<T> smart pointers
        are currently active. Every time we call borrow, the RefCell<T> increases its
        count of how many immutable borrows are active. When a Ref<T> value goes out of
        scope, the count of immutable borrows goes down by one. Just like the compile-time
        borrowing rules, RefCell<T> lets us have many immutable borrows or one mutable
        borrow at any point in time.
    2. If we try to violate these rules, rather than getting a compiler error as we would with
        references, the implementation of RefCell<T> will panic at runtime.

Combining Rc<T> and RefCell<T>
A common way to use RefCell<T> is in combination with Rc<T>. Recall that Rc<T>
lets you have multiple owners of some data, but it only gives immutable access to
that data. If you have an Rc<T> that holds a RefCell<T>, you can get a value that
can have multiple owners and that you can mutate!
*/

/*
RefCell<T> example
*/

/*
Messenger trait has one method called send that takes an immutable reference
to self and the text of the message.
*/
pub trait Messenger {
    fn send(&self, msg: &str);
}

pub struct LimitTracker<'a, T: 'a + Messenger> {
    messenger: &'a T,
    value: usize,
    max: usize,
}

impl<'a, T> LimitTracker<'a, T>
where
    T: Messenger,
{
    pub fn new(messenger: &T, max: usize) -> LimitTracker<T> {
        LimitTracker {
            messenger,
            value: 0,
            max,
        }
    }

    pub fn set_value(&mut self, value: usize) {
        self.value = value;

        let percentage_of_max = self.value as f64 / self.max as f64;

        if percentage_of_max >= 0.75 && percentage_of_max < 0.9 {
            self.messenger
                .send("Warning: You've used up over 75% of your quota!");
        } else if percentage_of_max >= 0.9 && percentage_of_max < 1.0 {
            self.messenger
                .send("Urgent warning: You've used up over 90% of your quota!");
        } else if percentage_of_max >= 1.0 {
            self.messenger.send("Error: You are over your quota!");
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::cell::RefCell;

    struct MockMessenger {
        sent_messages: RefCell<Vec<String>>,
    }

    impl MockMessenger {
        fn new() -> MockMessenger {
            MockMessenger {
                sent_messages: RefCell::new(vec![]),
            }
        }
    }

    impl Messenger for MockMessenger {
        // first parameter is still an immutable borrow of self, which
        // matches the trait definition.
        fn send(&self, message: &str) {
            // Calls borrow_mut on the RefCell<Vec<String>> in self.sent_messages
            // to get a mutable reference to the value inside the RefCell<Vec<String>>,
            // which is the vector.
            self.sent_messages.borrow_mut().push(String::from(message));
        }
    }

    #[test]
    fn it_sends_an_0ver_75_percent_warning_message() {
        let mock_messenger = MockMessenger::new();
        let mut limit_tracker = LimitTracker::new(&mock_messenger, 100);
        limit_tracker.set_value(75);

        assert_eq!(mock_messenger.sent_messages.borrow().len(), 1);
    }
}
