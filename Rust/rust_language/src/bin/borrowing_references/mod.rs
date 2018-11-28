/*
Definitions and Code from:
https://doc.rust-lang.org/book/2018-edition/ch04-02-references-and-borrowing.html
*/

/*
References: &
Allow you to refer to some value without taking ownership of it

    1. We don’t drop what the reference points to when it goes out of
        scope because we don’t have ownership.
    2. When functions have references as parameters instead of the actual values,
        we won’t need to return the values in order to give back ownership,
        because we never had ownership.
    3. The compiler guarantees that references will never be dangling references:
        if you have a reference to some data, the compiler will ensure that the
        data will not go out of scope before the reference to the data does.
    4. A reference cannot refer to a value such as a String that is created
        within the same scope. This value will get deallocated.
    5. You can have either one mutable reference or multiple immutable references
        but not both at the same time.
    6. String slices are references

Borrowing: References as parameters

    1. You can only have one mutable reference to a particular piece of
        data in a particular scope.
*/


fn run_calculate() {
    let s1 = String::from("hello");
    let len = calculate_length(&s1);

    println!("The length of '{}' is {}", s1, len);
}

/*
Normally s would case to exist after the function returns, however,
since we are using a reference: &String, nothing happens.
*/
fn calculate_length(s: &String) -> usize {
    s.len()
}

// References mean that the value is being borrowed
// and therefore cannot be modified. This is known
// as borrowing

// In order to change the value we need to use mutable references
// Within the scope there can only be one mutable reference at a time.
// This would fail if there were two references to s.
fn change_string() {
    let mut s = String::from("hello");
    change(&mut s);
}

fn change(some_string: &mut String) {
    some_string.push_str(", world");
}

// Creating new scope in a function to use references
fn scoped_references() {
    let mut s = String::from("hello");

    {
        let r1 = &mut s;

    } // r1 goes out of scope here, so we can make a new reference with no problems.

    let r2 = &mut s;
}

/*
Lifetimes:

Definitions and Code from:
https://doc.rust-lang.org/book/2018-edition/ch10-03-lifetime-syntax.html

    1. The main aim of lifetimes is to prevent dangling references,
        which cause a program to reference data other than the data
        it’s intended to reference.

Lifetime Annotations
Describe the relationships of the lifetimes of multiple references to
each other without affecting the lifetimes.

    1. The names of lifetime parameters must start with an apostrophe (')
        and are usually all lowercase and very short, like generic types.
        Examples:
        &i32        // a reference
        &'a i32     // a reference with an explicit lifetime
        &'a mut i32 // a mutable reference with an explicit lifetime
    2. One lifetime annotation by itself doesnt have much meaning, because the
        annotations are meant to tell Rust how generic lifetime parameters of
        multiple references relate to each other
    3. As with generic type parameters, we need to declare generic lifetime parameters
        inside angle brackets between the function name and the parameter list.
    4. When annotating lifetimes in functions, the annotations go in the function
        signature, not in the function body.
    5. When a function has references to or from code outside that function,
        it becomes almost impossible for Rust to figure out the lifetimes of the
        parameters or return values on its own. The lifetimes might be different
        each time the function is called. This is why we need to annotate the
        lifetimes manually.
    6. When returning a reference from a function, the lifetime parameter for
        the return type needs to match the lifetime parameter for one of the parameters.
        If the reference returned does not refer to one of the parameters, it must refer
        to a value created within this function, which would be a dangling reference because
        the value will go out of scope at the end of the function
    7. Lifetimes are of generic types and go in the same angle brackets as other generics
        such as T
*/

/*
The <`a> before the parameter list requires that all
references in the function have the same lifetime.

When we pass concrete references to longest, the concrete lifetime that
is substituted for 'a is the part of the scope of x that overlaps with the
scope of y. In other words, the generic lifetime 'a will get the concrete
lifetime that is equal to the smaller of the lifetimes of x and y.
Because we’ve annotated the returned reference with the same lifetime
parameter 'a, the returned reference will also be valid for the length
of the smaller of the lifetimes of x and y.
*/
fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}

fn using_longest_for_lifetime_parameters() {
    let string1 = String::from("long string is long");

    {
        let string2 = String::from("xyz");
        let result = longest(string1.as_str(), string2.as_str());
        println!("The longest string is {}", result);
    }
}

/*
Structs and Lifetimes

lifetime elision rules.
These aren't rules for programmers to follow; they’re a set of particular
cases that the compiler will consider, and if your code fits these cases,
you don’t need to write the lifetimes explicitly.

    1. The elision rules don’t provide full inference. If Rust
        deterministically applies the rules but there is still ambiguity
        as to what lifetimes the references have, the compiler won’t guess
        what the lifetime of the remaining references should be.

Input Lifetimes
Known as lifetimes on function or method parameters

Output Lifetimes
Known as lifetimes on return values

    1. The compiler uses three rules to figure out what lifetimes references
        have when there aren't explicit annotations. The first rule applies
        to input lifetimes, and the second and third rules apply to output lifetimes.

Lifetime Rules:

    1. The first rule is that each parameter that is a reference gets its
        own lifetime parameter. In other words, a function with one parameter gets
        one lifetime parameter: fn foo<'a>(x: &'a i32). a function with two parameters gets
        two separate lifetime parameters: fn foo<'a, 'b>(x: &'a i32, y: &'b i32); and so on
    2. The second rule is if there is exactly one input lifetime parameter, that
        lifetime is assigned to all output lifetime parameters:
        fn foo<'a>(x: &'a i32) -> &'a i32.
    3. The third rule is if there are multiple input lifetime parameters, but one of
        them is &self or &mut self because this is a method, the lifetime of self is
        assigned to all output lifetime parameters. This third rule makes methods much
        nicer to read and write because fewer symbols are necessary.


Static Lifetimes
Denotes the entire duration of the program.

    1. All string literals have `static lifetimes.
        Example:
        let s: &'static str = "I have a static lifetime.";
*/

/*
A function where lifetime is inferred by the Rust compiler

In earlier days of Rust, this function would be written as:
    fn first_word<`a>(s: &<`a> str) -> &<`a> str { ... }

Explanation:
    After writing a lot of Rust code, the Rust team found that Rust
    programmers were entering the same lifetime annotations over and over in
    particular situations. These situations were predictable and followed a
    few deterministic patterns. The developers programmed these patterns into
    the compiler’s code so the borrow checker could infer the lifetimes in these
    situations and wouldn't need explicit annotations.
*/
fn first_word(s: &str) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }

    &s[..]
}


/*
A struct that holds a reference, so its definition needs a lifetime annotation

    1. Where we declare and use the lifetime parameters depends on whether they’re
        related to the struct fields or the method parameters and return values.
    2. Lifetime names for struct fields always need to be declared after the impl
        keyword and then used after the struct’s name, because those lifetimes are
        part of the struct’s type.
    3. The lifetime parameter declaration after impl and use after the type name is
        required, but we’re not required to annotate the lifetime of the reference to
        self because of the first elision rule.

This annotation means an instance of ImportantExcerpt can’t outlive the
reference it holds in its part field.
*/
struct ImportantExcerpt<'a> {
    part: &'a str,
}

impl<'a> ImportantExcerpt<'a> {
    fn level(&self) -> i32 {
        3
    }
}

/*
Struct impl example where the third lifetime rule applies

    1. There are two input lifetimes, so Rust applies the first lifetime
        elision rule and gives both &self and announcement their own lifetimes.
    2. Because one of the parameters is &self, the return type gets the lifetime
        of &self, and all lifetimes have been accounted for.
*/
impl<'a> ImportantExcerpt<'a> {
    fn announce_and_return_part(&self, announcement: &str) -> &str {
        println!("Attention please: {}", announcement);
        self.part
    }
}


/*
Using Generic Types, Trait Bounds, and Lifetimes together

    1. This is the longest function that returns the longer of two string slices.
        But now it has an extra parameter named ann of the generic type T, which
        can be filled in by any type that implements the Display trait as specified
        by the where clause.
    2.  This extra parameter will be printed before the function compares the
        lengths of the string slices, which is why the Display trait bound is necessary.
    3.  Because lifetimes are a type of generic, the declarations of the lifetime parameter
        'a and the generic type parameter T go in the same list inside the angle brackets
        after the function name.
*/

use std::fmt::Display;

fn longest_with_an_announcement<'a, T>(x: &'a str, y: &'a str, ann: T) -> &'a str
    where T: Display
{
    println!("Announcement! {}", ann);
    if x.len() > y.len() {
        x
    } else {
        y
    }
}