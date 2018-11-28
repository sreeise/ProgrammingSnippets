// https://doc.rust-lang.org/book/2018-edition/ch06-01-defining-an-enum.html

// Includes Enums and Matches

enum IpAddr {
    V4(u8, u8, u8, u8),
    V6(String),
}

// Instead of null values, Rust uses the enum: Option<T>
// which represents a value being present or absent
// <T> (Generic Type) means the Some variant of the Option enum can hold
// one piece of data of any type.

// You have to convert an Option<T> to a T before you can perform T operations with it.

/*
The standard Rust library shows the Option<T> as:

enum Option<T> {
    Some(T),
    None,
}

If we use None rather than Some, we need to tell Rust what type of Option<T> we have,
because the compiler can’t infer the type that the Some variant will hold by looking
only at a None value.

let some_number = Some(5);
let some_string = Some("a string");

let absent_number: Option<i32> = None;

In Rust an Option like so:

    let y: Option<i8>

Is not the same as:

    let x: i8

This is because i8 and Option<i8> are two different types.

Option methods:
https://doc.rust-lang.org/std/option/enum.Option.html
*/
/*
// Math enum
enum Coin {
    Penny,
    Nickel,
    Dime,
    Quarter,
}

fn value_in_cents(coin: Coin) -> u32 {
    match coin {
        Coin::Penny => 1,
        Coin::Nickel => 5,
        Coin::Dime => 10,
        Coin::Quarter => 25,
    }
}

// Option match
fn plus_one(x: Option<i32>) -> Option<i32> {
    match x {
        None => None,
        Some(i) => Some(i + 1),
    }
}

fn match_up_to_255() {
    let some_u8_value = 0u8;
    match some_u8_value {
        1 => println!("one"),
        3 => println!("three"),
        5 => println!("five"),
        7 => println!("seven"),
        _ => (),
    }
}

fn if_let_vs_pattern() {
    let some_u8_value = Some(0u8);
    match some_u8_value {
        Some(3) => println!("three"),
        _ => (),
    }
    // is the same as

    if let Some(3) = some_u8_value {
        println!("three");
    }

    // if...let...else
    let mut count = 0;
    if let Coin::Quarter(state) = coin {
        println!("State quarter from {:?}!", state);
    } else {
        count += 1;
    }
}

*/