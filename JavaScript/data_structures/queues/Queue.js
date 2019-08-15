// Queue Data Structure

// A Queue is a first in first out (FIFO) data structure.

// A Queue will enqueue elements onto the rear of the queue and will dequeue or remove
// elements at the front of the queue.

function Queue() {
    this.queue = [];
}

Queue.prototype = {
    enqueue(element) {
        this.queue.unshift(element);
    },

    dequeue() {
        return this.queue.pop();
    },

    isEmpty() {
        return this.queue.length === 0;
    }
};

module.exports = Queue;