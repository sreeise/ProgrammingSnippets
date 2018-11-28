mod rectangle; // Define the rectangle module for the rectangle directory
mod enum_types;
mod collection_types;
mod handling_errors;
mod generics_traits_lifetimes;
mod borrowing_references;

extern crate rand; // For random numbers.

use std::io;
use std::cmp::Ordering; // Cmp for comparing values.
use rand::Rng;
use self::rectangle::Rectangle; // using self to reference a module defined within

// Main method
// Functions/Methods start with fn and use snake casing, where
// methods with two words are separated by an underline and
// are all lowercase.
fn main() {
    // Basic print statement with common Hello World!.
    println!("Hello, world!");

    // Call another method by calling it's name with parenthesis.
    printing(); // Method on printing to the terminal/console.
    variable(); // Method for creating variables;
    usr_input(); // Method for getting and printing user input.
    random_numbers(); // Print random number between 1 and 101
    shadow();
    tuples();
    arrays();
    using_structs();

    // Keep these last so methods that don't possibly last forever
    // can run.
    println!("\nThe next methods are guessing games. Feel free to press CTRL C to quit.\n");
    guessing_game(); // Guessing game
    guessing_game_loop(); // Guessing game on loop.

    // Floating point types
    let x = 2.0; // f64

    let y: f32 = 3.0; // f32
}

fn printing() {
    let x = 5;
    let y = 10;

    // Use {} to pring variables.
    println!("x = {} and y = {}", x, y);
}

// Variables
fn variable() {
    // Let declares a variable, and mut declares the variable as mutable

    // Mutable variable
    let mut num = 3;
    println!("Immutable Variable: {}", num);

    // Immutable variable.
    let num2 = 3;
    println!("Mutable Variable: {}", num2);
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

// Using the rand crate. See README.md for information on crates, as well as
// https://doc.rust-lang.org/book/2018-edition/ch14-00-more-about-cargo.html
// At the top of this file the Rand Crate has been added:
//      extern crate rand;
//      use rand::Rng;
// The Rng trait defines methods that random number generators implement
//


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


fn guessing_game() {
    let secret_number = rand::thread_rng().gen_range(1, 101);

    println!("The secret number is: {}", secret_number);

    println!("Please input your guess.");

    let mut guess = String::new();

    io::stdin().read_line(&mut guess)
        .expect("Failed to read line");

    // Declaring the variable guess again here will shadow
    // the previous variable, letting use use it again. Because
    // everything on the right side of the = happens first, we will
    // Still get the correct number.
    // .trim removes empty space and removes issues with parsing like newline \n.
    // .parse parses the number from the string.
    // .expect is for errors/exceptions.
    let guess: u32 = guess.trim().parse()
        .expect("Please type a number!");

    println!("You guessed: {}", guess);

    match guess.cmp(&secret_number) {
        Ordering::Less => println!("Too small!"),
        Ordering::Greater => println!("Too big!"),
        Ordering::Equal => println!("You win!"),
    }
}

fn guessing_game_loop() {
    // \n means print on a new line. Adds a blank space
    // between previous and next lines.
    println!("\n");
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1, 101);

    // Allow entering a guess until user correctly guesses number, or CTRL C to quit.
    loop {
        println!("Please input your guess.");

        let mut guess = String::new();

        io::stdin().read_line(&mut guess)
            .expect("Failed to read line");

        // The underscore in Err(_) matches all error values.
        // and allows continuing through execution
        // if a wrong type has been entered.
        // This must be used inside a loop or an error is thrown.
        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };

        println!("You guessed: {}", guess);

        // The break statement will end the method execution
        // When the user has guessed the correct number.
        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }

        println!("\nEnter CTRL C to quit.\n")
    }
}

fn shadow() {
    // Shadowing variables using let <variable>
    let x = 5;
    let x = x + 1;
    let x = x * 2;

    println!("x is: {}", x); // -> 12
}

fn tuples() {
    // Tuples are fixed length groups that can contain multiple types
    let tup = (500, 6.4, 1);

    // Destructuring a tuple and assigning the values to variables
    let (x, y, z) = tup;

    println!("The value of x is: {}", x);
    println!("The value of y is: {}", y);
    println!("The value of z is: {}", z);

    // Accessing tuples through . notation
    let x: (i32, f64, u8) = (500, 6.4, 1);

    let five_hundred = x.0;

    let six_point_four = x.1;

    let one = x.2;
    println!("The value of one is: {}", one);
    println!("The value of five_hundred is: {}", five_hundred);
    println!("The value of six_point_four is: {}", six_point_four);
}

fn arrays() {
    // Arrays in Rust are fixed size like tuples
    // Array are represented by single chunks of memory on the stack.

    // The type shown here is [i32, 4]
    let arr = [1, 2, 3, 4];
    let first = arr[0];
    let last = arr[3];
    println!("The value of first is: {}", first);
    println!("The value of last is: {}", last);
}

fn conditional_statements() {
    let condition = true;
    // Set number to 5 if the boolean condition variable is true
    // and 6 if false
    let number = if condition {
        5
    } else {
        6
    };

    // Print the number
    println!("The value of number is: {}", number);
}

fn loop_statements() {
    // while loop
    let mut number = 3;

    // If the number is not 0 print the number
    // and subtract 1 from the number
    while number != 0 {
        println!("{}!", number);

        number = number - 1;
    }

    println!("LIFTOFF!!!");

    let a = [10, 20, 30, 40, 50];
    let mut index = 0;

    while index < 5 {
        println!("the value is: {}", a[index]);

        index = index + 1;
    }

    // Loop with array iter()
    let a = [10, 20, 30, 40, 50];

    for element in a.iter() {
        println!("the value is: {}", element);
    }

    // Loop with range and using rev() to reverse the range
    for number in (1..4).rev() {
        println!("{}!", number);
    }
    println!("LIFTOFF!!!");
}

// The -> symbol points to the values we want to return,
// and the types of values follow
fn returning_values() -> i32 {
    // A 5 with no semicolon indicates the return value
    // Using a semicolon here would turn it into an expression
    // instead of a return value
    5
}

fn stack_vs_heap() {
    // Create a string s1 and then set variable s2 to s1
    let s1 = String::from("hello");
    let s2 = s1;

    print!("The value of s2 is {}", s2); // --> hello
    // s2 prints fine, but printing s1 would cause an error
    // Having two pointers to the same value can cause memory
    // corruption. Since both s1 and s2 are in the same scope
    // Rust invalidates the reference to s1, and at the end
    // of the scope Rust only has to clean up memory from s2.
    // This happens because Rust copies only the stack data
    // instead of the heap and the stack data.
    // Use clone to deep copy a variable instead.

    // Deep copy of a variable using clone()
    // -> NEEDS FIX
    // let s3 = String::from("hello");
    // let s4 = s1.clone();

    // println!("s1 = {}, s2 = {}", s3, s4);

    // See next function - without_ownership() as well.
}

fn without_ownership() {
    let s1 = String::from("hello");

    let (s2, len) = calculate_length(s1);

    println!("The length of '{}' is {}.", s2, len);
}

fn calculate_length(s: String) -> (String, usize) {
    let length = s.len(); // len() returns the length of a String

    (s, length)
}

// Structs
fn using_structs() {
    let rect = Rectangle { width: 3, height: 2 };
    println!("The area of the rectangle is {} square pixels.", rect.area());
}