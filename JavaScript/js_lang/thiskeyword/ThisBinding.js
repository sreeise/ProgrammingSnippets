/*
The this keyword.
 */

// The window object is the global object and the `this` keyword refers to this object.
console.log(this === window); // => true


// Global scope binding: Global scope variables are always considered to be in the
// context of the this keyword as long as no variable in the local scope overrides it and
// strict mode is not enabled. The `var` declaration causes a variable to be hoisted,
// or in other words, put into memory during compilation allowing them to be used regardless
// of where they were defined which is why the `value` variable is valid here.
// However, note that the variable must be declared and initialized at the same time.

function logVariable() {
    console.log(this.value);
}

var value = 1;
logVariable(); // => 1


// Implicitly binding and the `this` keyword.

function fn() {
    console.log(this.array);
}

var obj = {
    array: ["string", "array"],
    fn: fn,
};

obj.fn(); // => ["string", "array"]


// JavaScript has the built-in `call` and `apply` functions which will create
// a new `this` binding with the object given as an argument. The `call` function
// takes an argument list while the `apply` function takes an array of arguments.

function fnCall() {
    console.log("Hello " + this.val);
}

var fnObject = {
    val: "World!",
};

fnCall.call(fnObject); // => Hello World!


// The `apply` function
var numbers = [5, 6, 2, 3, 7];

var max = Math.max.apply(null, numbers);

console.log(max); // => 7


// The `bind` method creates its own functions and sets the this keyword
// to the value provided as an argument.
var ValueObject = {
    value: "10",
    getValue() {
        return this.value;
    }
};

var v =  ValueObject.getValue;

var BindedValue = v.bind(ValueObject);

console.log(BindedValue()); // => 10


// Arrow function do not technically have a this value. The `this` in an arrow function is the
// same as the `this` in the lexically enclosing function.

var list = ["10", "100", "1000"];

let listSizes = list.map((element) => {
    return element.length;
});

console.log(listSizes); // => [2, 3, 4]
