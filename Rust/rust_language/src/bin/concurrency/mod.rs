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

In this example the two loops will run at the same time while
the second example uses JoinHandle to make the second loop
wait on the first.

Both examples shows that the thread::spawn does not take any arguments
denoted by the || with no arguments inside. This is because no data
from the main thread is used in the spawn thread.
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
The first loop will finish first and then the second loop
will run.
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

/*
Threads and the Move Closure

Using threads and the move closure allows you to use data from one thread
in another thread.

By adding the move keyword before the closure, we force the closure to take
ownership of the values it’s using rather than allowing Rust to infer that it
should borrow the values.
*/
fn use_move_with_threads() {
    let v = vec![1, 2, 3];

    let handle = thread::spawn(move || {
        println!("Here's a vector: {:?}", v);
    });

    handle.join().unwrap();
}

/*
Message Passing

Threads or actors communicate by sending each other messages containing data.

Channel
A channel in programming has two halves: a transmitter and a receiver.
The transmitter half is the upstream location where you put rubber ducks into the river,
and the receiver half is where the rubber duck ends up downstream. One part of your code
calls methods on the transmitter with the data you want to send, and another part checks
the receiving end for arriving messages. A channel is said to be closed if either the
transmitter or receiver half is dropped.

Using std::sync::mpsc

mpsc stands for multiple producer, single consumer

In short, the way Rust’s standard library implements channels means a channel
can have multiple sending ends that produce values but only one receiving end
that consumes those values.

mpsc returns a tuple with a transmitter and receiver and typical implementations
use a short hand naming convention:
tx: transmitter
rx: receiver

recv
    Blocks the main thread execution and waits until a value is sent down
    the channel. Once a value is sent, recv will return it in a Result<T, E>.
    When the sending end of the channel closes, recv will return an error to signal
    that no more values will be coming.

try_recv
    Returns a Result<T, E> immediately: an Ok value holding a message if one is available
    and an Err value if there aren’t any messages this time.
*/

use std::sync::mpsc;

/*
Uses thread::spawn to create a new thread and then using move to move tx into the
closure so the spawned thread owns tx. The spawned thread needs to own the transmitting
end of the channel to be able to send messages through the channel.
*/
fn basic_channel() -> String {
    let (tx, rx) = mpsc::channel();

    thread::spawn(move || {
        let val = String::from("hi");
        tx.send(val).unwrap();
    });

    let received = rx.recv().unwrap();
    println!("Got: {}", received);
    received
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_basic_channel() {
        let received = basic_channel();
        assert_eq!(received, String::from("hi"));
    }
}