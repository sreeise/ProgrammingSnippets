// Array References

// Arrays can be references of another. In certain cases, such as using Array.reverse(),
// a reference to an array will also modify the original array.

let arr1 = "string".split("");
let arr2 = arr1.reverse(); // arr1 is also now reversed.

// arr1 and arr2 refer to the same object.
console.log(arr1); // => [ 'g', 'n', 'i', 'r', 't', 's' ]
console.log(arr2); // => [ 'g', 'n', 'i', 'r', 't', 's' ]