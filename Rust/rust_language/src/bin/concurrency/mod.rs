/*
Concurrency

Concurrency refers to the ability to allow parallel execution of
concurrent modules of code.

All Code and Definitions taken from:
https://doc.rust-lang.org/book/2018-edition/ch16-00-concurrency.html

Fearless concurrency
    1. Rust leverages the type system and ownership to perform compile
        time checks rather than having runtime errors for concurrency
        to aid in development. This is known as fearless concurrency.


*/

/*
Creating threads

Below, a new thread is created and prints one thing while
the main thread prints another.

Issues with example
This example has issues that Rust features can fix
    1. Stops the spawned thread prematurely most of the time due to the main thread ending.
    2. Can't guarantee that the spawned thread will get to run at all.
*/

use std::thread;
use std::time::Duration;

// Basic thread creation
fn create_thread() {
    thread::spawn(|| {
        for i in 1..10 {
            println!("hi number {} from the spawned thread!", i);
            thread::sleep(Duration::from_millis(1));
        }
    });

    for i in 1..5 {
        println!("hi number {} from the main thread!", i);
        thread::sleep(Duration::from_millis(1));
    }
}

/*
JoinHandle

Owned value that, when we call the join method on it, will wait
for its thread to finish

The return type of thread::spawn is JoinHandle.

Example shows how handle ensures the spawned thread finishes.
*/
fn create_thread_using_handle() {
    let handle = thread::spawn(|| {
        for i in 1..10 {
            println!("hi number {} from the spawned thread!", i);
            thread::sleep(Duration::from_millis(1));
        }
    });

    for i in 1..5 {
        println!("hi number {} from the main thread!", i);
        thread::sleep(Duration::from_millis(1));
    }

    handle.join().unwrap();
}