/*
Ownership

All Code and Definitions from:
https://doc.rust-lang.org/book/2018-edition/ch04-01-what-is-ownership.html

This module focuses on a core feature in Rust: Ownership
Understanding ownership requires knowing how the stack and heap
work. A basic explanation is available at the URL above. The
the relation of Strings and the stack and heap is discussed below.

Ownership
    Memory is managed through a system of ownership with a set of rules that the
    compiler checks at compile time. None of the ownership features slow down your
    program while it’s running

Ownership rules:
    1. Each value in Rust has a variable that’s called its owner.
    2. There can only be one owner at a time.
    3. When the owner goes out of scope, the value will be dropped.

Transferring Ownership
    1. Ownership can be transferred in multiple ways including tuples.
    2. References are a feature concept in Rust that can be used
        to transfer ownership. See the borrowing_references directory.
*/

/*
Scope
    The range within a program for which an item is valid.

Scope is important in understanding Ownership in Rust.
*/
fn scope() {
    let s = String::from("hello"); // s is valid from this point forward

    // do stuff with s
} // Variable s will no longer be valid at the end of this function.

/*
Strings
    With the String type, in order to support a mutable, growable piece of text,
    we need to allocate an amount of memory on the heap, unknown at compile time,
    to hold the contents. This means:
        1. The memory must be requested from the operating system at runtime.
        2. We need a way of returning this memory to the operating system when we’re done with our String.

There is a natural point at which we can return the memory our String needs to
the operating system: when s goes out of scope. When a variable goes out of scope,
Rust calls a special function for us. This function is called drop, and it’s where
the author of String can put the code to return the memory. Rust calls drop automatically
at the closing }

Strings and the stack and heap

A String is made up of three parts:
    1. A pointer to the memory that holds the contents of the string,
    2. Length
        How much memory, in bytes, the contents of the String is currently using.
    3. capacity.
        The total amount of memory, in bytes, that the String has received
        from the operating system.

This group of data is stored on the stack.
On the right is the memory on the heap that holds the contents.
*/
fn strings_stack_and_heap() {
    /*
    When we assign s1 to s2, the String data is copied, meaning we copy the
    pointer, the length, and the capacity that are on the stack. We do not copy
    the data on the heap that the pointer refers to.
    */
    let s1 = String::from("hello");
    let s2 = s1;
}