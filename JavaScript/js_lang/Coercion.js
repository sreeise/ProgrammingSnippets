// JavaScript Coercion

// JavaScript performs implicit conversion natively. However, JavaScript is different
// then most languages when it comes to how types are coerced. This is a pain point
// for a lot of new and experienced developers. The following shows a few areas
// to be aware of with in JavaScript concerning coercion.


// The first rule is to always use the triple equals operator (===) when comparing values.
// The double equals operator (==) in JavaScrip performs coercion while the triple equals
// does not. Only use == when you have a valid reason.

// For instance, checking if another value is equal to another using == and === will can
// yield completely different results.

// When comparing a string and a number, using ==, the JavaScript compiler
// will implicitly coerce using ToNumber(x):

// The string "3" is coerced to the number 3 when using == to compare.
console.log("3" == 3); // => true
// The String "3" is not coerced when using === to compare
console.log("3" === 3); // => false


// Consider the following example:
console.log(0 == []); // => true

// Arrays are coerced using the ToPrimitive() function.
// First, JavaScript Arrays are objects. When coercing types
// the spec (ECMAScript), says to call the toString() method on
// an object. Therefore, an empty array is coerced to an empty string.
// Next since we are comparing a number to a string, the string is coerced
// to a number as previously shown using ToNumber(): ToNumber("") converts to 0

// The basic coercion here happens as follows:
// 1. Call toString on the object => [].toString() = ""
// 2. Call ToNumber on the string => "" = 0
// 3. return 0 == 0 => true

// This is why you should almost always use triple equals: ===
console.log(0 === []); // => false


// JavaScript order of operations;

// Normal string concatenation.
console.log(1 + "2" + "2"); // => 122


// The following statement, 1 + + "2" + "2" has an order of operations in JavaScript as follows:
// 1. The first operation is: + "2". The + here is a unary operator
//    and causes the "2" to be coerced to a number.
// 2. Next is the number, 1, plus the newly coerced number, 2 which equals 3.
// 3. Lastly, a string concatenation operation is performed when 3 and 2 which equals 32.
console.log(1 + + "2" + "2"); // => 32


// The following statement, +"1" + "1" + "2", has an order of operations in JavaScript as follows:
// 1. The first operation, + "1", coerces the string to the number 1.
// 2. The next operation, 1 + "1", performs string concatenation equaling "11".
// 3. The last operation, "11" + "2", is another string concatenation equaling "112"
console.log(+"1" + "1" + "2"); // => "112"


// The following statement, "A" - "B" + "2", has an order of operations in JavaScript as follows:
// 1. The - applied to strings so the operation, "A" - "B" results in NaN.
// 2. The next operation, NaN + "2", performs string concatenation resulting in "NaN2".
console.log("A" - "B" + "2"); // => "NaN2"