let Stack = require("../data_structures/stacks/Stack");

let chai = require('chai');
let assert = chai.assert;

describe('Stack Data Structure', function() {
    it("Stack operations should work as expected", function() {
       let stack = new Stack();
       assert.equal(stack.isEmpty(), true);

       stack.push(3);
       assert.equal(stack.peek(), 3);
       assert.equal(stack.isEmpty(), false);

       stack.push(4);
       assert.equal(stack.peek(), 4);

       stack.pop();
       assert.equal(stack.peek(), 3);

       stack.pop();
       assert.equal(stack.peek(), null);
       assert.equal(stack.isEmpty(), true);

       stack.push(3);
       stack.push(4);
       assert.equal(stack.peek(), stack.pop());
    });
});