/*
Printing, Variables, Returning values

All Code and Definitions from:
https://doc.rust-lang.org/book/2018-edition/ch03-01-variables-and-mutability.html
https://doc.rust-lang.org/book/2018-edition/ch03-02-data-types.html
https://doc.rust-lang.org/book/2018-edition/ch03-03-how-functions-work.html

This module focuses on the basics of printing to the console,
creating variables and a few of their types, and returning
a value in a function.
*/

use std::io;

// Method on printing to the terminal/console.
fn printing() {
    // Basic print statement with common Hello World!.
    println!("Hello, world!");

    let x = 5;
    let y = 10;

    // Use {} to print variables.
    println!("x = {} and y = {}", x, y);
}

// Number types
fn floating_point_and_integers() {
    // Integers
    let i = 1; // i32

    // Floating point types
    let x = 2.0; // f64

    let y: f32 = 3.0; // f32
}

// Variables can be either mutable or immutable. Meaning
// if they are mutable, they can be change. If they are
// immutable they cannot be changed.
#[allow(unused_mut)] // Allow mutable variable that does not change for example.
fn mutable_and_immutable_variables() {
    // Mutable variable
    let mut num = 3;
    println!("Immutable Variable: {}", num);

    // Immutable variable.
    let num2 = 3;
    println!("Mutable Variable: {}", num2);
}

fn shadow() {
    // Shadowing variables using let <variable>
    let x = 5;
    let x = x + 1;
    let x = x * 2;

    println!("x is: {}", x); // -> 12
}

// User input
fn usr_input() {
    println!("Enter a number to print");

    // String where the number entered will be stored.
    // Must be mutable so the String can be changed to add
    // the number/user input.
    let mut num = String::new();

    // .read_line(&mut guess), calls the read_line method
    // on the standard input handle to get input
    // The expect line is for error handling. It will
    // cause the program to crash and display an error message.
    io::stdin()
        .read_line(&mut num)
        .expect("Failed to read line");

    println!("You Entered: {}", num);
}

// The -> symbol points to the values we want to return,
// and the types of values follow
fn returning_values() -> i32 {
    // A 5 with no semicolon indicates the return value
    // Using a semicolon here would turn it into an expression
    // instead of a return value
    5
}