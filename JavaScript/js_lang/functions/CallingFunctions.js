// Different ways to call functions and use function arguments.

// Functions have access to the built-in arguments object which contains
// all of the elements passed to the function:

function sum(x) {
    return x + arguments[1];
}

console.log(sum(2, 3)); // => 5

// Or:

function sumAgain() {
    return arguments[0] + arguments[1];
}

console.log(sumAgain(2, 3)); // => 5


// You could also return another function and pass another value:
function sumXY(x) {
    if (arguments.length === 2) {
        return arguments[0] + arguments[1];
    } else {
        return function(y) {
            return x + y;
        }
    }
}

console.log(sumXY(2)(3)); // => 5