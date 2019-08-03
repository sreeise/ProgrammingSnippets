// Function Hoisting

// Function expressions are not hoisted. Function statements are hoisted.

// Function Expressions: Not Hoisted - Cannot be referenced before it is declared.
var foo = function() {};


// Function Statements: Hoisted - Can be referenced before it is declared.
function fooHoisted() {}


// Consider the following function statement logs. Because a function statement is hoisted
// only last definition of a function will be called so the number, 2, will be called here.
function getNumber() { return 1; }

console.log(getNumber()); // => 2

function getNumber() { return 2; }


// For function expressions the exact opposite is true. A function expression cannot be
// referenced before it is defined and is not hoisted. Because of this only the most
// recent definition of a function expression will be used. So the following will
// log 1 to the console because the first getString definition is the most recent.
function getString() { return "1"; }

console.log(getString()); // => "1"

function getString() { return "2" }


