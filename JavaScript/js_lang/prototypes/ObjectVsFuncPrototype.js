// Object Prototypes and Function Prototypes.

// See also: FunctionConstructorVsPrototype.js for why it is better to
// define common methods on the prototype of an object rather then within
// the function constructor of an object.

// An objects prototype, Object.prototype, is different from that of a functions
// prototype, func.prototype. The function prototype specifics a prototype that
// is assigned to all instances of objects created by the given function when
// used as a constructor.

// Function constructor prototype

let f = function() {
    this.a = 1;
    this.b = 2;
};

f.prototype.b = 3;
f.prototype.c = 4;

let o = new f();

// Notice how the variable b is set to 1 in the function while also at the
// same time f.prototype.b is set to 4. These are two different properties
// and accessing them is done in two different ways from the object o.
// However, you can still access f.prototype.c by calling o.c because
// the property being accessed on an object follows a prototype chain.

// For instance, The object, o, prototype chain is:
// {a: 1, b: 2} -> {b: 3, c: 4} -> Object.prototype -> null.
// When we try to access o.c, JavaScript will first look for the property on
// the first object above with the properties a and b. Since the property
// c is not on this object, JavaScript will move to the next object in
// the prototype chain where we have the property names b and c. The object
// does in fact have the property c and this is what is returned.
//
// If a functions constructor has a property that is the same name as one on
// the prototype you can use the syntax, constructor.prototype, to access
// the property further down the prototype chain as shown below.

console.log(o.a); // => 1
console.log(o.b); // => 2

console.log(o.constructor.prototype.b); // => 3
console.log(o.c); // => 4