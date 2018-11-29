/*
Smart Pointers

All Code and Definitions from:
https://doc.rust-lang.org/book/2018-edition/ch15-00-smart-pointers.html
https://doc.rust-lang.org/book/2018-edition/ch15-01-box.html
https://doc.rust-lang.org/book/2018-edition/ch15-02-deref.html
https://doc.rust-lang.org/book/2018-edition/ch15-03-drop.html

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

*/


fn hello(name: &str) {
    println!("Hello, {}!", name);
}

fn call_hello_with_my_box() {
    let m = MyBox::new(String::from("Rust"));
    hello(&m);
}

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
    let c = CustomSmartPointer { data: String::from("my stuff") };
    let d = CustomSmartPointer { data: String::from("other stuff") };
    println!("CustomSmartPointers created.");
}

/*
Cleaning up a value early using std::mem::drop

The std::mem::drop function is different than the drop method in the Drop trait.
We call it by passing the value we want to force to be dropped early as an argument.
*/
fn clean_up_drop_value_early() {
    let c = CustomSmartPointer { data: String::from("some data") };
    println!("CustomSmartPointer created.");
    drop(c);
    println!("CustomSmartPointer dropped before the end of main.");
}