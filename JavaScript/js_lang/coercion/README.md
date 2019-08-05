# JavaScript Type Coercion

Type coercion refers to types being implicitly converted from one type to another.
There is also type conversion which can be either implicit or explicit.

Implicit coercion happens automatically while explicit conversion is done manually
by the programmer.

JavaScript is interpreted and dynamically typed. This means that types does not need
to be known at runtime. This is unlike most compiled languages that are statically
typed and must know the types of variables at compile time. There are also languages,
such as the Rust programming language, that are statically typed with type inference, 
which means that the type must be known at compile time but that the compiler can
also infer some types without the programmer explicitly stating the type. 

Since JavaScript is interpreted and dynamically typed, there are many areas where
types are implicitly coerced to another type and this is often a point of confusion
for even seasoned programmers. The JS scripts in this directory provide some
examples and knowledge on those areas in JavaScript that programmers should be aware of.

Of paticular interest in JavaScript is the difference between the double equals 
operator, `==`, and the triple equals operator, `===`. Unless there is a good
reason to do so, JavaScript developers should always use the triple equals operator.
The double equals operator, `==`, will coerce types before comparing them which, if not
careful, can lead to bugs that are hard to deduce. The triple equals operator, `===`, 
does not coerce types and will be false when the two types being compared are not the
same. The triple equals operator is what you almost always want to use. 

This is not a complete reference. For more information on type coercion and type
conversion in JavaScript see the following sources:

1. [Type Coercion - MDN web docs](https://developer.mozilla.org/en-US/docs/Glossary/Type_coercion)
2. [Type Conversion - MDN web docs](https://developer.mozilla.org/en-US/docs/Glossary/Type_conversion)
3. [Equality comparisons and sameness - MDN web docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Equality_comparisons_and_sameness)