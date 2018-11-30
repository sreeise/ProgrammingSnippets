/*
The Rust Programming Language

Goes over the main features of Rust
All Code and Definitions from the Rust Programming Language book:
https://doc.rust-lang.org/book/2018-edition/ch00-00-introduction.html

The main.rs file is where the main function resides and is the
start of program execution.

Directories are organized into modules defined by
their name. Below are the list of modules with the mod
keyword for their names.

Most of the code resides in each of these modules.
In order to use this code in the actual program they
must be called in the main function.
*/
#![allow(dead_code)] // Allow dead code across entire crate
#![allow(unused_variables)] // Allow unused variables across entire cate

// Modules for the different language features of Rust
mod input_output_variables;
mod arrays_tuples;
mod loops_matching;
mod using_crates;
mod enum_types;
mod ownership;
mod collection_types;
mod closures_iterators;
mod handling_errors;
mod generics_traits_lifetimes;
mod borrowing_references;
mod automated_testing;
mod smart_pointers;
mod concurrency;
mod state_pattern;
mod match_expressions_patterns;

// Main method
// Functions/Methods start with fn and use snake casing, where
// methods with two words are separated by an underline and
// are all lowercase.
fn main() {
    // Basic print statement with common Hello World!.
    println!("Hello, world!");
}