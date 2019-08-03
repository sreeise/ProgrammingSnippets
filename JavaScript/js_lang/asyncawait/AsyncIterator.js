// Async Iterators

// The async await syntax can be used on iterators that implement async natively.
// Additionally, the for await... of loop can be used to iterator over async iterators.

let iter = {
    [Symbol.asyncIterator]() {
        return {
            i: 0,
            next() {
                if (this.i < 3) {
                    return Promise.resolve({ value: this.i++, done: false });
                }

                return Promise.resolve({ done: true });
            }
        };
    }
};

(async function() {
    for await (let num of iter) {
        console.log(num); // 1 2 3
    }
})();