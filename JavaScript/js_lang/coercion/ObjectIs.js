// Object.is() is a comparison method that is unlike both the == and === operators.

// For more information on Object.is() see: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/is

/*
Object.is() Determines whether two values are the same value.

This method does not necessarily relate to type coercion but it is important
to understand the difference between using ==, ===, and Object.is().

Two values are considered the same if:
    1. Both undefined
    2. Both null
    3. Both true or both false
    4. Both strings of the same length with the same characters in the same order
    5. Both the same object (means both object have same reference)
    6. Both numbers and
        - both +0
        - both -0
        - both NAN
        - or both non-zero and both not NaN and both have the same value
*/


// String comparisons with Object.is() must be the exact same length and the exact same characters.
console.log(Object.is("s", "s")); // => true

console.log(Object.is("s", "a")); // => false


// Objects must hold the same reference
var obj = {
    num: 1,
};

var obj2 = {
    num: 1,
};

console.log(Object.is(obj, obj)); // => true

console.log(Object.is(obj, obj2)); // => false

// Reference to obj
let objRef = obj;

console.log(Object.is(obj, objRef)); // => true


// Null must be equal to null
console.log(Object.is(null, null)); // => true


// Two different arrays are also two different objects:
console.log(Object.is([], [])); // => false

// The same Array reference will be true:
let someArray = [];
let arrayRef = someArray;

console.log(Object.is(someArray, arrayRef)); // => true


// Unlike the === comparision of signed and unsigned 0, Object.is()
// compares the signs:
console.log(Object.is(0, -0)); // => false

console.log(Object.is(-0, -0)); // => true

// 0 divided 0 is equal to NaN:
Object.is(NaN, 0/0); // => true




