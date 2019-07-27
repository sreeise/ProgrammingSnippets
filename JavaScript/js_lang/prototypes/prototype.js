/*
Prototypes

For more information on prototypes see:
  1. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Inheritance_and_the_prototype_chain

Note: Consider using ES6 classes instead of prototypes for extending
and inheritance. Internally, classes are just syntactical sugar for
prototypes and the prototype chain but may offer a more clear
program structure.
 */

// Car object.
function Car(engine) {
  this.engine = engine;
}

// Adds a method the prototype of Car
Car.prototype = {
  getEngineType() {
    console.log(this.engine);
  }
};

// Extend a prototype - in object oriented programming you can extend
// objects and add functionality - this is the prototype way of inheritance
function EngineType(liters) {
  Car.call(this, "V6");
  this.liters = liters;
}

// Extend the prototype of Car using Object.create allowing
// us to call methods and use variables from Car in the
// EngineType objects
EngineType.prototype = Object.create(Car.prototype);

// Add more properties to the prototype
EngineType.prototype.getLiters = function () {
  console.log(this.liters);
};

EngineType.prototype.specs = function () {
  console.log(`Engine type is a ${this.liters} liter ${this.engine}`);
};

let eng = new EngineType("2.6");
eng.getLiters(); // -> 2.6
eng.getEngineType(); // -> V6
eng.specs(); // -> Engine type is a 2.6 liter V6
