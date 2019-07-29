// Spread Syntax

// For more information on the spread syntax see:
//  1. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax

// Return a number, x, raised to the given exponent y.
function pow(x, y) {
    return Math.pow(x, y);
}

// Without spread syntax:
console.log(pow.apply(null, [2, 3])); // => 8

// With spread syntax:
console.log(pow(...[2, 3])); // => 8


// With multiple parameters:
function powGreater(x, y, x2, y2) {
    let a = pow(x, y);
    let b = pow(x2, y2);
    return a > b ? a : b;
}

let arrayA = [2, 3];
let arrayB = [1, 2];

console.log(powGreater(...arrayA, ...arrayB)); // => 8


// Clone an object using spread syntax:
let obj = {
    value: 3,
};

let objCopy = { ...obj };

console.log(obj.value); // => 3

console.log(objCopy.value); // => 3



