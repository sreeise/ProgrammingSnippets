/*
Command Line Program in Rust

All Code and Definitions are from:
https://doc.rust-lang.org/book/2018-edition/ch12-01-accepting-command-line-arguments.html

Info:
    1. Note that std::env::args will panic if any argument contains invalid Unicode.
        If your program needs to accept arguments containing invalid Unicode, use
        std::env::args_os instead. That function returns an iterator that produces
        OsString values instead of String values.
   2. The clone() method is useful if it is not called that often. clone() has runtime
        costs that penalize a program for calling the method repeatedly.

Definitions:

    1. fs::read_to_string()
        Takes the filename, open that file, and then produce a new String with its contents.
    2. unwrap_or_else()
        Defined on Result<T, E> by the standard library. Allows us to define some custom,
        non-panic! error handling. If the Result is an Ok value, this method’s behavior is
        similar to unwrap: it returns the inner value Ok is wrapping. However, if the value
        is an Err value, this method calls the code in the closure, which is an anonymous f
        unction we define and pass as an argument to unwrap_or_else
    3. Box<dyn Error>
        Means the function will return a type that implements the Error trait,
        but we don’t have to specify what particular type the return value will be.
        This gives us flexibility to return error values that may be of different types
        in different error cases. This is what the dyn means, it's short for "dynamic."
    4. ?
        Will return the error value from the current function for the caller to handle.
    5. The () type. See https://doc.rust-lang.org/std/primitive.unit.html
        Known as the unit type. Has exactly one value (), and is used when there is
        no other meaningful value that could be returned. Most commonly seen implicitly:
        functions without a -> ... implicitly have return type (), that is, these are equivalent:
            fn long() -> () {}
            fn short() {}
    6. Ok(())
        The unit type () wrapped in the Ok() is the idiomatic way to indicate that we’re
        calling run for its side effects only; it doesn't return a value we need.
    7. if...let with Err()
        Checks whether the given function returns an Err value. If an Err value is
        returned the code inside the brackets is run.
    8. lines()
        Returns and iterator and handles line by line iteration of strings.
    9. contains()
        String method to check if a string contains the given argument

*/

extern crate minigrep;

use minigrep::Config;
use std::env; // For getting command line arguments
use std::error::Error; // For error handling
use std::process; // For exiting in error events

fn main() {
    let config = Config::new(env::args()).unwrap_or_else(|err| {
        eprintln!("Problem parsing arguments: {}", err);
        process::exit(1);
    });

    println!("Searching for {}", config.query);
    println!("In file {}", config.filename);

    if let Err(e) = minigrep::run(config) {
        println!("Application error: {}", e);

        process::exit(1);
    }
}
