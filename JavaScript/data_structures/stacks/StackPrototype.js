// Stack Data Structure

// Stacks serve as a collection of elements using the LIFO (last in first out) ordering.

// An array in JavaScript has built-in methods for using it as as stack and it may not
// be necessary to create a Stack object. This is done here for demonstrative purposes.

// This example shows creating a stack using the prototype mechanism. For using a class
// see: Stack.js

function Stack() {
    this.stack = [];
}

Stack.prototype.push = function (element) {
  this.stack.push(element);
};

Stack.prototype.pop = function() {
    return this.stack.pop();
};

Stack.prototype.peek = function() {
    return this.isEmpty() ? null : this.stack[this.stack.length -1];
};

Stack.prototype.isEmpty = function() {
    return this.stack.length === 0;
};
