let chai = require('chai');
let LinkedList = require("../data_structures/linkedlists/DoublyLinkedList.js").DoublyLinkedList;
let Node = require("../data_structures/linkedlists/DoublyLinkedList.js").Node;
let assert = chai.assert;
let expect = chai.expect;

describe('DoubleLinkedList Node', function() {
    it("should have pointers to next and previous nodes", function() {
        let node = new Node(3);
        let tail = new Node(2);
        let tail2 = new Node(8);
        node.next = tail;
        tail.prev = node;
        node.next.next = tail2;
        tail2.prev = tail;

        assert.equal(node.data, 3);
        assert.equal(node.next.data, 2);
        assert.equal(node.next.next.data, 8);
        assert.equal(node.next.next.next, null);
        assert.equal(node.next.next.prev.data, 2);
        assert.equal(node.next.next.prev.prev.data, 3);
    });
});

describe('DoubleLinkedList', function() {
    it("should add and pop doubly linked list nodes", function() {
        let linkedList = new LinkedList();
        assert.equal(linkedList.isEmpty(), true);

        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);

        assert.equal(linkedList.isEmpty(), false);
        assert.equal(linkedList.size(), 3);
        assert.equal(linkedList.pop(), 8);
        assert.equal(linkedList.pop(), 5);
        assert.equal(linkedList.pop(), 3);
        assert.equal(linkedList.size(), 0);
        assert.equal(linkedList.isEmpty(), true);
    });
});

describe('DoubleLinkedList peekFirst() and peekLast()', function() {
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

describe('DoubleLinkedList Node error', function() {
    expect("should throw an error for attempting to insert a Node into the list", function() {
        let linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(2);
        expect(linkedList.add(new Node(3))).to.throw();
    });
});