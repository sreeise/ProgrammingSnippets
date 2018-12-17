/*
Advanced Traits

All Code and Definitions from
https://doc.rust-lang.org/book/2018-edition/ch19-03-advanced-traits.html

Trait Definitions with Placeholder and Associated Types

    1. Associated Types
        Associated types connect a type placeholder with a trait such that the
        trait method definitions can use these placeholder types in their signatures.

Generics vs Associated Types

When a trait has a generic parameter, it can be implemented for a type multiple
times, changing the concrete types of the generic type parameters each time.
With associated types, we don’t need to annotate types because we can’t
implement a trait on a type multiple times.

*/

/*
Iterator

Iterator uses an associated type:

pub trait Iterator {
    type Item;

    fn next(&mut self) -> Option<Self::Item>;
}

The type Item is a placeholder type, and the next method’s definition shows
that it will return values of type Option<Self::Item>. Implementors of the
Iterator trait will specify the concrete type for Item, and the next method
will return an Option containing a value of that concrete type.
*/

fn iterator_sum() {
    let v1 = vec![1, 2, 3];

    let v1_iter = v1.iter();

    let total: i32 = v1_iter.sum();

    assert_eq!(total, 6);
}

/*
Default Generic Type Parameters and Operator Overloading

When we use generic type parameters, we can specify a default concrete type
for the generic type. This eliminates the need for implementors of the trait to
specify a concrete type if the default type works. The syntax for specifying a
default type for a generic type is <PlaceholderType=ConcreteType> when declaring
the generic type.

Uses of Default Type Parameters
    1. To extend a type without breaking existing code
    2. To allow customization in specific cases most users won’t need

Example is used in operator overloading. Operator overloading is customizing the
behavior of an operator (such as +) in particular situations. Rust doesn't allow you
to create your own operators or overload arbitrary operators. But you can overload
the operations and corresponding traits listed in std::ops by implementing the traits
associated with the operator.

Default Type Parameters
    If a concrete type is not specified for a trait that accepts a generic
    type for a default, it default to self.

Default Generic Type for Add
trait Add<RHS=Self> {
    type Output;

    fn add(self, rhs: RHS) -> Self::Output;
}

The RHS generic type parameter (short for “right hand side”) defines the type
of the rhs parameter in the add method. If we don’t specify a concrete type for
RHS when we implement the Add trait, the type of RHS will default to Self, which
will be the type we’re implementing Add on.
*/

/*
Overload the + operator to add two Point instances together.
We do this by implementing the Add trait on a Point struct:

The add method adds the x values of two Point instances and the y
values of two Point instances to create a new Point. The Add trait
has an associated type named Output that determines the type returned
from the add method.
*/
use std::ops::Add;

#[derive(Debug, PartialEq)]
struct Point {
    x: i32,
    y: i32,
}

impl Add for Point {
    type Output = Point;

    fn add(self, other: Point) -> Point {
        Point {
            x: self.x + other.x,
            y: self.y + other.y,
        }
    }
}

#[test]
fn test_overload() {
    assert_eq!(
        Point { x: 1, y: 0 } + Point { x: 2, y: 3 },
        Point { x: 3, y: 3 }
    );
}

/*
Add with Custom RHS

We have two structs, Millimeters and Meters, holding values in different units.
We want to add values in millimeters to values in meters and have the implementation
of Add do the conversion correctly.

To add Millimeters and Meters, we specify impl Add<Meters> to set the value of
the RHS type parameter instead of using the default of Self.
*/
struct Millimeters(u32);
struct Meters(u32);

impl Add<Meters> for Millimeters {
    type Output = Millimeters;

    fn add(self, other: Meters) -> Millimeters {
        Millimeters(self.0 + (other.0 * 1000))
    }
}

/*
Fully Qualified Syntax for Disambiguation: Calling Methods with the Same Name

Nothing in Rust prevents a trait from having a method with the same name as
another trait’s method, nor does Rust prevent you from implementing both traits on
one type. It’s also possible to implement a method directly on the type with the
same name as methods from traits.


Because the fly method takes a self parameter, if we had two types that both implement
one trait, Rust could figure out which implementation of a trait to use based on the
type of self. However, associated functions that are part of traits don’t have a self
parameter. When two types in the same scope implement that trait, Rust can’t figure out
which type you mean unless you use fully qualified syntax.
*/
trait Pilot {
    fn fly(&self);
}

trait Wizard {
    fn fly(&self);
}

struct Human;

impl Pilot for Human {
    fn fly(&self) {
        println!("This is your captain speaking.");
    }
}

impl Wizard for Human {
    fn fly(&self) {
        println!("Up!");
    }
}

impl Human {
    fn fly(&self) {
        println!("*waving arms furiously*");
    }
}

pub fn print_method_same_name() {
    let person = Human;
    Pilot::fly(&person); // --> This is your captain speaking.
    Wizard::fly(&person); // --> Up!
    person.fly(); // --> *waving arms furiously*
}

/*
Using Fully Qualified Syntax

Using Associated Functions when two types in the same scope implement the same trait.

Fully Qualified Syntax is defined as follows:
    <Type as Trait>::function(receiver_if_method, next_arg, ...);
*/

trait Animal {
    fn baby_name() -> String;
}

struct Dog;

impl Dog {
    fn baby_name() -> String {
        String::from("Spot")
    }
}

impl Animal for Dog {
    fn baby_name() -> String {
        String::from("puppy")
    }
}

pub fn print_fully_qualified_syntax() {
    println!("A baby dog is called a {}", <Dog as Animal>::baby_name());
}

/*
Supertraits

Sometimes, you might need one trait to use another trait’s functionality.
In this case, you need to rely on the dependent traits also being implemented.
The trait you rely on is a supertrait of the trait you’re implementing.Sometimes,
you might need one trait to use another trait’s functionality. In this case, you
need to rely on the dependent traits also being implemented. The trait you rely on
is a supertrait of the trait you’re implementing.

Supertrait Example:

In the implementation of outline_print, we want to use the Display trait’s functionality.

Therefore, we need to specify that the OutlinePrint trait will work only for types
that also implement Display and provide the functionality that OutlinePrint needs.
We can do that in the trait definition by specifying OutlinePrint: Display.
use std::fmt;

Because we’ve specified that OutlinePrint requires the Display trait, we can use the
to_string function that is automatically implemented for any type that implements Display.
*/

// Examples not tested, may not work.
use std::fmt;

// outline_print
trait OutlinePrint: fmt::Display {
    fn outline_print(&self) {
        let output = self.to_string();
        let len = output.len();
        println!("{}", "*".repeat(len + 4));
        println!("*{}*", " ".repeat(len + 2));
        println!("* {} *", output);
        println!("*{}*", " ".repeat(len + 2));
        println!("{}", "*".repeat(len + 4));
    }
}

// Using Display for Point
impl fmt::Display for Point {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "({}, {})", self.x, self.y)
    }
}

/*
The Orphan Rule and Newtype

Orphan Rule states we’re allowed to implement a trait on a type as long as either the
trait or the type are local to our crate. It’s possible to get around this restriction
using the newtype pattern, which involves creating a new type in a tuple struct.

The tuple struct will have one field and be a thin wrapper around the type we want
to implement a trait for. Then the wrapper type is local to our crate, and we can implement
the trait on the wrapper. Newtype is a term that originates from the Haskell programming
language. There is no runtime performance penalty for using this pattern, and the wrapper
type is elided at compile time.
*/

/*
The implementation of Display uses self.0 to access the inner Vec<T>, because Wrapper is
a tuple struct and Vec<T> is the item at index 0 in the tuple. Then we can use the
functionality of the Display type on Wrapper.

The downside of using this technique is that Wrapper is a new type, so it doesn't
have the methods of the value it’s holding.

We would have to implement all the methods of Vec<T> directly on Wrapper such that the
methods delegate to self.0, which would allow us to treat Wrapper exactly like a Vec<T>.
*/
struct Wrapper(Vec<String>);

impl fmt::Display for Wrapper {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "[{}]", self.0.join(", "))
    }
}

pub fn print_wrapper() {
    let w = Wrapper(vec![String::from("hello"), String::from("world")]);
    println!("w = {}", w);
}
