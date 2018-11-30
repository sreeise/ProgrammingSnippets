extern crate rand;

use std::io;
use std::cmp::Ordering; // Cmp for comparing values.
use self::rand::Rng; // For ranges in looping

fn while_loops() {
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
}

fn array_iter_loops() {
    // Loop with array iter()
    let a = [10, 20, 30, 40, 50];

    for element in a.iter() {
        println!("the value is: {}", element);
    }
}

// Loop with range and using rev() to reverse the range
fn range_loop() {
    let mut number = 3;


    for number in (1..4).rev() {
        println!("{}!", number);
    }
    println!("LIFTOFF!!!");
}

/*
Matching and loops in matching
*/

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
