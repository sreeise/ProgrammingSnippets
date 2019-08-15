let IntPriorityQueue = require("../data_structures/queues/PriorityQueue");
let Queue = require("../data_structures/queues/Queue");

let chai = require('chai');
let assert = chai.assert;
let expect = chai.expect;

describe('Queue Test', function() {
    it("Queue operations should work as expected", function() {
        let queue = new Queue();
        assert.isTrue(queue.isEmpty());

        queue.enqueue(3);
        queue.enqueue(6);

        assert.isFalse(queue.isEmpty());
        assert.equal(queue.dequeue(), 3);
        assert.equal(queue.dequeue(), 6);
        assert.isTrue(queue.isEmpty());
    });
});

describe('IntPriorityQueue Test', function() {
    it("IntPriorityQueue operations should work as expected", function() {
        let queue = new IntPriorityQueue();
        assert.isTrue(queue.isEmpty());

        queue.add(3);
        queue.add(6);

        assert.isFalse(queue.isEmpty());
        assert.equal(queue.poll(), 3);
        assert.equal(queue.poll(), 6);

        queue.add(6);
        queue.add(3);

        assert.equal(queue.poll(), 3);
        assert.equal(queue.poll(), 6);

        queue.add(6);
        queue.add(3);

        assert.equal(queue.peek(), 3);
        assert.equal(queue.poll(), 3);
        assert.equal(queue.peek(), 6);
    });
});

describe('IntPriorityQueue Type Test', function() {
    it("IntPriorityQueue should only accept integers", function() {
        let queue = new IntPriorityQueue();

        expect(function() {
            queue.add("3");
        }).to.throw();

        expect(function() {
            queue.add(3.2);
        }).to.throw();
    });
});