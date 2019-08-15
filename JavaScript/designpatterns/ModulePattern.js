// The Module Pattern

// The module pattern is used to hide variables and functions by limiting their
// existence to within a modules closure. The name given to the module
// is the name that it is assigned to and this name must be used to access
// any public functions or variables.

// The counter variable is hidden from any use outside the closure while the increment and
// decrement functions are public to the caller.
let counterModule = (function() {
    let counter = 0;

    return {
        increment: function() {
            return counter++;
        },

        decrement: function() {
            return counter--;
        },
    }
})();


console.log(counterModule.increment()); // => 1

console.log(counterModule.decrement()); // => 0

console.log(counterModule.counter); // => undefined