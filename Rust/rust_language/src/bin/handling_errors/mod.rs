/*
Definitions and Code from:
https://doc.rust-lang.org/book/2018-edition/ch09-00-error-handling.html
https://doc.rust-lang.org/book/2018-edition/ch09-01-unrecoverable-errors-with-panic.html

Rust groups errors into two major categories: recoverable and unrecoverable errors.
For a recoverable error, such as a file not found error, it’s reasonable to report
the problem to the user and retry the operation. Unrecoverable errors are always
symptoms of bugs, like trying to access a location beyond the end of an array.


panic! macro

By default, when a panic occurs, the program starts unwinding, which means Rust
walks back up the stack and cleans up the data from each function it encounters.
*/

use std::error::Error;
use std::fs::File;
use std::io;
use std::io::ErrorKind;
use std::io::Read;
use std::io::{stderr, Write};
use std::path::Path;

// End the program with a panic! macro
// Not a very useful method by itself except for showing what happens to a
// program when a panic! macro is called
fn cause_a_panic() {
    panic!("PANIC!");
}

/*
Using BackTraces

    1. Automatically enabled when using cargo build and cargo run without --release flag
    2. A backtrace is a list of all the functions that have been called to get to this point.
    3. BackTraces can be shown using: RUST_BACKTRACE=1 cargo run
*/

/*
Handling errors using Result<T, E>

    1. T represents the type of the value that will be returned in a success
        case within the Ok variant
    2. E represents the type of the error that will be returned in a failure
        case within the Err variant.
*/

fn panic_file_error_with_result() {
    let f = File::open("hello.txt");

    /*
    Like the Option enum, the Result enum and its variants have been imported
    in the prelude, so we don’t need to specify Result:: before the Ok and
    Err variants in the match arms.
    */

    let f = match f {
        Ok(file) => file,
        Err(error) => panic!("There was a problem opening the file: {:?}", error),
    };
}

/*
The enum io::ErrorKind is provided by the standard library and has
variants representing the different kinds of errors that might result
from an io operation. The variant we want to use is ErrorKind::NotFound,
which indicates the file we’re trying to open doesnt exist yet.
*/

fn create_file_if_not_found() {
    let f = File::open("hello.txt");
    let f = match f {
        Ok(file) => file,
        Err(error) => match error.kind() {
            ErrorKind::NotFound => match File::create("hello.txt") {
                Ok(fc) => fc,
                Err(e) => panic!("Tried to create file but there was a problem: {:?}", e),
            },
            other_error => panic!("There was a problem opening the file: {:?}", other_error),
        },
    };
}

/*
Instead of using a match a closure can be used for error handling.

Unwrap: If the Result value is the Ok variant, unwrap will return the value inside
        the Ok. If the Result is the Err variant, unwrap will call the panic!

Expect: Similar to unwrap, lets us also choose the panic! error
        Example: let f = File::open("hello.txt").expect("Failed to open hello.txt");
*/
fn create_file_if_not_found_using_closure() {
    let f = File::open("hello.txt").map_err(|error| {
        if error.kind() == ErrorKind::NotFound {
            File::create("hello.txt").unwrap_or_else(|error| {
                panic!("Tried to create file but there was a problem: {:?}", error);
            })
        } else {
            panic!("There was a problem opening the file: {:?}", error);
        }
    });
}

/*
Propagating Errors:
    Return the error to the calling code so that it can decide what to do


This function is returning a value of the type Result<T, E> where the generic
parameter T has been filled in with the concrete type String, and the generic
type E has been filled in with the concrete type io::Error.

If this function encounters any problems, the code that calls this function will
receive an Err value that holds an instance of io::Error that contains more
information about what the problems were.
*/

// Return the errors to the calling code using match
fn read_username_from_file() -> Result<String, io::Error> {
    let f = File::open("hello.txt");

    let mut f = match f {
        Ok(file) => file,
        Err(e) => return Err(e),
    };

    let mut s = String::new();

    match f.read_to_string(&mut s) {
        Ok(_) => Ok(s),
        Err(e) => Err(e),
    }
}

/*
The ? placed after a Result value is defined to work in almost the same way
as the match expressions defined to handle the Result values

? vs match expression:
    Error values taken by ? go through the from function, defined in the From trait
    in the standard library, which is used to convert errors from one type into another.
    When ? calls the from function, the error type received is converted into the error
    type defined in the return type of the current function. This is useful when a function
    returns one error type to represent all the ways a function might fail, even if parts
    might fail for many different reasons. As long as each error type implements the from
    function to define how to convert itself to the returned error type, ? takes care of
    the conversion automatically.

    1. The ? operator can only be used in functions that have a return type of Result
    2. In functions that don’t return Result, when you call other functions that return
        Result, you’ll need to use a match or one of the Result methods to handle the
        Result instead of using ? to potentially propagate the error to the calling code.
*/
fn read_username_using_question_mark() -> Result<String, io::Error> {
    let mut f = File::open("hello.txt")?;
    let mut s = String::new();
    f.read_to_string(&mut s)?;
    Ok(s)
}

// Shortening the function using question mark and read_to_string
fn read_username_question_mark_shorter() -> Result<String, io::Error> {
    let mut s = String::new();

    File::open("hello.txt")?.read_to_string(&mut s)?;

    Ok(s)
}

/*
Shortening the file read error handling even further

Reading a file into a string is a fairly common operation, and so Rust provides
a convenience function called fs::read_to_string that will open the file, create a
new String, read the contents of the file, and put the contents into that String,
and then return it.
*/

use std::fs;

fn read_username_from_file_short() -> Result<String, io::Error> {
    fs::read_to_string("hello.txt")
}

/*
Result io::Error

is_ok(): returns Bool indicating successful result.
is_err(): returns Bool indicating unsuccessful result.
ok(): Returns success value, if any, as an Option<T>.
        Successful results return Some()
        otherwise it returns None
err(): returns the err value
unwrap_or(fallback) returns the success value, if results is a success result,
            otherwise it returns fallback, discarding the error value.
unwrap_or_else(fallback_fn): same as unwrap_or() but takes a closure or function
                            instead of a value.
unwrap(): returns the success value, if result is a success result. If result
            is an error result, the method panics.
expect(err_message): same as unwrap with the option to define an error message
as_ref(): converts a Result<T, E> to a Result<&T, &E>, borrowing a reference
                to the success or error value in the existing result.
as_mut(): Same as as_ref() but borrows a mutable reference.
                The return type is Result<&mut T, &mut E>.
as_ref().ok(): borrows result returning an Option<&t>

Result type is an Alias Type: fn remove_file(path: &Path) -> Result<()>
            A type alias is a kind of shorthand for type names.
*/

/*
Printing Errors to standard output.

Rust may not always print out an errors cause. In this case
a function like this can be used.
*/
fn print_error(mut err: &dyn Error) {
    let _ = writeln!(stderr(), "error: {}", err);
    while let Some(cause) = err.source() {
        let _ = writeln!(stderr(), "caused by: {}", cause);
        err = cause;
    }
}

/*
Propagate Errors with ?

You can add ? to any expression that produces a Result.

The behavior of ? depends on whether the function returns a success result
or an error result:
    1. Success: It unwraps the Result to get the success value inside.
    2. Error: Immediately returns from the enclosing function and passing
                the error result up the call chain.

The ? can only be used in functions that have a Result return type.
*/

fn move_all(src: &Path, dst: &Path) -> io::Result<()> {
    // Opening directory could fail here. See the ?
    for entry_result in src.read_dir()? {
        // Reading directory could fail here. See the ?
        let entry = entry_result?;
        let dst_file = dst.join(entry.file_name());

        // Renaming directory could fail here. See the ?
        fs::rename(entry.path(), dst_file)?;
    }
    Ok(())
}
