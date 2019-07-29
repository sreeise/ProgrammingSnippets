// Promise Finally

// The finally() method returns a Promise. When the promise is settled, i.e either
// fulfilled or rejected, the specified callback function is executed. This provides
// a way for code to be run whether the promise was fulfilled successfully or rejected
// once the Promise has been dealt with.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/finally

// Similar example to MDN web docs:
let loading = true;

Promise.resolve(setTimeout(() => {
    return 3
}, 500))
    .then(value => {
        console.log("Number: " + value);
    }).finally(() => {
        loading = false;
});