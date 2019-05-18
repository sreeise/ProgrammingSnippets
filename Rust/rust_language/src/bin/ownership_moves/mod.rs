/*
Rust Ownership Moves


Move Rule:
If it’s possible for a variable to have had its value moved away, and it hasn't
definitely been given a new value since, it’s considered uninitialized.

    1. Moving a variable in a loop is an error unless the value
        has been changed before the next iteration.
*/

fn string_move() {
    let mut a_string = "A String".to_string();

    // t_string takes ownership of a_string
    let t_string = a_string;

    // a_string can be assigned to another string now
    // By the time a_string is assigned here it is uninitialized
    // so no drop occurs.
    a_string = "Another String".to_string(); // -> Drop does not occur
    println!("a_string: {}", a_string); // -> a_string: Another String
}

/*
Vec Ownership

When a call to Vector::new() happens, it returns
the vector itself, not a pointer.

The variable set to vector is the vector itself.
*/

#[derive(Debug)]
struct Person {
    first_name: String,
    last_name: String,
}

fn vec_ownership() {
    let mut vec = Vec::new();

    // Vector takes ownership of the person and becomes
    // the indirect owner of the String in the Struct as
    // the Struct takes ownership of the Strings
    vec.push(Person {
        first_name: "John".to_string(), // -> Struct takes ownership of the String
        last_name: "Doe".to_string(),   // -> Struct takes ownership of the String
    });

    println!("Vector: {:?}", vec); // -> Vector: [Person { first_name: "John", last_name: "Doe" }]
}

/*
Vec Value Move

Rust does not allow setting a value in a vector directly,
Values must be moved in a safe way
*/
fn vec_value_move() {
    let mut vec: Vec<String> = vec![
        "value1".to_string(),
        "value2".to_string(),
        "value3".to_string(),
        "value4".to_string(),
        "value5".to_string(),
    ];

    // Stacks Pop Method
    let val1 = vec.pop().unwrap();
    assert_eq!(val1, "value5");

    // Remove value and index 1 and move the las value into index 1
    let val2 = vec.swap_remove(1);
    assert_eq!(val2, "value2");

    // Swap a value at a given index
    let val3 = std::mem::replace(&mut vec[2], "val6".to_string());
    assert_eq!(val3, "value3");

    assert_eq!(vec, vec!["value1", "value4", "val6"]);
    println!("Vec: {:?}", vec);
}

/*
Rust Loop Move

When vector is used in a loop, the current value
gets uninitialized and can be mutable during that
iterations scope. On each loop, the variable
representing the current value in the iteration
is set to the variable and the variable owns that value.
*/

fn loop_move() {
    let vec: Vec<u32> = vec![1, 2, 3, 4];

    for val in vec {
        println!("val: {}", val + 1);
    }
}

/*
Option<T>

For moving values that the compiler cant track
*/

#[derive(Debug)]
struct Person1 {
    first_name: Option<String>,
    last_name: Option<String>,
}

fn option_move() {
    let mut vec = Vec::new();
    vec.push(Person1 {
        first_name: Some("John".to_string()),
        last_name: Some("Doe".to_string()),
    });

    println!("Vec: {:?}", vec); // -> Vec: [Person1 { first_name: Some("John"), last_name: Some("Doe") }]

    // Option is implemented here so None type is a valid move.
    let first_name = std::mem::replace(&mut vec[0].first_name, None);
    assert_eq!(first_name, Some("John".to_string()));
    assert_eq!(vec[0].first_name, None);
}

/*
Copy Trait

Types with the Copy trait will copy the value instead of moving it

Basic Types with Copy trait:
    1. Integers
    2. Floating point types
    3. Chars
    4. Booleans
    5. Tuple
    6. Fixed sized Array

Basic Non Copy Types
    1. Struct
    2. Vector
    3. MutexGuard
    4. Enum
    5. String
    6. Box<T>

Any value that does something when value is dropped cannot be a copy.

If all the fields of a type have the Copy trait then the
Copy trait can be added to the type.

The macro Copy and Clone is used to add the Copy trait.
*/

#[derive(Debug, Copy, Clone)]
struct CopyValues {
    num: u32,
}

fn copy_trait_struct() {
    let copy_num = CopyValues { num: 3 };

    println!("CopyValues: {:?}", copy_num); // -> CopyValues: CopyValues { num: 3 }
}

/*
Rc and Arc - Reference-Counted Pointer Types

A pointer to a value with a reference count. Cloning the value
does not copy it, but adds 1 to the reference count.

Rc
    1. Stands for Reference Count.
    2. For any type T, a Rc<T> is a heap-allocated pointer with a reference count.
    3. A value owned by Rc is immutable.

Arc
    1. Stands for Atomic Reference Count.
    2. Same as Rc except is safe to share threads
*/

use std::rc::Rc;

fn assign_rc() {
    let val1: Rc<String> = Rc::new("A String".to_string());
    let val2: Rc<String> = val1.clone(); // -> Increases reference count of pointers to 2
    let val3: Rc<String> = val2.clone(); // -> Increases reference count of pointers to 3
}
