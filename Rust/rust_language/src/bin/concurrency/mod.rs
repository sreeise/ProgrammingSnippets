/*
Concurrency

Concurrency refers to the ability to allow parallel execution of
concurrent modules of code.

All Code and Definitions taken from:
https://doc.rust-lang.org/book/2018-edition/ch16-00-concurrency.html
https://github.com/ProgrammingRust/examples
https://github.com/Hoverbear/rust-rosetta/blob/master/tasks/atomic-updates/src/main.rs

Fearless concurrency
    1. Rust leverages the type system and ownership to perform compile
        time checks rather than having runtime errors for concurrency
        to aid in development. This is known as fearless concurrency.

Types of Parallelism:
    1. Fork-Join Parallelism: To fork is to start a new thread, and to join
                    a thread is to wait for it to finish. A fork-jon program
                    is deterministic as long as the threads are really isolated.
   2. Channel: One-way conduit for sending values from one thread to another.
   3. Shared mutable state

Mutexes:
    1. Prevent data races
    2. Supports programming with invariants, rules about the protected data
        that are true by construction.
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

/*
Example of task synchronization using threads.

Note that this contains unsafe Rust code
    - see the unsafe_rust directory
*/

// We implement this task using Rust's Barriers.  Barriers are simply thread synchronization
// points--if a task waits at a barrier, it will not continue until the number of tasks for which
// the variable was initialized are also waiting at the barrier, at which point all of them will
// stop waiting.  This can be used to allow threads to do asynchronous work and guarantee
// properties at checkpoints.

use std::sync::atomic::{AtomicBool, Ordering};
use std::sync::mpsc::channel;
use std::sync::{Arc, Barrier};
use std::thread::spawn;

pub fn checkpoint() {
    const NUM_TASKS: usize = 10;
    const NUM_ITERATIONS: u8 = 10;

    let barrier = Barrier::new(NUM_TASKS);
    let mut events: [AtomicBool; NUM_TASKS];
    unsafe {
        // Unsafe because it's hard to initialize arrays whose type is not Clone.
        events = ::std::mem::uninitialized();
        for e in &mut events {
            // Events are initially off
            *e = AtomicBool::new(false);
        }
    }
    // Arc for sharing between tasks
    let arc = Arc::new((barrier, events));
    // Channel for communicating when tasks are done
    let (tx, rx) = channel();
    for i in 0..NUM_TASKS {
        let arc = Arc::clone(&arc);
        let tx = tx.clone();
        // Spawn a new worker
        spawn(move || -> () {
            let (ref barrier, ref events) = *arc;
            // Assign an event to this task
            let event = &events[i];
            // Start processing events
            for _ in 0..NUM_ITERATIONS {
                // Between checkpoints 4 and 1, turn this task's event on.
                event.store(true, Ordering::Release);
                // Checkpoint 1
                barrier.wait();
                // Between checkpoints 1 and 2, all events are on.
                assert!(events.iter().all(|e| e.load(Ordering::Acquire)));
                // Checkpoint 2
                barrier.wait();
                // Between checkpoints 2 and 3, turn this task's event off.
                event.store(false, Ordering::Release);
                // Checkpoint 3
                barrier.wait();
                // Between checkpoints 3 and 4, all events are off.
                assert!(events.iter().all(|e| !e.load(Ordering::Acquire)));
                // Checkpoint 4
                barrier.wait();
            }
            // Finish processing events.
            tx.send(()).unwrap();
        });
    }
    drop(tx);
    // The main thread will not exit until all tasks have exited.
    for _ in 0..NUM_TASKS {
        rx.recv().unwrap();
    }
}

#[test]
fn test_checkpoint() {
    checkpoint();
}

/*
Atomics
For lock-free concurrent programming

See: Above function as well.
See: https://github.com/Hoverbear/rust-rosetta/blob/master/tasks/atomic-updates/src/main.rs

    1. Atomic<isize> and AtomicUsize are shared integer types corresponding to
            the single-threaded isize and usize types.
    2. An AtomicBool is a shared bool value.
    3. An AtomicPtr<T> is a shared value of the unsafe pointer type *mut T.
*/

/*
into_inner()

Consumes the atomic and returns the value
*/
fn into_inner_consume_atomic() {
    let some_bool = AtomicBool::new(true);
    assert_eq!(some_bool.into_inner(), true);
}

/*
get_mut() Returns a mutable reference to the underlying bool.
load(): Loads a value from the bool.
*/
fn atomic_get_mut() {
    let mut some_bool = AtomicBool::new(true);
    assert_eq!(*some_bool.get_mut(), true);
    *some_bool.get_mut() = false;
    assert_eq!(some_bool.load(Ordering::SeqCst), false);
}

/*
swap(): Stores a value into the bool, returning the previous value.
*/
fn swap_atomic_bool() {
    let some_bool = AtomicBool::new(true);

    assert_eq!(some_bool.swap(false, Ordering::Relaxed), true);
    assert_eq!(some_bool.load(Ordering::Relaxed), false);
}

/*
Channels and Mutex

A Mutex can wrap a Receiver to share it.
*/
pub mod shared_channel {
    use std::sync::mpsc::{channel, Receiver, Sender};
    use std::sync::{Arc, Mutex};

    /// A thread-safe wrapper around a `Receiver`.
    #[derive(Clone)]
    pub struct SharedReceiver<T>(Arc<Mutex<Receiver<T>>>);

    impl<T> Iterator for SharedReceiver<T> {
        type Item = T;

        /// Get the next item from the wrapped receiver.
        fn next(&mut self) -> Option<T> {
            let guard = self.0.lock().unwrap();
            guard.recv().ok()
        }
    }

    /*
    Create a new channel whose receiver can be shared across threads.
    this returns a sender and a receiver, just like the stdlib's
    channel()`, and sometimes works as a drop-in replacement.
    */
    pub fn shared_channel<T>() -> (Sender<T>, SharedReceiver<T>) {
        let (sender, receiver) = channel();
        (sender, SharedReceiver(Arc::new(Mutex::new(receiver))))
    }
}

// Trait that creates thread safe iterators for any T.
pub trait SafeThreadIter: Iterator {
    fn off_thread(self) -> mpsc::IntoIter<Self::Item>;
}

impl<T> SafeThreadIter for T
where
    T: Iterator + Send + 'static,
    T::Item: Send + 'static,
{
    fn off_thread(self) -> mpsc::IntoIter<Self::Item> {
        let (sender, receiver) = mpsc::sync_channel(1024);

        spawn(move || {
            for item in self {
                if sender.send(item).is_err() {
                    break;
                }
            }
        });

        receiver.into_iter()
    }
}
