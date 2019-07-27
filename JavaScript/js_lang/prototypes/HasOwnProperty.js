// Prototype hasOwnProperty

// For further information on hasOwnProperty see:
//  1. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/hasOwnProperty

// The hasOwnProperty method checks whether an object has a property defined on itself.
// Additionally, the hasOwnProperty method is the only thing in JavaScript that will
// not traverse the prototype chain.

let Person = function() {
    this.firstName = "John";
    this.lastName = "Doe";
};

Person.prototype.name = "John Doe";

let john = new Person();

console.log(john.hasOwnProperty("firstName")); // => true

console.log(john.hasOwnProperty("name")); // => false

// You can check the prototype using __proto__
console.log(john.__proto__.hasOwnProperty("name")); // => true

