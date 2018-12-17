/*
Rust Ownership References and Dereferences
*/

/*
References

Also see borrowing_references directory

References: Access a value without effecting ownership

Immutable References:
    1. Cannot be modified.
    2. Can have as many shared references as needed.

Mutable References:
    1. Can be modified.
    2. Can only be one mutable reference in a scope at one time.

Moving ownership is pass by value.
Passing a function as a reference to a value is passing a value by reference.

Dot operators in Rust implicitly dereferences its left operand.
*/

use std::collections::HashMap;

type Table = HashMap<String, Vec<String>>;

/*
Takes a shared reference to table and cannot
be modified.

A caller would need to pass a shared immutable refernce to the table:
    &table
*/
fn print_table(table: &Table) {
    for (artist, works) in table {
        println!("works by {}:", artist);
        for work in works {
            println!("  {}", work);
        }
    }
}

/*
Takes a mutable reference to table
and sorts the works.

A callers of this function would need to pass
a mutable reference to the table:
    &mut table
*/
fn sort_table_works(table: &mut Table) {
    for (_artist, works) in table {
        works.sort();
    }
}

fn hash_table() {
    let mut table = Table::new();
    table.insert(
        "Gesualdo".to_string(),
        vec![
            "many madrigals".to_string(),
            "Tenebrae Responsoria".to_string(),
        ],
    );
    table.insert(
        "Caravaggio".to_string(),
        vec![
            "The Musicians".to_string(),
            "The Calling of St. Matthew".to_string(),
        ],
    );
    table.insert(
        "Cellini".to_string(),
        vec![
            "Perseus with the head of Medusa".to_string(),
            "a salt cellar".to_string(),
        ],
    );

    print_table(&table);
    sort_table_works(&mut table);
    println!("Table: {:?}", table);
}

/*
* Dereference Operator
*/
fn assert_immutable_dereference() {
    let num1 = 10;

    // Shared reference to num2
    let num2 = &num1;

    // Dereference num2
    assert_eq!(*num2, 10);
}

fn assert_mutable_dereference() {
    let mut num = 32;

    // &mut num is a mutable reference to y
    let mut_num = &mut num;

    // explicitly dereference the value to set num value
    *mut_num += 32;

    // Assert that the value changed.
    assert_eq!(*mut_num, 64);
}

/*
Arithmetic Operators

Arithmetic operators can see through one level of references.

Rust creates an anonymous variable and makes the reference point to it and
its lifetime depends on the reference:
    1. If the variable is immediately assigned such as in a let statement,
        the lifetime will be of that it is assigned to.
    2. If not the anonymous variable lives until the enclosing statement.
*/

fn factorial(n: usize) -> usize {
    (1..n + 1).fold(1, |a, b| a * b)
}

fn assert_factorial() {
    let r = &factorial(6);

    assert_eq!(r + &1009, 1729);
}
