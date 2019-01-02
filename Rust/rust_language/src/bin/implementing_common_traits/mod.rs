/*
Implementing Common Traits in Rust

Definitions and Code and be from:
https://doc.rust-lang.org/std/fmt/trait.Debug.html
https://doc.rust-lang.org/std/fmt/struct.Formatter.html

Rust has common traits such as Debug and Display. These can be
manually implemented.
*/

use std::fmt;

/*
Implementing Display and Debug

Implementing Debug and Display can use the std::fmt::Formatter crate in the standard library:

    https://doc.rust-lang.org/std/fmt/struct.Formatter.html
*/

struct Position {
    longitude: f32,
    latitude: f32,
}

/*
Implementing Display for Position
*/
impl fmt::Display for Position {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "({}, {})", self.longitude, self.latitude)
    }
}

struct Point {
    x: i32,
    y: i32,
}

/*
Implementing Debug for Point
*/
impl fmt::Debug for Point {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "Point {{ x: {}, y: {} }}", self.x, self.y)
    }
}

// Using Display and Debug
fn print_position_debug() {
    let position = Position {
        longitude: 2.0,
        latitude: 2.1
    };

    // Using Debug
    let origin = Point { x: 0, y: 0 };
    println!("The origin is: {:?}", origin); // -> The origin is: Point { x: 0, y: 0 }

    // Using Display
    assert_eq!("(1.987, 2.983)".to_owned(),
               format!("{}", Position { longitude: 1.987, latitude: 2.983, }));
}
