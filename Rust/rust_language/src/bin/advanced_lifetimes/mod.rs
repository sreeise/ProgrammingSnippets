/*
Advanced lifetimes struct

All Code and Definitions from:
https://doc.rust-lang.org/book/second-edition/ch19-02-advanced-lifetimes.html

Advanced Features of Rust Lifetime
    1. Lifetime subtyping:
        ensures that one lifetime outlives another lifetime
    2. Lifetime bounds:
        specifies a lifetime for a reference to a generic type
    2. Inference of trait object lifetimes:
        allows the compiler to infer trait object lifetimes and when they need to be specified
*/

/*
Lifetime subtyping

Lifetime subtyping specifies that one lifetime should outlive another lifetime.

In our definition of Parser, to say that 's (the lifetime of the string slice)
is guaranteed to live at least as long as 'c (the lifetime of the reference to Context),
*/
struct Context<'a>(&'a str);

struct Parser<'c, 's: 'c> {
    context: &'c Context<'s>,
}

/*
Example of using Parser:

fn parse_context(context: Context) -> Result<(), &str> {
    Parser { context: &context }.parse()
}*/

/*
Lifetime Bounds

Lifetime bounds help Rust verify that references in generic types
won’t outlive the data they’re referencing.
*/

// Lifetime bound on Generic Type T
// specifies that any references in T live at least as long as 'a
struct Ref<'a, T: 'a>(&'a T);

// Static lifetime of struct Ref
// Adding a 'static lifetime bound to T to constrain T to types that
// have only 'static references or no references
struct StaticRef<T: 'static>(&'static T);

/*
Inference of Trait Object Lifetimes

Lifetime and Trait Object Rules:
    1. The default lifetime of a trait object is 'static.
    2. With &'a Trait or &'a mut Trait, the default lifetime of the trait object is 'a.
    3. With a single T: 'a clause, the default lifetime of the trait object is 'a.
    4. With multiple clauses like T: 'a, there is no default lifetime; we must be explicit.
*/
trait Red {}

struct Ball<'a> {
    diameter: &'a i32,
}

impl<'a> Red for Ball<'a> {}

fn main() {
    let num = 5;

    let obj = Box::new(Ball { diameter: &num }) as Box<dyn Red>;
}
