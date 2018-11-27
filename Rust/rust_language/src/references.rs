// https://doc.rust-lang.org/book/2018-edition/ch04-02-references-and-borrowing.html

fn main() {
    let s1 = String::from("hello");

    // The ampersand: & is a reference.
    // References allow referring to a value
    // without taking ownership of it.
    let len = calculate_length(&s1);

    println!("The length of '{}' is {}", s1, len);
}

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