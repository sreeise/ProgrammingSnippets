// The Singleton Pattern

// The singleton pattern is used to prevent instantiating an object multiple times. In the singleton pattern
// there should only ever be one instantiation of the object. It is possible to have multiple references.

let Singleton = (function() {
    let instance;

    function init() {
        let value = 0;

        function increment() {
            return value++;
        }

        function decrement() {
            return value--;
        }

        function clear() {
            value = 0;
        }

        function asStr() {
            return `${value}`;
        }

        return {
            increment: increment,
            decrement: decrement,
            clear: clear,
            asStr: asStr,
        }
    }

    return {
        getInstance: function() {
            if (!instance) {
                instance = init();
            }

            return instance;
        }
    }
})();

let instance = Singleton.getInstance();
instance.increment();

let instance2 = Singleton.getInstance();

console.log("instance #1: " + instance.asStr()); // => 1
console.log("instance #2: " + instance2.asStr()); // => 1

instance.increment();
console.log("instance #1: " + instance.asStr()); // => 3
console.log("instance #2: " + instance2.asStr()); // => 3

instance2.increment();
console.log("instance #1: " + instance.asStr()); // => 4
console.log("instance #2: " + instance2.asStr()); // => 4