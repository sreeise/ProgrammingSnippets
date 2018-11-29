/*
Crates must be pulled in using keywords: extern crate

See README.md for information on crates.

All Code and Definitions are from:
https://doc.rust-lang.org/book/2018-edition/ch14-00-more-about-cargo.html
*/

extern crate rand; // For random numbers.

// Pull in different parts form create rand.
use rand::Rng;

// Random number guessing game.
// You can use anything in the Rand Crate by placing rand:: before it.
fn random_numbers() {
    println!("Guess the number!");

    // rand::thread_rng function will give us the particular random number
    // generator that we’re going to use: one that is local to the
    // current thread of execution and seeded by the operating system.
    // The gen_range method takes two numbers as arguments and generates
    // a random number between them.
    let random_num = rand::thread_rng().gen_range(1, 101);

    println!("The random number between 1 and 100 is: {}", random_num);
}