/*
Macros

Macros using macro_use can be used in modules, however,
derivable macros must be in their own crate
*/

/*
Derive Macro

Derive macros are created using the syntax:

    #[proc_macro_derive(MacroName)]

Then using the macro as a derive macro:

    #[derive(MacroName)]
*/

/*
create_function() and print_result() can be used like so:

#[macro_use]
mod macro_usage

   create_function!(foo);

   foo();


    print_result!(1u32 + 1);

    // Recall that blocks are expressions too!
    print_result!({
        let x = 1u32;

        x * x + 2 * x - 1
    });
*/

#[macro_export]
macro_rules! create_function {
    // This macro takes an argument of designator `ident` and
    // creates a function named `$func_name`.
    // The `ident` designator is used for variable/function names.
    ($func_name:ident) => {
        fn $func_name() {
            // The `stringify!` macro converts an `ident` into a string.
            println!("You called {:?}()", stringify!($func_name));
        }
    };
}

#[macro_export]
macro_rules! print_result {
    // This macro takes an expression of type `expr` and prints
    // it as a string along with its result.
    // The `expr` designator is used for expressions.
    ($expression:expr) => {
        // `stringify!` will convert the expression *as it is* into a string.
        println!("{:?} = {:?}", stringify!($expression), $expression);
    };
}
