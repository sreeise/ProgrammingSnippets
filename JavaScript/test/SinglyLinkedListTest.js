let chai = require('chai');
let LinkedList = require("../data_structures/SinglyLinkedList.js").SinglyLinkedList;
let Node = require("../data_structures/SinglyLinkedList.js").Node;

let assert = chai.assert;

describe('SinglyLinkedList Node', function() {
    it("each node should have pointers to next node", function() {
        let node = new Node(3);
        node.next = new Node(2);
        node.next.next = new Node(8);

        assert.equal(node.data, 3);
        assert.equal(node.next.data, 2);
        assert.equal(node.next.next.data, 8);
        assert.equal(node.next.next.next, null);
    });
});

describe('SinglyLinkedList', function() {
    it("should add and remove two integers", function() {
        let linkedList = new LinkedList();
        assert.equal(linkedList.isEmpty(), true);
        linkedList.add(3);
        linkedList.add(2);
        assert.equal(linkedList.isEmpty(), false);
        assert.equal(linkedList.pop(), 2);
        assert.equal(linkedList.pop(), 3);
        assert.equal(linkedList.isEmpty(), true);
    });
});

describe('SinglyLinkedList peekFirst() and peekLast()', function() {
    it("return node data without removing the node from the list", function() {
        let linkedList = new LinkedList();
        assert.equal(linkedList.isEmpty(), true);

        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);

        assert.equal(linkedList.isEmpty(), false);
        assert.equal(linkedList.size(), 3);
        assert.equal(linkedList.peekFirst(), 8);
        assert.equal(linkedList.peekLast(), 3);
        assert.equal(linkedList.size(), 3);
        assert.equal(linkedList.isEmpty(), false);
        assert.equal(linkedList.pop(), 8);
        assert.equal(linkedList.pop(), 5);
        assert.equal(linkedList.pop(), 3);
    });
});

