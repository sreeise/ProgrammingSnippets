/*
Advanced Traits

All Code and Definitions from:
https://doc.rust-lang.org/book/2018-edition/ch19-04-advanced-types.html
*/

/*
Type Alias

Rust provides the ability to declare a type alias to give an existing type another name.
The main use case for type synonyms is to reduce repetition.
*/

/*
Kilometers is a synonym for i32 not a separate, new type.
Values that have the type Kilometers will be treated the same as values of type i32.

However, using this method, we don’t get the type checking benefits that we get
from the newtype pattern.
*/
fn type_alias() {
    type Kilometers = i32;

    let x: i32 = 5;
    let y: Kilometers = 5;

    println!("x + y = {}", x + y);
}

/*
Using Type Alias for Shortening Names

I/O operations often return a  Result<T, E> to handle situations when operations
fail to work. This library has a std::io::Error struct that represents all possible
I/O errors. Many of the functions in std::io will be returning Result<T, E> where
the E is std::io::Error

use std::io::*;

pub trait Write {
    fn write(&mut self, buf: &[u8]) -> Result<usize>;
    fn flush(&mut self) -> Result<()>;

    fn write_all(&mut self, buf: &[u8]) -> Result<()>;
    fn write_fmt(&mut self, fmt: Arguments) -> Result<()>;
}
*/

/*
The Never Type and Diverging Functions

Rust has a special type named ! that’s known in type theory lingo as the empty
type because it has no values. We prefer to call it the never type because it
stands in the place of the return type when a function will never return.
*/
fn bar() -> ! {
    // --snip--
}

/*
match arms must all return the same type.

The type of guess in this code would have to be an integer and a string, and Rust
requires that guess have only one type.

Continue has a ! value. That is, when Rust computes the type of guess, it looks at both
match arms, the former with a value of u32 and the latter with a ! value. Because ! can
never have a value, Rust decides that the type of guess is u32.
*/
fn match_some_values() -> u32 {
    let guess: u32 = match guess.trim().parse() {
        Ok(num) => num,
        Err(_) => continue,
    };
    guess
}

/*
Dynamically Sized Types

Sometimes referred to as DSTs or unsized types, these types let us write code
using values whose size we can know only at runtime.

Dynamically sized types in they have an extra bit of metadata that stores the size
of the dynamic information. The golden rule of dynamically sized types is that we
must always put values of dynamically sized types behind a pointer of some kind.

Rust has a particular trait called the Sized trait to determine whether or not a type’s
size is known at compile time. This trait is automatically implemented for everything whose
size is known at compile time. In addition, Rust implicitly adds a bound on Sized to every
generic function. That is, a generic function definition like this:

fn generic<T>(t: T) {
    // --snip--
}

is actually treated as though we had written this:

fn generic<T: Sized>(t: T) {
    // --snip--
}

By default, generic functions will work only on types that have a known size at compile time.
However, you can use the following special syntax to relax this restriction:

fn generic<T: ?Sized>(t: &T) {
    // --snip--
}

A trait bound on ?Sized is the opposite of a trait bound on Sized: we would read this
as “T may or may not be Sized.” This syntax is only available for Sized, not any other traits.

Also note that we switched the type of the t parameter from T to &T. Because the type might
not be Sized, we need to use it behind some kind of pointer. In this case, we’ve chosen a
reference.
*/