/*
Impl Trait.

Code and definitions may be from:
    1. https://doc.rust-lang.org/edition-guide/rust-2018/trait-system/impl-trait-for-returning-complex-types-with-ease.html


impl Trait is the new way to specify unnamed but concrete types that implement a
specific trait. There are two places you can put it: argument position, and return
position.
*/

// Define a simple trait and impl it for i32 and i64
trait NumberTrait {

}

impl NumberTrait for i32 {}

// Pass the NumberTrait as an argument:
fn num(arg: impl NumberTrait) {}

// Passing NumberTrait as an argument using impl trait is
// pretty much the same as using a bound on a generic type:
fn num_bound<T: NumberTrait>(arg: T) {}


// You can also return impl traits. You could also do this
// with the dyn trait syntax but the Rust reference notes
// that the dyn trait syntax requires returning a pointer
// such as box which incurs overhead due to having to
// perform heap allocation and dynamic dispatch. Since the
// NumberTrait here only ever returns one type we can use
// impl NumberTrait which will take advantage of static
// dispatch instead.
fn get_five() -> impl NumberTrait {
    5
}

// Using closures and impl trait.

// Closures can be returned for the impl trait syntax. Consider
// the following impl of NumberTrait for the Fn closure:
pub trait AddNum {
    fn add(&mut self, num: i32) -> i32;
}

impl<F> AddNum for F where F: Fn(i32) -> i32 {
    fn add(&mut self, num: i32) -> i32 {
        self(num)
    }
}

// This allows the function to returning a closure that will be an impl
// of the add method for the AddNum trait.
fn perform_addition() -> impl AddNum {
    move |mut num: i32| {
        num += 1;
        num
    }
}

fn print_add_num() {
    let num = perform_addition().add(3);
    println!("{:#?}", num); // => 4
}






