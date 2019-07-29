// Promises

// Promises represent the eventual completion of an asynchronous operation.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises

// Basic Promise

// A promise takes two functions as arguments, The first, resolve,
// and the second, reject.
let getString = new Promise((resolve, reject) => {
   resolve("String");
});

// You could also leave out the reject part if you are just resolving
// and don't need to worry about error handling.
let getString2 = new Promise(resolve => {
   resolve("String");
});

getString.then(value => {
    console.log(value); // => String
});

getString2.then(value => {
    console.log(value); // => String
});


// Promise Constructor

// The following examples show how a promise constructor works. These aren't great
// examples of when to use promises. Rather, they are simplified for better understanding.

// Non-promise functions can be wrapped in promises use the Promise Constructor:
function validateInteger(number) {
    return new Promise((resolve, reject) => {
        if (number >= 10) {
            resolve(number);
        } else {
            reject("Number must be >= 10");
        }
    });
}

validateInteger(30).then((result) => {
    console.log(result); // => 10
}).catch((err) => {
    console.log(err); // Never actually runs as our number is >= 10.
});

validateInteger(5).then((result) => {
    console.log(result); // Never actually runs as our number is less then 10.
}).catch((err) => {
    console.log(err); // => Number must be >= 10
});


// Chaining with `then`
// A promises .then() call always expects a function as its argument, not another promise
// or any other value.

// Calling another promise based upon the result of the first promise.
// Here chaining is used with `then` to call another function only if
// the first function is success.
function multiplyInteger(number) {
    return number * 10;
}

validateInteger(10)
    .then(multiplyInteger)
    .then(result => {
        console.log(result); // => 100
    }).catch((err) => {
    // Never actually runs when passing 10.
    console.log(err);
});

// Suppose you want to do more validation after multiplying the integer.
// You could throw an error for an unsafe integer. When throwing an error
// within a promise chain the error will be caught by the next catch()
// in the chain.
validateInteger(Number.MAX_SAFE_INTEGER)
    .then(multiplyInteger)
    .then(result => {
        if (Number.isSafeInteger(result)) {
            // Never actually runs. MAX_SAFE_INTEGER * 10 is an unsafe integer.
            console.log(result);
        } else {
            throw new Error("Unsafe Integer");
        }
    }).catch((err) => {
    console.log(err.message); // => Unsafe Integer
});


// You could also use a chaining to pass in a success and failure function.

function onValidationSuccess(number) {
    console.log(number);
}

function onValidationFailure(err) {
    console.log(err);
}

validateInteger(10).then(onValidationSuccess, onValidationFailure); // => 10

validateInteger(5).then(onValidationSuccess, onValidationFailure); // => Number must be >= 10

// However, you must be careful that you don't have an unhandled error
// for the onValidationSuccess function. If an error does occurs occur
// in your success message, the error will not be caught by onValidationFailure.
// The errors that are caught by onValidationFailure are from the validateInteger
// method, not from the onSuccess function.
// To fix this you can add a .catch:

function onSuccessThrowError(number) {
    if (Math.pow(number, 2) === 100) {
        throw new Error("Intentionally throwing an error if the number is 10")
    } else {
        return Math.pow(number, 2);
    }
}

validateInteger(10)
    .then(onSuccessThrowError, onValidationFailure)
    .catch(err => {
       // Catching any error that occurred in onValidationSuccess.
       console.log(err); // => Intentionally throwing an error if the number is 10
    });


