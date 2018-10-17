/*
Object.defineProperty

MDN docs on Object.defineProperty:
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty
 */

function Computer(brand) {
  this.brand = brand;
}

Computer.prototype = {
  brandType() {
    console.log(this.brand);
  }
};

function Mac(cpu, ram) {
  Computer.call(this, "Mac");
  this.cpu = cpu;
  this.ram = ram;
}

// Extend the prototype of Computer using allowing
// us to call methods and use variables from Computer
// in the Mac object. See prototypes directory.
Mac.prototype = Object.create(Computer.prototype);

// Using define property to create a getter
// This uses the name given: 'specs', as the getter
// method for the String in the get() method
Object.defineProperty(Mac.prototype, "specs", {
  get() {
    return `BRAND: ${this.brand} CPU: ${this.cpu}, RAM: ${this.ram}`;
  }
});

let macbook = new Mac("i7 8700", "16GB");
macbook.brandType(); // --> Mac
console.log(macbook.specs); // --> BRAND: Mac CPU: i7 8700, RAM: 16GB
