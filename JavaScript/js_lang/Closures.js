// Closures

// A closure is the combination of a function and the lexical environment within which
// that function was declared.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Closures

// Inner function closure.

// At first look it may seem like the the variable i could not be referenced
// from where `value` is called below. However, the increment function creates
// a closure containing the lexical scope of the closureFunction and so it still
// has access to the variable i.
function closureFunction() {
    let i = 1;

    function increment() {
        i++;
        console.log(i);
    }
    return increment;
}

let value = closureFunction(); // => value is not equal to the function increment().
value(); // => 2;



// There are common issues when using closures in loops.
// For instance, calling setTimeout inside a loop and
// using the loops counter and/or modifying it may
// have unintended consequences.

// For instance, the following function does not print
// the intentioned value of i. Instead, it prints
// the values of i after the loop has already executed
// completely. At that point, there will only be one global
// variable of i left which is 5.
//
// To solve this issue the setTimeout function needs its
// own copy of i for each iteration.

function badClosureLoop() {
    for (var i = 1; i < 5; i++) {
        setTimeout(function() {
            console.log(i);
        }, i * 1000);
    }
}

badClosureLoop(); // => 5 5 5 5

// There are several ways to fix this.

// You can use a let binding set to i.

for (var i = 1; i < 5; i++) {
    let value = i;
    setTimeout(function () {
        console.log(value)
    }, value * 1000);
} // => 1 2 3 4

// Or in the for loop itself by creating i with the let keyword.
for (let i = 1; i < 5; i++) {
    setTimeout(function() {
        console.log(i);
    }, i * 1000);
} // => 1 2 3 4

// You can use another variable, using the var keyword, that is set to i inside a
// an immediately invoked function expression
for (var j = 1; j < 5; j++) {
    (function() {
        var value = j;
        setTimeout(function() {
            console.log(value);
        }, value * 1000);
    })(); // => 1 2 3 4
}

for (var k = 1; k < 5; k++) {
    (function(value) {
        setTimeout(function() {
            console.log(value);
        }, value * 1000);
    })(k); // => 1 2 3 4
}

// Object closures and the module pattern
function Counter() {
    let count = 0;

    function getCounter() {
        return count;
    }

    function logCounter() {
        console.log(count);
    }

    function increment() {
        count += 1;
    }

    function decrement() {
        count -= 1;
    }

    return {
        getCounter: getCounter,
        logCounter: logCounter,
        increment: increment,
        decrement: decrement,
    }
}

let counter = Counter();

counter.increment();
counter.logCounter(); // => 1

counter.decrement();
counter.logCounter(); // => 0

counter.increment();
console.log(counter.getCounter()); // => 1

counter.increment();
console.log(counter.getCounter()); // => 2

// Assign counter and copy it to another variable.
let counterCopy = counter.getCounter();
counterCopy += 1;

// Counter copy is its own variable and does not reference the Counter functions
// count variable.
console.log(counterCopy); // => 3
counter.logCounter(); // => 2


// You can also return back a function.

// Return a constructor function.
function CounterConstructorFn() {
    let count = 0;

    function getCounter() {
        return count;
    }

    function logCounter() {
        console.log(count);
    }

    function increment() {
        count += 1;
    }

    function decrement() {
        count -= 1;
    }

    // Return a constructor function
    return function() {
        this.getCounter = getCounter;
        this.logCounter = logCounter;
        this.increment = increment;
        this.decrement = decrement;
    };
}

let counterFunc = CounterConstructorFn();
let count = new counterFunc();

count.logCounter(); // => 0
count.increment();
count.logCounter(); // => 1