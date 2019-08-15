

// For a large list (a lot larger then the one below) you can use
// setTimeout to perform the recursive method below on the event
// loop instead of the stack which will prevent stack overflow.
let list = ["string"];

let nextItem = function() {
    let item = list.pop();

    if (item) {
        setTimeout(nextItem, 0)
    }
};

