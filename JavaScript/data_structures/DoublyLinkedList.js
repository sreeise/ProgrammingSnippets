/**
 * DoublyLinkedList Node
 */
class Node {
    constructor(data, next = null, prev = null) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * Double linked list where each node added to the list as pointers
 * to the previous and next node in the list.
 */
class DoublyLinkedList {
    constructor() {
        this.head = null;
        this._size = 0;
    }

    add(data) {
        if (data instanceof Node) {
            throw new Error("Data must be a non-node type");
        }

        if (this.head == null) {
            this.head = new Node(data);
            this._size = 1;
        } else {
            let newNode = new Node(data);
            let head = this.head;
            newNode.next = head;
            head.prev = newNode;
            this.head = newNode;
            this._size++;
        }
    }

    pop() {
        let temp = this.head;
        this.head = this.head.next;
        this._size--;
        return temp.data;
    }

    peekFirst() {
        let temp = this.head;
        return temp.data;
    }

    peekLast() {
        let temp = this.head;
        while (temp.next !== null) {
            temp = temp.next;
        }
        return temp.data;
    }

    isEmpty() {
        return this.size() === 0;
    }

    size() {
        return this._size;
    }
}

module.exports.Node = Node;
module.exports.DoublyLinkedList = DoublyLinkedList;
