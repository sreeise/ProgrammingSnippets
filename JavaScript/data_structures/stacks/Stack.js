// Stack Data Structure

// Stacks serve as a collection of elements using the LIFO (last in first out) ordering.

// An array in JavaScript has built-in methods for using it as as stack and it may not
// be necessary to create a Stack object. This is done here for demonstrative purposes.

class Stack {
    constructor() {
        this.stack = [];
    }

    // Push an element onto the top of the stack.
    push(value) {
        this.stack.push(value);
    }

    // Remove and return the element at the top of the stack.
    pop() {
        return this.stack.pop();
    }

    // Return the element at the top of the stack but don't remove
    // it from the stack.
    peek() {
        return this.isEmpty() ? null : this.stack[this.stack.length -1];
    }

    // Check if the stack is empty.
    isEmpty() {
        return this.stack.length === 0;
    }
}

module.exports = Stack;