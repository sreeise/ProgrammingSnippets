// JavaScript Objects.

// There are three ways to create an object:
// 1. Constructor Notation.
// 2. Literal Notation
// 3. Object.Create()

// Constructor Notation

let cpu = new Object();

cpu.cores = 2;

console.log(obj.cores); // => 2


// Literal Notation

let armCpu = {
    cores: 2,
};

console.log(armCpu.value); // => 2


// Object.Create()
// Create a new object using an existing object.

let obj3 = Object.create(obj2);

console.log(obj3.value); // => 2


// JavaScript Properties and Property Names

/*
There are two ways to access object properties:
    1. Dot Notation. Also known as property access.
    2. Bracket Notation. Also known as key access.

Important Info regarding object properties:
    1. Internally, objects store property names that are references
       to their assigned values.
    2. Property names are always Strings. Any other objects besides
       string primitives will be converted to a String when used
       as a value in accessing an object through bracket notation.
    3. Bracket notation can take any UTF-8 or Unicode string. However,
       properties that do not conform to the JavaScript syntax such
       as the characters `!` or `-` would only be accessible through
       bracket notation.
 */

var obj4 = {
    "name": "John Doe",
    "key-value": {key: "key", value: "value"},
};

console.log(obj4["name"]); // => John Doe
console.log(obj4.name); // => John Doe

console.log(obj4["key-value"]); // => Object { key: "key", value: "value" }
console.log(obj4.key-value); // =>  ReferenceError: value is not defined

