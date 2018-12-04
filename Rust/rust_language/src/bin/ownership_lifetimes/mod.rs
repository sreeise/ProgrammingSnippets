/*
Rust Ownership Lifetimes
*/

/*
Function to take a reference to some data structure,
and then return a reference into some part of that structure.
*/

/*
Omitting Lifetimes

When a function takes a single  reference
and returns a single reference the compiler
assumes they have the same lifetime.
*/
pub fn smallest(v: &[i32]) -> &i32 {
    let mut s = &v[0];
    for r in &v[1..] {
        if *r < *s { s = r; }
    }
    s
}

fn print_smallest() {
    let num = smallest(&[3, 2, 8]);
    println!("Vec: {}", num); // -> 2
}

/*
Structs

Structs need lifetime parameters for references

Lifetime: <'a>
*/

struct LifetimeStruct<'a> {
    num: &'a i32
}

/*
Struct inside another Struct

The T value will relate to the LifetimeStruct reference.
*/

struct LifetimeStore<'a> {
    num: LifetimeStruct<'a>
}

/*
Structs and Multiple Lifetime parameters

num1 and num2 will have different lifetimes.
*/
struct MultiLifetime<'a, 'b> {
    num1: &'a i32,
    num2: &'b i32
}

fn sum_multi_lifetime(r: &i32, multi: MultiLifetime) -> i32 {
    r + multi.num1 + multi.num2
}