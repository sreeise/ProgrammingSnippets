


### Types of Integers
        Length 	Signed 	Unsigned
        8-bit 	i8 	u8
        16-bit 	i16 	u16
        32-bit 	i32 	u32
        64-bit 	i64 	u64
        128-bit 	i128 	u128
        arch 	isize 	usize


### Integer types - unsigned and signed
"Each variant can be either signed or unsigned and has an explicit size. Signed and unsigned refer to whether 
it’s possible for the number to be negative or positive—in other words, whether the number needs to have a 
sign with it (signed) or whether it will only ever be positive and can therefore be represented without 
a sign (unsigned)." from https://doc.rust-lang.org/book/2018-edition/ch03-02-data-types.html

isize and usize also require specific architecture. Integers default to i32.

### Floating point

    // Two floating point types for Rust
    f32
    f64