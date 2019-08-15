// Priority Queue

// A Priority Queue is similar to a queue or stack data structure except that the ordering
// of elements is based upon a specific priority. Typically a priority queue has a default
// priority based upon the elements being inserted such as with numbers having a least
// to greatest order.

// Priority Queues have the requirement that the elements in the queue must be comparable.
// The following priority queue represents an integer priority queue and not other type
// can be used.


// This is a simple approach where the internal Array.sort() method is used. A better
// way would be to implement some type of comparators or a way of ordering to know
// where to insert a new element while also doing so quickly.
function IntPriorityQueue() {
    this.queue = [];
}

IntPriorityQueue.prototype = {
    add(element) {
        if (!Number.isInteger(element)) {
            throw new Error("Element given must be an integer");
        }

        this.queue.push(element);
        this.queue.sort();
    },

    poll() {
        return this.queue.shift();
    },

    peek() {
        return this.queue[0];
    },

    isEmpty() {
        return this.queue.length === 0;
    }
};

module.exports = IntPriorityQueue;

