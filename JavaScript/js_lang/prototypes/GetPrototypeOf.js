// The Object.getPrototypeOf() Method

// Object.getPrototypeOf() returns the prototype of the specified object.

let cpu = Object.create(Object.prototype);

cpu.cores = 3;

cpu.prototype.desc = "CPU or central processing unit carries out instructions of a computer program";
cpu.prototype.getDescription = function() {
    return this.desc;
};

console.log(cpu.getDescription());