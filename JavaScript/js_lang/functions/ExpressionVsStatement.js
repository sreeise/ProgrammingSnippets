// Function Expression vs Function Statement

// A function expression creates an anonymous function and
// is used to assign a variable to a function:
let num = function() {
    return 1;
};

console.log(num()); // => 1


// A function statement is called by its function name and
// looks as follows:
function getNum() {
    return 1;
}

console.log(getNum()); // => 1