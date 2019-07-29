// Promise All and Promise Race

// Promise.all() returns a single Promise that resolves when all of the
// promises passed as an iterable have resolved or when the iterable
// contains no promises.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/all

// Promise.race() returns a promise that fulfills or rejects as soon as one of the
// promises in an iterable fulfills or rejects.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/race


// Promise.all()

// Create a few example promises.
let multipleNumber = new Promise(resolve => {
    resolve(10 * 10);
});

let setTimeoutPromise = new Promise(resolve => {
    // Wait 1 second and then resolve the integer 100.
    setTimeout(resolve, 1000, 100);
});

let getNumber = new Promise(resolve => {
    resolve(100);
});

// Call Promise.all() on the promises and get the result of all three at the same
// time.
Promise.all([multipleNumber, setTimeoutPromise, getNumber]).then((values) => {
    console.log(values); // => [ 100, 100, 100 ]
});


// Promise.race()

const getString1 = new Promise((resolve, reject) => {
    setTimeout(resolve, 1000, "get string #1");
});

const getString2 = new Promise((resolve, reject) => {
    setTimeout(resolve, 500, "get string #2");
});

Promise.race([getString1, getString2]).then((value) => {
   console.log(value); // => get string #2
});



