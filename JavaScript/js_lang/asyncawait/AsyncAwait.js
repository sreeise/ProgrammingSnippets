// Async and Await

// The async function declaration defines an asynchronous function, which returns an
// AsyncFunction object.  An asynchronous function is a function which operates
// asynchronously via the event loop, using an implicit Promise to return its result.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/async_function

function multiplyNumber(num) {
    return new Promise(resolve => {
        resolve(Math.pow(num, 2));
    });
}

async function callMultiply() {
    let result = await multiplyNumber(10);
    console.log(result); // => 100
}

callMultiply().then(() => {
    // .. Do something else.
});