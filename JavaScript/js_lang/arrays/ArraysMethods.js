// Arrays

// The following shows using methods common to arrays. For more general information on using
// arrays in JavaScript see: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array


// Array.from(): Creates a new shallow copied array from an Array instance or Array like iterable.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/from

let stringArray = ["string", "array"];

let copy = Array.from(stringArray);

console.log(copy); // => ["stirng", "array"]

// From a String:
let str = "Hello World!";
let arr = Array.from(str);
console.log(arr); // => [ 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!' ]

// From a Set:
let set = new Set([1, 2, 3, 4]);
let arrFromSet = Array.from(set);
console.log(arrFromSet); // => [1, 2, 3, 4]

// Array.from() accepts a mapFn argument much the same as the map() method.
let arrMap = Array.from(["Hello"], x => x + " World!");
console.log(arrMap); // => ["Hello World!"]


// Array.isArray(): Checks if the passed argument is an Array.
console.log(Array.isArray([1, 2, 3])); // => true


// Array.of(): Creates an Array from a variable number of arguments.
let array = Array.of("string", "array");
console.log(array); // => ['string', 'array']


// Array.concat(): Merge two or more arrays returning a new array.
let first = [1, 2];
let second = [3, 4];
let merged = first.concat(second);
console.log(merged); // => [1, 2, 3, 4]


// Array.copyWithin(): Shallow copies part of an array to another location.
// copyWithin(target, start, end)
// Copy elements 2 to 4 to the index starting at 0.
console.log([1, 2, 3, 4, 5].copyWithin(0, 2, 4)); // => [ 3, 4, 5, 4, 5 ]


// Array.fill(): Fills all the elements of an array from start index to an end index:
// Create an array of length 3
let five = Array(3);
five.fill(5);
console.log(five); // => [5, 5, 5]

// Or:
let six = [];
six.length = 5;
six.fill(6, 0, 5);
console.log(six); // => [6, 6, 6, 6, 6]


// Some():  Tests whether any element in the array passes for the provided function.
let testArr = [1, 2, 3];

function greaterThan(element) {
    return element > 2;
}

// The array has the number 3 so some() returns true.
console.log(testArr.some(greaterThan)); // => true