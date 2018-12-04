/*
The Rust Programming Language

Goes over the main features of Rust
All Code and Definitions from:
    1. Rust Programming Language Book
        https://doc.rust-lang.org/book/2018-edition/ch00-00-introduction.html
    2. The Rust Standard Library Documentation
        https://doc.rust-lang.org/std/index.html
    3. The Little Book of Rust Macros
        https://danielkeep.github.io/tlborm/book/README.html
    4. Rust in Detail: Writing Scalable Chat Service from Scratch
        https://nbaksalyar.github.io/2015/07/10/writing-chat-in-rust.html
    5. Rust rosetta - Simple and complex tasks in Rust
        https://github.com/Hoverbear/rust-rosetta

The main.rs file is where the main function resides and is the
start of program execution.

Directories are organized into modules defined by
their name. Below are the list of modules with the mod
keyword for their names.

Most of the code resides in each of these modules.
In order to use this code in the actual program they
must be called in the main function. There are a few modules
enclosed in other modules and are not available to use
unless a pub keyword is added where needed.
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
mod vectors;
mod unsafe_rust; // Advanced feature
mod advanced_lifetimes; // Advanced feature
mod advanced_traits; // Advanced feature
mod advanced_types; // Advanced feature

// Main method
// Functions/Methods start with fn and use snake casing, where
// methods with two words are separated by an underline and
// are all lowercase.
fn main() {
    // Basic print statement with common Hello World!.
    println!("Hello, world!");
}