/**
 * SinglyLinkedList Node
 */
class Node {
    constructor(data, next = null) {
        this.data = data;
        this.next = next;
    }
}

/**
 * Single linked list where each node has a pointer to
 * the next node in the list.
 */
class SinglyLinkedList {
    constructor() {
        this.head = null;
        this._size = 0;
    }

    add(data) {
        if (this.head == null) {
            this.head = new Node(data);
            this._size = 1;
        } else {
            let newNode = new Node(data);
            newNode.next = this.head;
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

module.exports.SinglyLinkedList = SinglyLinkedList;
module.exports.Node = Node;