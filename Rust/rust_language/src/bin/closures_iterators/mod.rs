/*
Code and Definitions from:
https://doc.rust-lang.org/book/2018-edition/ch13-01-closures.html
https://github.com/ProgrammingRust/examples

Closures

        1. Rust’s closures are anonymous functions you can save in a variable
            or pass as arguments to other functions. You can create the closure in
            one place and then call the closure to evaluate it in a different context.
            Unlike functions, closures can capture values from the scope in which
            they’re called.
        2. Closures don’t require you to annotate the types of the
            parameters or the return value like fn functions do. Type
            annotations are required on functions because they’re part
            of an explicit interface exposed to your users.
        3. Closure definitions will have one concrete type inferred for each
            of their parameters and for their return value.
        4. To make a struct that holds a closure, we need to specify the type of
            the closure, because a struct definition needs to know the types of
            each of its fields. Each closure instance has its own unique anonymous
            type: that is, even if two closures have the same signature, their
            types are still considered different. To define structs, enums, or
            function parameters that use closures, we use generics and trait bounds
        5. The Fn traits are provided by the standard library. All closures implement
            at least one of the traits: Fn, FnMut, or FnOnce.
       6. When a closure captures a value from its environment, it uses memory to store
            the values for use in the closure body. This use of memory is overhead that
            we don’t want to pay in more common cases where we want to execute code
            that doesn't capture its environment.


Closures and capturing values

    1. When you create a closure, Rust infers which trait to use based on how the
        closure uses the values from the environment. All closures implement FnOnce
        because they can all be called at least once.
   2. Closures that don’t move the captured variables also implement FnMut,
        and closures that don’t need mutable access to the captured variables
        also implement Fn.

Closures can capture values from their environment in three ways, which directly
map to the three ways a function can take a parameter: taking ownership, borrowing mutably,
and borrowing immutably. These are encoded in the three Fn traits as follows:

    1. FnOnce consumes the variables it captures from its enclosing scope, known as
        the closure’s environment. To consume the captured variables, the closure
        must take ownership of these variables and move them into the closure when
        it is defined. The Once part of the name represents the fact that the closure
        can’t take ownership of the same variables more than once, so it can be
        called only once.
    2. FnMut can change the environment because it mutably borrows values.
    3. Fn borrows values from the environment immutably.

*/

use std::thread;
use std::time::Duration;

fn main() {
    let simulated_user_specified_value = 10;
    let simulated_random_number = 7;

    generate_workout(simulated_user_specified_value, simulated_random_number);
}

fn simulated_expensive_calculation(intensity: u32) -> u32 {
    println!("calculating slowly...");
    thread::sleep(Duration::from_secs(2));
    intensity
}

fn generate_workout(intensity: u32, random_number: u32) {
    let mut expensive_result = Cacher::new(|num| {
        println!("calculating slowly...");
        thread::sleep(Duration::from_secs(2));
        num
    });

    if intensity < 25 {
        println!("Today, do {} pushups!", expensive_result.value(intensity));
        println!("Next, do {} situps!", expensive_result.value(intensity));
    } else {
        if random_number == 3 {
            println!("Take a break today! Remember to stay hydrated!");
        } else {
            println!(
                "Today, run for {} minutes!",
                expensive_result.value(intensity)
            );
        }
    }
}

/*
Cache values using closures


The value field is of type Option<u32>. Before we execute the closure,
value will be None. When code using a Cacher asks for the result of the closure,
the Cacher will execute the closure at that time and store the result within a
Some variant in the value field. Then if the code asks for the result of the
closure again, instead of executing the closure again, the Cacher will return
the result held in the Some variant.
*/

struct Cacher<T>
where
    T: Fn(u32) -> u32,
{
    calculation: T,
    value: Option<u32>,
}

impl<T> Cacher<T>
where
    T: Fn(u32) -> u32,
{
    fn new(calculation: T) -> Cacher<T> {
        Cacher {
            calculation,
            value: None,
        }
    }

    fn value(&mut self, arg: u32) -> u32 {
        match self.value {
            Some(v) => v,
            None => {
                let v = (self.calculation)(arg);
                self.value = Some(v);
                v
            }
        }
    }
}

/*
Unlike functions, closures can refer to variables
stored in their enclosing scope
*/
fn closure_enclosing_scope() {
    let x = 4;

    let equal_to_x = |z| z == x;

    let y = 4;

    assert!(equal_to_x(y))
}

/*
Iterators

The iterator pattern allows you to perform some task on a
sequence of items in turn. An iterator is responsible for the logic
of iterating over each item and determining when the sequence has finished.
When you use iterators, you don’t have to reimplement that logic yourself.

    1. All iterators implement a trait named Iterator that is defined in the standard library.
    2. self::item
        Associated type defined wit the standard library Iterator trait
    3. next()
        Moves the next value in the iterator. Note that we needed to make v1_iter mutable:
        calling the next method on an iterator changes internal state that the iterator uses
        to keep track of where it is in the sequence. In other words, this code consumes, or
        uses up, the iterator. Each call to next eats up an item from the iterator.
    4. Consuming adaptors
        Methods that call next are called consuming adaptors, because calling them
        uses up the iterator.
    5. Other methods defined on the Iterator trait, known as iterator adaptors, allow you
        to change iterators into different kinds of iterators. You can chain multiple calls
        to iterator adaptors to perform complex actions in a readable way. But because all
        iterators are lazy, you have to call one of the consuming adaptor methods to get
        results from calls to iterator adaptors.
    6. Iterator filter method
        The filter method on an iterator takes a closure that takes each item from the
        iterator and returns a Boolean. If the closure returns true, the value will be
        included in the iterator produced by filter. If the closure returns false, the
        value won’t be included in the resulting iterator.
*/
fn create_iterator() {
    let v1 = vec![1, 2, 3];

    let v1_iter = v1.iter();

    for val in v1_iter {
        println!("Got: {}", val);
    }
}

fn consuming_iterator_with_collections() {
    let v1: Vec<i32> = vec![1, 2, 3];

    let v2: Vec<_> = v1.iter().map(|x| x + 1).collect();

    assert_eq!(v2, vec![2, 3, 4]);
}

#[derive(PartialEq, Debug)]
struct Shoe {
    size: u32,
    style: String,
}

fn shoes_in_my_size(shoes: Vec<Shoe>, shoe_size: u32) -> Vec<Shoe> {
    shoes.into_iter().filter(|s| s.size == shoe_size).collect()
}

#[test]
fn filters_by_size() {
    let shoes = vec![
        Shoe {
            size: 10,
            style: String::from("sneaker"),
        },
        Shoe {
            size: 13,
            style: String::from("sandal"),
        },
        Shoe {
            size: 10,
            style: String::from("boot"),
        },
    ];

    let in_my_size = shoes_in_my_size(shoes, 10);

    assert_eq!(
        in_my_size,
        vec![
            Shoe {
                size: 10,
                style: String::from("sneaker")
            },
            Shoe {
                size: 10,
                style: String::from("boot")
            },
        ]
    );
}

/*
Using iterators in structs.
*/

struct Counter {
    count: u32,
}

impl Counter {
    fn new() -> Counter {
        Counter { count: 0 }
    }
}

impl Iterator for Counter {
    type Item = u32;

    fn next(&mut self) -> Option<Self::Item> {
        self.count += 1;

        if self.count < 6 {
            Some(self.count)
        } else {
            None
        }
    }
}

/*
Vector of numbers into vector of Strings

Two versions shown:
    1. Using a closure in map()
    2. Using a function in map()
*/
fn closure_map_iter() {
    let list_of_numbers = vec![1, 2, 3];
    let list_of_strings: Vec<String> = list_of_numbers.iter().map(|i| i.to_string()).collect();

    let list_of_numbers2 = vec![1, 2, 3];
    let list_of_strings2: Vec<String> = list_of_numbers2.iter().map(ToString::to_string).collect();
}

/*
Using closures where Rust needs a Size trait

Box can be used in this situation
*/
fn returns_closure() -> Box<dyn Fn(i32) -> i32> {
    Box::new(|x| x + 1)
}

fn accept_callback() {
    let array = [1, 2, 3, 4, 5];
    println!("{:?}", array);
    println!("{:?}", array.iter().map(callback).collect::<Vec<i32>>());
}

fn callback(val: &i32) -> i32 {
    *val + 1
}
