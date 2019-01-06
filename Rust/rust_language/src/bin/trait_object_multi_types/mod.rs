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

Runtime Costs

    The are two types of ways in which Rust monomorephizing that Rust does:
        1. Static Dispatch: The compiler generates non-generic implementations
            of functions and methods for each concrete type that is used in place
            of a generic type parameter.
        2. Dynamic Dispatch: The compiler can't tell at compile time which method you
            are calling at compile time so the compiler emits code that at runtime will
            figure out which method to call.

Trait Objects use Dynamic Dispatch. At runtime, Rust uses the pointers inside the trait
object to know which method to call. There is a runtime cost when this lookup happens
that doesn't occur with static dispatch. Dynamic dispatch also prevents the compiler from
choosing to inline a method's code, which in turn prevents some optimizations.


Trait Objects Require Object Safety

You can only make object-safe traits into trait objects. In practice there are
two relevant rules:

        1. The return type isn't Self.
        2. There are no generic type parameters.


The Self keyword is an alias for the type we’re implementing the traits or methods on.
Trait objects must be object safe because once you’ve used a trait object, Rust no
longer knows the concrete type that’s implementing that trait. If a trait method returns
the concrete Self type, but a trait object forgets the exact type that Self is, there is
no way the method can use the original concrete type. The same is true of generic type
parameters that are filled in with concrete type parameters when the trait is used: the
concrete types become part of the type that implements the trait. When the type is forgotten
through the use of a trait object, there is no way to know what types to fill in the generic
type parameters with.

Information on Object Safety can be found here:

    https://github.com/rust-lang/rfcs/blob/master/text/0255-object-safety.md
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
