
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

// Using define property to create a getter
Object.defineProperty(Mac.prototype, "specs", {
  get() {
    return `CPU: ${this.cpu}, RAM: ${this.ram}`;
  }
});

let macbook = new Mac("i7 8700", "16GB");
console.log(macbook.specs);
