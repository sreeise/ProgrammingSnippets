/*
Trait Objects that Allow for Values of Different Types

Code and Definitions may be from:
https://doc.rust-lang.org/book/ch17-02-trait-objects.html?highlight=trait,objects#object-safety-is-required-for-trait-objects


Trait Object:

    1. Points to an instance of a type that implements the trait we specify.
    2. Create a trait object by specifying some sor of pointer, such as a &
        reference or a Box<T> smart pointer, and then specifying the relevant
        trait, and add a dyn keyword.
    3. Trait objects must use a pointer.
    4. Can be used in place of a generic or concrete type.
    5. Rust's type system will ensure at compile time that any value used in that
        context will implement the trait object's trait. Therefore all possible
        types need to be known at compile time.

*/

// Trait that will be used as a trait object.
pub trait Draw {
    fn draw(&self);
}

// Screen takes a vec of the smart pointer Box<T> holding the keyword dyn and
// the trait Draw
pub struct Screen {
    pub components: Vec<Box<dyn Draw>>,
}

impl Screen {
    pub fn run(&self) {
        for component in self.components.iter() {
            component.draw();
        }
    }
}

#[derive(Debug)]
pub struct Button {
    pub width: u32,
    pub height: u32,
    pub label: String,
}

impl Draw for Button {
    fn draw(&self) {
        println!("\nDrawing a button");
        println!("Button Width: {}", self.width);
        println!("Button Height: {}", self.height);
        println!("Button Label: {}\n", self.label);
    }
}

#[derive(Debug)]
struct SelectBox {
    width: u32,
    height: u32,
    options: Vec<String>,
}

impl Draw for SelectBox {
    fn draw(&self) {
        println!("\nDrawing a SelectBox\nSelectBox Width: {}\nSelectBox Height: {}\n",
                 self.width,
                 self.height
        );


        for item in self.options.iter() {
            println!("SelectBox Option: {}", item);
        }
    }
}

/*
The Screen components field has both SelectBox and Button. The Screen
doesn't need to know the concrete types in the Vec. In other words the
 Screen doesn't need to know that it holds a SelectBox or Button, only
that it will call the draw method. This is possible because both SelectBox
and Button implement the Draw trait.

The run() method on Screen will call the draw() method for each type:
    ->  Drawing a SelectBox
        SelectBox Width: 75
        SelectBox Height: 10

        SelectBox Option: Yes
        SelectBox Option: Maybe
        SelectBox Option: No

        Drawing a button
        Button Width: 50
        Button Height: 10
        Button Label: Ok

*/
pub fn start() {
    let screen = Screen {
        components: vec![
            Box::new(SelectBox {
                width: 75,
                height: 10,
                options: vec![
                    String::from("Yes"),
                    String::from("Maybe"),
                    String::from("No")
                ],
            }),
            Box::new(Button {
                width: 50,
                height: 10,
                label: String::from("Ok"),
            })
        ],
    };

    // Screen run() method calls draw() on both SelectBox and Button
    screen.run();
}
