// Promise.resolve() and Promise.reject()

// Promise.resolve() returns a Promise object that is resolved with a given value. If the value
// is a promise then the same promise is returned. If the value has a thenable, or in other words
// has a .then method, the returned promise will follow that thenable, adopting its eventual state.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/resolve

// The Promise.reject() method returns a Promise object that is rejected with a given reason.
// If an empty iterable is passed to Promise.reject() the Promise to be forever pending.
// If the iterable contains non promise values or a promise has already resolved, then
// Promise.race() will resolve to the first value of that kind in the iterable.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/reject


// Promise.resolve()

// Promise.resolve() wraps the passed value, 42, in a Promise.
let getNumber = Promise.resolve(42);

getNumber.then(num => {
    console.log(num); // => 42
});

// Promise.resolve() will return the same Promise if one is passed to it.
let powPromise = new Promise(resolve => {
    resolve(Math.pow(10, 2));
});

let pow = Promise.resolve(powPromise);

pow.then(result => {
    console.log(result); // => 100
});


// Promise.reject()

Promise.reject(new Error("Not a number")).then(() => {
    // Not gonna happen.
}).catch(err => {
    console.log(err); // => Error: not a number
});
