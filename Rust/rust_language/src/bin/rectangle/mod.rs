// https://doc.rust-lang.org/book/2018-edition/ch05-03-method-syntax.html

// Using Structs
#[derive(Debug)] // use derive(debug) to opt into default formatting for println!
pub struct Rectangle {
    pub width: u32,
    pub height: u32,
}

impl Rectangle {
    // Get the area of the Rectangle
    pub fn area(&self) -> u32 {
        self.width * self.height
    }

    // Print true if the referenced Rectangle can hold
    // the values of another Rectangle
    pub fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }

    // Functions that do not use self as a parameter are called
    // associated functions.

    // Called by: let sq = Rectangle::square(3);
    fn square(size: u32) -> Rectangle {
        Rectangle { width: size, height: size }
    }
}
