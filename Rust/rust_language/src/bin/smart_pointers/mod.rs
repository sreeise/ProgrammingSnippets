/*
Smart Pointers

    A pointer is a general concept for a variable that contains an address in memory.
    This address refers to, or “points at,” some other data.

    Smart pointers, on the other hand, are data structures that not only act like a
    pointer but also have additional metadata and capabilities.

References vs Pointers
     References are pointers that only borrow data; in contrast, in many cases,
     smart pointers own the data they point to.

Definitions
    1. Deref Trait
        Allows an instance of the smart pointer struct to behave like a reference so
        you can write code that works with either references or smart pointers.
    2. Drop Trait
        Allows you to customize the code that is run when an instance of the smart
        pointer goes out of scope.
    3. Interior Mutability
        Where an immutable type exposes an API for mutating an interior value.
*/