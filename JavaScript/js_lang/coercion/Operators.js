// JavaScript Operators Coercion

// JavaScript operators may have different outcomes depending on the types
// that are being used.

/*
The addition operator has the following outcome for these types:

1. Number + Number = Addition
2. Boolean + Number = Addition
3. Boolean + Boolean = Addition
4. Number + String = Concatenation
5. String + Boolean = Concatenation
6. String + String = Concatenation

For boolean primitives, false is coerced to 0 and true is coerced to 1.
 */

// Number + Number results in a Mumber.
let num = 3 + 3;
console.log(num); // => 6

// Boolean + Number results in a Number
let boolNum = true + 1;
console.log(boolNum); // => 2

// Boolean + Boolean results in a Number
let zero = false + false;
console.log(zero); // => 0 - false is 0 so this is 0 + 0 = 0

let one = true + false;
console.log(one); // => 1 - true is 1 and false is 0 so this is 1 + 0 = 1

let two = true + true;
console.log(two); // => 2 - true is 1 so this is 1 + 1 = 2

// Number + String results in a String
let numString  = 5 + "num";
console.log(numString); // => '5num'

// String + Boolean results in a String
let stringBool = "string " + false;
console.log(stringBool); // => 'string false'

// String + String results in a String
let string = "Hello " + "World!";
console.log(string); // => 'Hello World!'

