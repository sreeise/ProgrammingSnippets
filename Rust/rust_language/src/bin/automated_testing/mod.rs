/*
Writing automated tests in Rust

Definitions and Code from:
https://doc.rust-lang.org/book/2018-edition/ch11-01-writing-tests.html

Invoking Tess is done with the command:

    $ cargo test

    1. The #[cfg(test)] annotation on the tests module tells Rust
        to compile and run the test code only when you run cargo test

Tests are Rust functions that verify that the non-test code is functioning
in the expected manner. The bodies of test functions typically perform
these three actions:

    1. Set up any needed data or state.
    2. Run the code you want to test.
    3. Assert the results are what you expect.


Defining test functions

    1. A test in Rust is a function that’s annotated with the test attribute.
    2. To change a function into a test function, add #[test] on the line before fn.
    3. When you run your tests with the cargo test command, Rust builds a test runner
        binary that runs the functions annotated with the test attribute and reports
        on whether each test function passes or fails.


Running Tests in Parallel or Consecutively

    1. When you run multiple tests, by default they run in parallel using threads.
        This means the tests will finish running faster so you can get feedback quicker
        on whether or not your code is working. Because the tests are running at the same
        time, make sure your tests don’t depend on each other or on any shared state,
        including a shared environment, such as the current working directory or
        environment variables.
     2. The total amount of threads being used can be set explicitly. This allows
        for defining whether tests are run in parallel or consecutively.
        Example:
        $ cargo test -- --test-threads=1
        This tells cargo to only use 1 thread. Multiple tests will run consecutively
        in this instance.

Showing println in tests

    1. By default println functions do not print to the console in tests
        This can be changed with the command:
            $ cargo test -- --nocapture


Choosing tests to run in a file

    1. Individual tests within a test file can be chosen to be run by itself
        using the command:
            cargo test <name_of_test>
    2. If two test functions have the same name, cargo test <name_of_test> will
        run both of the tests


Integration Tests and the Test directory

    1. We create a tests directory at the top level of our project directory,
        next to src. Cargo knows to look for integration test files in this directory.
        We can then make as many test files as we want to in this directory, and Cargo
        will compile each of the files as an individual crate.
    2. We don’t need to annotate any code in tests/integration_test.rs with #[cfg(test)].
        Cargo treats the tests directory specially and compiles files in this directory
        only when we run cargo test.
*/

/*
Standard test module with a single function.

    1. The function body uses the assert_eq! macro to assert that 2 + 2 equals 4.
        This assertion serves as an example of the format for a typical test.
*/
#[cfg(test)]
mod tests {
    #[test]
    fn it_works() {
        assert_eq!(2 + 2, 4);
    }
}

/*
assert! macro

The assert! macro, provided by the standard library, is useful when you
want to ensure that some condition in a test evaluates to true. We give
the assert! macro an argument that evaluates to a Boolean. If the value is
true, assert! does nothing and the test passes. If the value is false, the
assert! macro calls the panic! macro, which causes the test to fail. Using
the assert! macro helps us check that our code is functioning in the way we intend.
*/

// Rectangle struct and impl for showing how automated tests can be written
#[derive(Debug)]
pub struct Rectangle {
    length: u32,
    width: u32,
}

impl Rectangle {
    pub fn can_hold(&self, other: &Rectangle) -> bool {
        self.length > other.length && self.width > other.width
    }
}

/*
use super::*;

    The tests module is a regular module that follows the usual
    visibility rules. Because the tests module is an inner module,
    we need to bring the code under  test in the outer module into the scope
    of the inner module. We use a glob here so anything we define in the outer
    module is available to this tests module.
*/

#[cfg(test)]
mod tests2 {
    use super::*;

    #[test]
    fn larger_can_hold_smaller() {
        let larger = Rectangle {
            length: 8,
            width: 7,
        };
        let smaller = Rectangle {
            length: 5,
            width: 1,
        };

        assert!(larger.can_hold(&smaller));
    }

    #[test]
    fn smaller_cannot_hold_larger() {
        let larger = Rectangle {
            length: 8,
            width: 7,
        };
        let smaller = Rectangle {
            length: 5,
            width: 1,
        };

        // Negate the value returned from can_hold()
        assert!(!smaller.can_hold(&larger));
    }
}

/*
assert_eq! macro
Tests for equality

assert_ne! macro
Tests for inequality
*/

pub fn add_two(a: i32) -> i32 {
    a + 2
}

#[cfg(test)]
mod tests3 {
    use super::*;

    #[test]
    fn it_adds_two() {
        assert_eq!(4, add_two(2));
    }
}

/*
Custom messages for tests
*/
pub fn greeting(name: &str) -> String {
    format!("Hello {}!", name)
}

#[cfg(test)]
mod test_custom_messages {
    use super::*;

    #[test]
    fn greeting_contains_name() {
        let result = greeting("Carol");
        assert!(
            result.contains("Carol"),
            "Greeting did not contain name, value was `{}`",
            result
        );
    }
}

/*
should_panic

This attribute makes a test pass if the code inside the function panics;
the test will fail if the code inside the function doesn’t panic.
*/
pub struct Guess {
    value: i32,
}

impl Guess {
    pub fn new(value: i32) -> Guess {
        if value < 1 || value > 100 {
            panic!("Guess value must be between 1 and 100, got {}.", value);
        }

        Guess { value }
    }
}

#[cfg(test)]
mod test_should_panic {
    use super::*;

    #[test]
    #[should_panic] // The code passes if it panics and fails if does not
    fn greater_than_100() {
        Guess::new(200);
    }
}

/*
 To make should_panic tests more precise, we can add an optional
 expected parameter to the should_panic attribute. The test harness
 will make sure that the failure message contains the provided text.
*/

pub struct Guess2 {
    value: i32,
}

impl Guess2 {
    pub fn new(value: i32) -> Guess2 {
        if value < 1 {
            panic!(
                "Guess value must be greater than or equal to 1, got {}.",
                value
            );
        } else if value > 100 {
            panic!(
                "Guess value must be less than or equal to 100, got {}.",
                value
            );
        }

        Guess2 { value }
    }
}

#[cfg(test)]
mod tests_should_panic_with_expected_value {
    use super::*;

    #[test]
    #[should_panic(expected = "Guess value must be less than or equal to 100")]
    fn greater_than_100() {
        Guess2::new(200);
    }
}

/*
Using Result<T, E> in tests

    1. Instead of being based on panics, it will use the Result<T, E>
        to make that determination. Because of this, you can't use #[should_panic]
        with one of these functions; you should have it be returning an Err instead!
*/

#[cfg(test)]
mod tests_using_result {
    #[test]
    fn it_works() -> Result<(), String> {
        if 2 + 2 == 4 {
            Ok(())
        } else {
            Err(String::from("two plus two does not equal four"))
        }
    }
}

/*
Ignoring tests with the $[ignore] attribute

    1. Will only run tests without the ignore attribute
    2. Running tests with only the ignore attribute can be done
        using the command:
            cargo test -- --ignored
*/

#[test]
fn it_works() {
    assert_eq!(2 + 2, 4);
}

#[test]
#[ignore]
fn expensive_test() {
    // code that takes an hour to run
}
