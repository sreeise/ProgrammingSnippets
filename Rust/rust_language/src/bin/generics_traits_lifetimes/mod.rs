/*
Definitions and Code from:
https://doc.rust-lang.org/book/2018-edition/ch10-00-generics.html
https://doc.rust-lang.org/book/2018-edition/ch17-03-oo-design-patterns.html
daringordon.com/authz_rs_tutorial/03.authz.rs/

Generics: Abstract stand-ins for concrete types or other properties.

    1. Declare the type parameter name before it is used
    2. Rust uses Monomorphization to ensure generics are just
        as fast as concrete types - there is no performance
        penalty

Monomorphization: The process of turning generic code into specific code by
filling in the concrete types that are used when compiled.
*/

// Finding the largest number in a list without generics
fn largest(list: &[i32]) -> i32 {
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}

// Using Generics
fn largest_with_generics<T: PartialOrd + Copy>(list: &[T]) -> T {
    // Note: Intellij IDEA may show that this assignment is a borrow error
    let mut largest = list[0];

    for &item in list.iter() {
        if item > largest {
            largest = item;
        }
    }

    largest
}


/*
Structs that can hold values of any types by use of Generics

Note that because we’ve used only one generic type to define Point<T>,
this definition says that the Point<T> struct is generic over some type T,
and the fields x and y are both that same type, whatever that type may be.
*/
struct Point<T> {
    x: T,
    y: T,
}

/*
To allow different types in the struct use multiple generics
*/

struct PointMultipleGenerics<T, U> {
    x: T,
    y: U,
}

// Using structs and generics with methods
// This defines a method named x on Point3<T> that returns a
// reference to the data in the field x
struct Point3<T> {
    x: T,
    y: T,
}

impl<T> Point3<T> {
    fn x(&self) -> &T {
        &self.x
    }

    /* Types can also be used
    fn distance_from_origin(&self) -> f32 {
        (self.x.powi(2) + self.y.powi(2)).sqrt()
    } */
}


// Using different generics in method signatures then those
// in a struct
struct Point4<T, U> {
    x: T,
    y: U,
}

impl<T, U> Point4<T, U> {
    fn mixup<V, W>(self, other: Point4<V, W>) -> Point4<T, W> {
        Point4 {
            x: self.x,
            y: other.y,
        }
    }

    fn print_mixup() {
        /*
        we’ve defined a Point that has an i32 for x (with value 5)
        and an f64 for y (with value 10.4). The p2 variable is a Point
        struct that has a string slice for x (with value "Hello") and
        a char for y (with value c). Calling mixup on p1 with the argument
        p2 gives us p3, which will have an i32 for x, because x came from p1.
        The p3 variable will have a char for y, because y came from p2. The
        println! macro call will print p3.x = 5, p3.y = c

        The purpose of this example is to demonstrate a situation in which some
        generic parameters are declared with impl and some are declared with the
        method definition. Here, the generic parameters T and U are declared after
        impl, because they go with the struct definition. The generic parameters
        V and W are declared after fn mixup, because they’re only relevant to the method.
        */

        let p1 = Point4 { x: 5, y: 10.4 };
        let p2 = Point4 { x: "Hello", y: 'c' };

        let p3 = p1.mixup(p2);

        println!("p3.x = {}, p3.y = {}", p3.x, p3.y);
    }
}


/*
Traits

A trait tells the Rust compiler about functionality a particular type
has and can share with other types. We can use traits to define shared
behavior in an abstract way. We can use trait bounds to specify that a
generic can be any type that has certain behavior.

    1. The implementation of a trait must provide the concrete
        method for the same method signature defined in the trait
    2. We can implement a trait on a type only if either the
        trait or the type is local to our crate. This restriction is part of
        a property of programs called coherence, and more specifically the
        orphan rule, so named because the parent type is not present
    3. Traits can have default methods instead of just the method signature
*/

/*
After the method signature, instead of providing an implementation within curly brackets,
we use a semicolon. Each type implementing this trait must provide its own custom behavior
for the body of the method. The compiler will enforce that any type that has the Summary
trait will have the method summarize defined with this signature exactly.
*/
pub trait Summary {
    fn summarize(&self) -> String;
}

// Implementing Summary
pub struct NewsArticle {
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

// The implementation must provide a method with the name summarize
impl Summary for NewsArticle {
    fn summarize(&self) -> String {
        format!("{}, by {} ({})", self.headline, self.author, self.location)
    }
}

pub struct Tweet {
    pub username: String,
    pub content: String,
    pub reply: bool,
    pub retweet: bool,
}

// The implementation must provide a method with the name summarize
impl Summary for Tweet {
    fn summarize(&self) -> String {
        format!("{}: {}", self.username, self.content)
    }
}

fn print_tweet() {
    let tweet = Tweet {
        username: String::from("my_twitter"),
        content: String::from("I'm on twitter #tweeting"),
        reply: false,
        retweet: false,
    };

    println!("1 new tweet: {}", tweet.summarize());
}

// Summary trait with a default method instead of just the method signature
pub trait Summary2 {
    fn summarize(&self) -> String {
        String::from("(Read more...)")
    }
}

// Implementing Summary
pub struct NewsArticle2 {
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

// NewsArticle2 with no summarize method so it uses the default
impl Summary2 for NewsArticle2 {}

fn print_summary2() {
    let article = NewsArticle2 {
        headline: String::from("Penguins win the Stanley Cup Championship!"),
        location: String::from("Pittsburgh, PA, USA"),
        author: String::from("Iceburgh"),
        content: String::from("The Pittsburgh Penguins once again are the best
    hockey team in the NHL."),
    };

    println!("New article available! {}", article.summarize());
}

// Defining a trait that calls the a the method defined by an implementation
pub trait Summary3 {
    fn summarize_author(&self) -> String;

    fn summarize3(&self) -> String {
        format!("(Read more from {}...)", self.summarize_author())
    }
}

impl Summary3 for Tweet {
    fn summarize_author(&self) -> String {
        format!("@{}", self.username)
    }
}

fn print_tweet_summary3() {
    let tweet = Tweet {
        username: String::from("horse_ebooks"),
        content: String::from("of course, as you probably already know, people"),
        reply: false,
        retweet: false,
    };

    println!("1 new tweet: {}", tweet.summarize3());
}


/*
Traits as arguments

    1. Trait bounds are placed within the declaration of hte generic
        type parameter, after a colon inside angle brackets.
    2. Because of the trait bound on T, we can call notify and pass in any
        instance of NewsArticle or Tweet.
    3. Specify multiple trait bounds on a generic type using the + syntax.
    4. Rust has an alternate syntax for specifying trait bounds inside
        a where after the function signature.
        Example:
        fn some_function<T, U>(t: T, u: U) -> i32
            where T: Display + Clone,
                  U: Clone + Debug
        {

*/
pub fn notify(item: impl Summary) {
    println!("Breaking news! {}", item.summarize());
}

// Trait bounds and normally looks like this;

pub fn notify_trait_bound<T: Summary>(item: T) {
    println!("Breaking news! {}", item.summarize());
}


/*
Return Traits
*/
fn returns_trait_summary() -> impl Summary {
    Tweet {
        username: String::from("horse_ebooks"),
        content: String::from("of course, as you probably already know, people"),
        reply: false,
        retweet: false,
    }
}


/*
Using trait bounds to conditionally implement methods
*/

use std::fmt::Display;

struct Pair<T> {
    x: T,
    y: T,
}

impl<T> Pair<T> {
    fn new(x: T, y: T) -> Self {
        Self {
            x,
            y,
        }
    }
}

impl<T: Display + PartialOrd> Pair<T> {
    fn cmp_display(&self) {
        if self.x >= self.y {
            println!("The largest member is x = {}", self.x);
        } else {
            println!("The largest member is y = {}", self.y);
        }
    }
}

/*
Trait Objects

Defining trait objects that can fill in variables/data at runtime

Trait objects allow for multiple concrete types to fill in for the trait object at runtime.

Trait objects are safe if all methods defined in the trait have the following two
properties:
    1. The return type isn’t Self.
    2. There are no generic type parameters.

Trait objects must be object safe because once you’ve used a trait object, Rust no longer
knows the concrete type that’s implementing that trait. If a trait method returns the
concrete Self type, but a trait object forgets the exact type that Self is, there is
no way the method can use the original concrete type.

Typically seen where libraries are used and programmers
can build onto the existing 'Object'. Rust
doesn't necessarily have an OOP Object, however, trait
Objects are useful in this type of situation.
*/

/*
Shows example of using trait objects and defining multiple structs that implement
the Draw trait. If this were a library, and someone wanted to add another GUI component
such as CheckBox, all they would have to do is define it's struct and implement the
the Draw type.

The define_library() shows how this could be done.
*/
pub trait Draw {
    fn draw(&self);
}

pub struct Screen {
    pub components: Vec<Box<dyn Draw>>,
}

impl Screen {
    pub fn run(&self) {
        for component in self.components.iter() {
            component.draw();
        }
    }
}

pub struct Button {
    pub width: u32,
    pub height: u32,
    pub label: String,
}

impl Draw for Button {
    fn draw(&self) {
        // Draw a button...
    }
}

struct SelectBox {
    width: u32,
    height: u32,
    options: Vec<String>,
}

impl Draw for SelectBox {
    fn draw(&self) {
        // code to actually draw a select box
    }
}

fn define_library() {
    let screen = Screen {
        components: vec![
            Box::new(SelectBox {
                width: 75,
                height: 10,
                options: vec![
                    String::from("Yes"),
                    String::from("Maybe"),
                    String::from("No")
                ],
            }),
            Box::new(Button {
                width: 50,
                height: 10,
                label: String::from("OK"),
            }),
        ],
    };

    screen.run();
}

/*
Example Implementation of Trait
*/

struct Sheep { naked: bool, name: &'static str }

trait Animal {
    // Static method signature; `Self` refers to the implementor type.
    fn new(name: &'static str) -> Self;

    // Instance method signatures; these will return a string.
    fn name(&self) -> &'static str;
    fn noise(&self) -> &'static str;

    // Traits can provide default method definitions.
    fn talk(&self) {
        println!("{} says {}", self.name(), self.noise());
    }
}

impl Sheep {
    fn is_naked(&self) -> bool {
        self.naked
    }

    fn shear(&mut self) {
        if self.is_naked() {
            // Implementor methods can use the implementor's trait methods.
            println!("{} is already naked...", self.name());
        } else {
            println!("{} gets a haircut!", self.name);

            self.naked = true;
        }
    }
}

// Implement the `Animal` trait for `Sheep`.
impl Animal for Sheep {
    // `Self` is the implementor type: `Sheep`.
    fn new(name: &'static str) -> Sheep {
        Sheep { name: name, naked: false }
    }

    fn name(&self) -> &'static str {
        self.name
    }

    fn noise(&self) -> &'static str {
        if self.is_naked() {
            "baaaaah?"
        } else {
            "baaaaah!"
        }
    }

    // Default trait methods can be overridden.
    fn talk(&self) {
        // For example, we can add some quiet contemplation.
        println!("{} pauses briefly... {}", self.name, self.noise());
    }
}

pub fn call_trait() {
    let mut dolly: Sheep = Animal::new("Dolly");

    dolly.talk();
    dolly.shear();
    dolly.talk();
}