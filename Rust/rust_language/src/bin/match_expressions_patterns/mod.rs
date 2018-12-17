/*
Matching Expressions and Patterns

All Code and Definitions from
https://doc.rust-lang.org/book/2018-edition/ch18-01-all-the-places-for-patterns.html

Goes over several ways of matching including matching expressions, let, if let,
while, and for.

Patterns come in two forms: refutable and irrefutable.

Irrefutable Patterns
    Patterns that match for any possible value passed.

Refutable Patterns:
    Patterns that can fail to match for some possible value.
*/

/*
If some_option_value was a None value, it would fail to match the pattern Some(x),
meaning the pattern is refutable. However, the let statement can only accept an
irrefutable pattern because there is nothing valid the code can do with a None
value. At compile time, Rust will complain that we’ve tried to use a refutable
pattern where an irrefutable pattern is required.



To fix the problem where we have a refutable pattern where an irrefutable pattern
is needed, we can change the code that uses the pattern: instead of using let, we
can use if let. Then if the pattern doesn't match, the code will just skip the code
in the curly brackets, giving it a way to continue validly.

Example shows a pattern with a refutable pattern commented out and
the its irrefutable pattern replacement.

Changing to if let allows testing the Some(x), however,
compiling will fail if value given is always irrefutable such as:
    if let x = 5 {
        println!("{}", x);
    };

For this reason, match arms must use refutable patterns, except for the last arm,
which should match any remaining values with an irrefutable pattern. Rust allows
us to use an irrefutable pattern in a match with only one arm, but this syntax isn’t
particularly useful and could be replaced with a simpler let statement.
*/
fn refutable_vs_irrefutable() {
    let some_option_value: Option<i32> = None;

    // This will cause a compile time error:
    // let Some(x) - some_other_value

    // Should be written as:
    if let Some(x) = some_option_value {
        println!("{}", x);
    }
}

/*
Named Variables

Named variables are irrefutable patterns that match any value.

Because match starts a new scope, variables declared as part of a pattern inside
the match expression will shadow those with the same name outside the match construct,
as is the case with all variables.

Instead Match Guards should be used

Match Guards

VA match guard is an additional if condition specified after the pattern
in a match arm that must also match, along with the pattern matching, for
that arm to be chosen. Match guards are useful for expressing more complex
ideas than a pattern alone allows.
*/

/*
Shows a match where the first arm has the pattern Some(x) and also has a match
guard of if x < 5

There is no way to express the if x < 5 condition within a pattern, so the match
guard gives us the ability to express this logic.
*/

fn basic_match_guard() {
    let num = Some(4);

    match num {
        Some(x) if x < 5 => println!("less than five: {}", x),
        Some(x) => println!("{}", x),
        None => (),
    }
}

/*
Using Match Guard for Outer Variables
*/
fn match_guard_outer_variables() {
    let x = Some(5);
    let y = 10;

    match x {
        Some(50) => println!("Got 50"),
        Some(n) if n == y => println!("Matched, n = {:?}", n),
        _ => println!("Default case, x = {:?}", x),
    }

    println!("at the end: x = {:?}, y = {:?}", x, y);
}

/*
@ Bindings

The at operator (@) lets us create a variable that holds a value at the same
time we’re testing that value to see whether it matches a pattern.

Example where we want to test that a Message::Hello id field is within the
range 3...7. But we also want to bind the value to the variable id_variable
so we can use it in the code associated with the arm.
*/
fn using_at_operator_bindings() {
    enum Message {
        Hello { id: i32 },
    }

    let msg = Message::Hello { id: 5 };

    match msg {
        Message::Hello {
            id: id_variable @ 3...7,
        } => println!("Found an id in range: {}", id_variable),
        Message::Hello { id: 10...12 } => println!("Found an id in another range"),
        Message::Hello { id } => println!("Found some other id: {}", id),
    }
}

/*
Matching Numbers to a String Literal
*/
fn match_number_to_string_literal() {
    let x = 1;

    match x {
        1 => println!("one"),
        2 => println!("two"),
        3 => println!("three"),
        _ => println!("anything"),
    }
}

/*
Matching using or | pattern
*/
fn match_or_pattern() {
    let x = 1;

    match x {
        1 | 2 => println!("one or two"),
        3 => println!("three"),
        _ => println!("anything"),
    }
}

/*
Matching range values

Checks for matches in the range of values

Ranges are only allowed with numeric values or char values, because the
compiler checks that the range isn’t empty at compile time.
*/
fn match_range_values() {
    let x = 5;

    match x {
        1...5 => println!("one through five"),
        _ => println!("something else"),
    }
}

/*
Matching using range and char values

Same as above but with char values
*/
fn match_range_values_char() {
    let x = 'c';

    match x {
        'a'...'j' => println!("early ASCII letter"),
        'k'...'z' => println!("late ASCII letter"),
        _ => println!("something else"),
    }
}

/*
Matching and destructuring a struct.
*/
struct Point {
    x: i32,
    y: i32,
}

fn match_destructure_struct() {
    let p = Point { x: 0, y: 7 };

    let Point { x: a, y: b } = p;
    assert_eq!(0, a);
    assert_eq!(7, b);

    // Shorthand destructuring
    let p2 = Point { x: 0, y: 7 };

    let Point { x, y } = p2;
    assert_eq!(0, x);
    assert_eq!(7, 7)
}

/*
Match Expression and destructuring a struct
*/

fn match_expression_destructure_struct() {
    let p = Point { x: 0, y: 7 };

    match p {
        Point { x, y: 0 } => println!("On the x axis at {}", x),
        Point { x: 0, y } => println!("On the y axis at {}", y),
        Point { x, y } => println!("On neither axis: ({}, {})", x, y),
    }
}

/*
Matching and destructuring enums with different values

For enum variants without any data, like Message::Quit, we can’t destructure
the value any further. We can only match on the literal Message::Quit value,
and no variables are in that pattern.

For struct-like enum variants, such as Message::Move, we place curly brackets
and then list the fields with variables so we break apart the pieces to use
in the code for this arm.
*/
enum Message {
    Quit,
    Move { x: i32, y: i32 },
    Write(String),
    ChangeColor(i32, i32, i32),
}

fn match_destructure_enum() {
    let msg = Message::ChangeColor(0, 160, 255);

    match msg {
        Message::Quit => println!("The Quit variant has no data to destructure."),
        Message::Move { x, y } => {
            println!("Move in the x direction {} and in the y direction {}", x, y);
        }
        Message::Write(text) => println!("Text message: {}", text),
        Message::ChangeColor(r, g, b) => {
            println!("Change the color to red {}, green {}, and blue {}", r, g, b)
        }
    }
}

/*
Matching and Destructuring References

Destructuring a reference to a struct into the struct field values

This code gives us the variable sum_of_squares holding the value 135,
which is the result of squaring the x value and the y value, adding
those together, and then adding the result for each Point in the points
vector to get one number.

This works because we try to match a reference to a Point and not
a Point itself.
*/
fn match_sum_of_squares() {
    let points = vec![
        Point { x: 0, y: 0 },
        Point { x: 1, y: 5 },
        Point { x: 10, y: -3 },
    ];

    let sum_of_squares: i32 = points.iter().map(|&Point { x, y }| x * x + y * y).sum();
}

/*
Complex Multiple Destructuring
*/
fn complex_destructure() {
    let ((feet, inches), Point { x, y }) = ((3, 10), Point { x: 3, y: -10 });
}

/*
Ignoring values Using _ Underscore as a Wildcard in Pattern Matching

This code will completely ignore the value passed as the first argument,
3, and will print This code only uses the y parameter: 4.

Ignoring a function parameter can be especially useful in some cases, for example,
when implementing a trait when you need a certain type signature but the function body
in your implementation doesn’t need one of the parameters. The compiler will then not
warn about unused function parameters, as it would if you used a name instead.
*/
fn match_underscore_wildcard(_: i32, y: i32) {
    println!("This code only uses the y parameter: {}", y);
}

/*
Using _ Underscore to ignore part of a value
*/
fn underscore_ignore_partial() {
    let mut setting_value = Some(5);
    let new_setting_value = Some(10);

    match (setting_value, new_setting_value) {
        (Some(_), Some(_)) => {
            println!("Can't overwrite an existing customized value");
        }
        _ => {
            setting_value = new_setting_value;
        }
    }

    println!("setting is {:?}", setting_value);
}

/*
Ignoring Values in Tuples using _ Underscore

Ignoring the second and fourth values in a tuple of five items.
*/
fn ignore_tuple_values() {
    let numbers = (2, 4, 8, 16, 32);

    match numbers {
        (first, _, third, _, fifth) => println!("Some numbers: {}, {}, {}", first, third, fifth),
    }
}

/*
Tell Rust Compiler to Ignore Unused Variable using Underscore

The allow unused variables is set for every module here, but
in a normal situation the Rust compiler would warn about
the unused variable y.
*/
fn ignore_unused_variable_with_underscore() {
    // Rust compiler won't throw warning for _x
    let _x = 5;
    // Rust compiler will throw warning for y
    let y = 10;
}

/*
Using .. to match only certain values in tuples
*/
fn match_with_tuple_first_last() {
    let numbers = (2, 4, 8, 16, 32);

    match numbers {
        (first, .., last) => {
            println!("Some numbers: {}, {}", first, last);
        }
    }
}

/*
Creating References in Patterns with ref

To create references in patterns the ref keyword must be used.
This is because the syntax & in patterns does not create a reference
but matches an existing reference in the value. Because & already has that
meaning in patterns, we can’t use & to create a reference in a pattern.
*/
fn pattern_reference_with_ref() {
    let robot_name = Some(String::from("Bors"));

    match robot_name {
        Some(ref name) => println!("Found a name: {}", name),
        None => (),
    }

    println!("robot_name is: {:?}", robot_name);
}

/*
Creating References in Patterns with Ref mut

Same reference rules apply for mutable references
as immutable references in pattern matching

Because name is a mutable reference, we need to dereference within the
match arm code using the * operator to mutate the value.
*/
fn pattern_reference_with_ref_mut() {
    let mut robot_name = Some(String::from("Bors"));

    match robot_name {
        Some(ref mut name) => *name = String::from("Another name"),
        None => (),
    }

    println!("robot_name is: {:?}", robot_name);
}

/*
Using a combination of if let, else if, and else if let

if let Ok(age) = age introduces a new shadowed age variable that contains
the value inside the Ok variant. This means we need to place the if age > 30
condition within that block; they cannot be combined.
 The shadowed age we want to compare to 30 isn’t valid until the new scope
 starts with the curly bracket.

 The downside of using if let expressions is that the compiler doesn’t check
 exhaustiveness, whereas with match expressions it does. If we omitted the
 last else block and therefore missed handling some cases, the compiler would
 not alert us to the possible logic bug.
*/
fn mix_and_match() {
    let favorite_color: Option<&str> = None;
    let is_tuesday = false;
    let age: Result<u8, _> = "34".parse();

    if let Some(color) = favorite_color {
        println!("Using your favorite color, {}, as the background", color);
    } else if is_tuesday {
        println!("Tuesday is green day!");
    } else if let Ok(age) = age {
        if age > 30 {
            println!("Using purple as the background color");
        } else {
            println!("Using orange as the background color");
        }
    } else {
        println!("Using blue as the background color");
    }
}

/*
while let loop using Vec

Uses the Vec as as Stack.

Stack is a common data structure that can use the
LIFO: Last in First Out approach or the FILO First in Last Out approach.


The while loop continues running the code in its block as long as pop
returns Some. When pop returns None, the loop stops.
*/

fn while_let_vec() -> usize {
    let mut stack = Vec::new();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    while let Some(top) = stack.pop() {
        println!("{}", top);
    }
    stack.len()
}

/*
for and patterns

The pattern is the value that directly follows the keyword for.

Example demonstrates how to use a pattern in a for loop to destructure,
or break apart, a tuple as part of the for loop.
*/

fn destructure_for() {
    let v = vec!['a', 'b', 'c'];

    for (index, value) in v.iter().enumerate() {
        println!("{} is at index {}", value, index);
    }
}

fn match_tuple_pattern_as_argument(&(x, y): &(i32, i32)) -> String {
    format!("Current location: ({}{})", x, y)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_match_tuple_pattern() {
        let point = (3, 5);
        assert_eq!(
            "Current location: (35)",
            match_tuple_pattern_as_argument(&point)
        )
    }

    #[test]
    fn test_while_let_vec() {
        assert_eq!(0, while_let_vec());
    }
}
