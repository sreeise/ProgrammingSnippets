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


// An object or construct function `new` call will not override a bind call:
function Dog(name) {
    this.name = name;
}

var myDog = {};

var marshel = Dog.bind(myDog);
marshel("Marshal");

console.log(myDog.name); // => Marshal

var buster = new Dog("Buster");

// The object, myDog, property name is still the same:
console.log(myDog.name); // => Marshal
console.log(buster.name); // => Buster


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


// Constructor function this binding.

// When an object is created via a constructor function it has its this binding set as the
// object.

function Person() {
    this.name = "John Doe";
}

var john = new Person();

console.log(john.name); // => John Doe


// You can also set a this variable binding to a given argument:
function Animal(name) {
    this.name = name;
}

var dog = new Animal("Dog");

console.log(dog.name); // => Dog


// Another confusing area is the arguments object.
// In the following call to: obj.method(fn, 1), the output
// will be 10, 2. The reason is that fn is defined in the global
// scope and is called from the global scope so the this binding
// represents the global scope or window object and this.length
// on the global scope is equal to 10. When invoking arguments[0]()
// the fn function is called again except this time the scope
// of the fn call has changed to the arguments object which will
// log the length of the arguments object itself equaling 2.
var length = 10;
function fn() {
    console.log(this.length);
}

var obj = {
    length: 5,
    method: function(fn) {
        fn();
        arguments[0]();
    }
};

obj.method(fn, 1); // => 10, 2


// A variable within a function that is defined after it is used will cause the
// variable to be undefined when used. This is because JavaScript will first look
// to see if the variable is declared within the function scope. Because the variable
// is declared, but not until after its use, JavaScript will use that variable as
// undeclared.

var x = 21;
var logNum = function () {
    console.log(x); // Variable x shadows the outer scope x but is also undefined when used because it is
    var x = 20;     // used before it is declared.
};

logNum(); // => Undefined