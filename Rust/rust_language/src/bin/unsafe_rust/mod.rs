/*
Unsafe Rust

All Code and Definitions from:
https://doc.rust-lang.org/book/second-edition/ch19-01-unsafe-rust.html

Rust’s has memory safety guarantees enforced at compile time. However, Rust
has a second language hidden inside it that doesn’t enforce these memory
safety guarantees: it’s called unsafe Rust and works just like regular Rust,
but gives us extra superpowers.

Unsafe Rust exists because, by nature, static analysis is conservative.
When the compiler tries to determine whether or not code upholds the guarantees,
it’s better for it to reject some valid programs rather than accept some invalid programs.

Using Unsafe Superpowers

To switch to unsafe Rust, use the unsafe keyword and then start a new block that
holds the unsafe code. You can take four actions in unsafe Rust, called unsafe
superpowers, that you can’t in safe Rust. Those superpowers include the ability to:
    1. Dereference a raw pointer
    2. Call an unsafe function or method
    3. Access or modify a mutable static variable
    4. Implement an unsafe trait

What Unsafe Rust does not turn off and the Rust compiler still checks for
    1. Borrow Checker
    2. Rust's Safety Checks
*/

/*
Dereference a Raw Pointer

There are two Raw Pointers:
    1. *const T
        Immutable raw pointer. Cannot be directly assigned to after being dereferenced.
        The asterisk is not the dereference operator,it is part of the name.
    2. *mut T
        Mutable raw pointer. The asterisk is not the dereference operator,
        it is part of the name.

Different from references and smart pointers, raw pointers:
    1, Are allowed to ignore the borrowing rules by having both immutable and mutable
        pointers or multiple mutable pointers to the same location
    2. Aren't guaranteed to point to valid memory
    3. Are allowed to be null
    4. Don’t implement any automatic cleanup
*/

/*
Immutable Raw Pointer from References

Note: The unsafe keyword is not included here. We can create raw pointers
in safe code; we just can’t dereference raw pointers outside an unsafe block,
*/
fn basic_immutable_raw_pointer() {
    let mut num = 5;

    let r1 = &num as *const i32;
    let r2 = &mut num as *mut i32;
}

/*
Raw Pointer that is Dereferenced. Needs unsafe keyword

Creating a pointer does no harm; it’s only when we try to access the value that
it points at that we might end up dealing with an invalid value.

Note that here a *const i32 and *mut i32 raw pointers are created that both pointed
to the same memory location, where num is stored. If we instead tried to create an
immutable and a mutable reference to num, the code would not have compiled because
Rust’s ownership rules don’t allow a mutable reference at the same time as any
immutable references.

With raw pointers, we can create a mutable pointer and an immutable pointer to
the same location and change data through the mutable pointer, potentially
creating a data race. Be careful!
*/
fn dereference_raw_pointer() {
    let mut num = 5;

    let r1 = &num as *const i32;
    let r2 = &mut num as *mut i32;

    unsafe {
        println!("r1 is: {}", *r1);
        println!("r2 is: {}", *r2);
    }
}

/*
Unsafe functions
*/

/*
Creating an unsafe function

Unsafe functions must be called in a separate unsafe code block.

Bodies of unsafe functions are effectively unsafe blocks, so to perform other
unsafe operations within an unsafe function, we don’t need to add another unsafe block.
*/
unsafe fn dangerous() {}
fn call_dangerous() {
    unsafe {
        dangerous();
    }
}

/*
Implementation of Rust Standard Library function split_at_mut using Unsafe Rust

Slices are a pointer to some data and the length of the slice. We use the
len method to get the length of a slice and the as_mut_ptr method to access
the raw pointer of a slice. In this case, because we have a mutable slice to
i32 values, as_mut_ptr returns a raw pointer with the type *mut i32, which
we’ve stored in the variable ptr.

We keep the assertion that the mid index is within the slice. Then we get to the unsafe
code: the slice::from_raw_parts_mut function takes a raw pointer and a length, and it
creates a slice. We use this function to create a slice that starts from ptr and is mid
items long. Then we call the offset method on ptr with mid as an argument to get a raw
pointer that starts at mid, and we create a slice using that pointer and the remaining
number of items after mid as the length.

The function slice::from_raw_parts_mut is unsafe because it takes a raw pointer and
must trust that this pointer is valid. The offset method on raw pointers is also unsafe,
because it must trust that the offset location is also a valid pointer.
*/
use std::slice;

fn split_at_mut(slice: &mut [i32], mid: usize) -> (&mut [i32], &mut [i32]) {
    let len = slice.len();
    let ptr = slice.as_mut_ptr();

    assert!(mid <= len);

    unsafe {
        (slice::from_raw_parts_mut(ptr, mid),
         slice::from_raw_parts_mut(ptr.offset(mid as isize), len - mid))
    }
}

/*
Foreign Function Interface (FFI)

An FFI is a way for a programming language to define functions and enable a
different (foreign) programming language to call those functions.

Functions declared within extern blocks are always unsafe to call from Rust code.
The reason is that other languages don’t enforce Rust’s rules and guarantees,
and Rust can’t check them, so responsibility falls on the programmer to ensure safety.
*/

/*
Integrating with C Programming Language


Within the extern "C" block, we list the names and signatures of external functions
from another language we want to call. The "C" part defines which application binary
interface (ABI) the external function uses: the ABI defines how to call the function
at the assembly level. The "C" ABI is the most common and follows the C programming
language’s ABI.
*/
extern "C" {
    fn abs(input: i32) -> i32;
}

fn print_ffi() {
    unsafe {
        println!("Absolute value of -3 according to C: {}", abs(-3));
    }
}

/*
Allowing Rust Code to be called from other Programming Languages

Add the extern keyword and specify the ABI to use just before the fn
keyword. We also need to add a #[no_mangle] annotation to tell the Rust
compiler not to mangle the name of this function.

Mangling is when a compiler changes the name we’ve given a function to a different
name that contains more information for other parts of the compilation process to
consume but is less human readable. Every programming language compiler mangles names
slightly differently, so for a Rust function to be nameable by other languages, we must
disable the Rust compiler’s name mangling.

This usage of extern does not require unsafe.

In the following example, we make the call_from_c function accessible from C code,
after it’s compiled to a shared library and linked from C:
*/

// #[allow(private_no_mangle_fns)]: Allow private_no_mangle_fns was
// originally here so this code does not have to be exported and can't be used
// without doing so. It is just an example. However, this has been removed in Rust
// and no longer needed in Rust 1.31.

#[no_mangle]
pub extern "C" fn call_from_c() {
    println!("Just called a Rust function from C!");
}

/*
Accessing or Modifying a Mutable Static Variable

The names of static variables are in SCREAMING_SNAKE_CASE by convention,
and we must annotate the variable’s type, which is &'static str in this example.
Static variables can only store references with the 'static lifetime, which means
the Rust compiler can figure out the lifetime; we don’t need to annotate it explicitly.

Accessing an immutable static variable is safe.
*/
static HELLO_WORLD: &str = "Hello, world!";

fn print_static_variable() {
    println!("name is: {}", HELLO_WORLD);
}

/*
Declare, access, and modify a mutable static variable named COUNTER.

Reading from or writing to a mutable static variable is unsafe
*/
static mut COUNTER: u32 = 0;

fn add_to_count(inc: u32) {
    unsafe {
        COUNTER += inc;
    }
}

fn print_add_to_count() {
    add_to_count(3);

    unsafe {
        println!("COUNTER: {}", COUNTER);
    }
}

/*
Unsafe Traits

 A trait is unsafe when at least one of its methods has
 some invariant that the compiler can’t verify. We can declare
 that a trait is unsafe by adding the unsafe keyword before trait
 and marking the implementation of the trait as unsafe too.

 By using unsafe impl, we’re promising that we’ll uphold the
 invariants that the compiler can’t verify.
*/
unsafe trait Foo {
    // methods go here
}

unsafe impl Foo for i32 {
    // method implementations go here
}