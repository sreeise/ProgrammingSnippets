// Property Descriptors and Accessors

// Property descriptors present in objects come in two main
// flavors: data descriptors and accessor descriptors.
// A data descriptor is a property that has a value, which may
// or may not be writable. An accessor descriptor is a property
// described by a getter-setter pair of functions. A descriptor
// must be one of these two flavors; it cannot be both.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty


// The writable, enumerable and configurable properties
// Object.defineProperty() defines a new property directly on an object, or modifies an
// existing property on an object, and returns the object.
// See: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty

// Configurable: True if and only if the type of this property descriptor may be changed and if
//               the property may be deleted from the corresponding object. Defaults to false.
//
// Enumerable: True if and only if this property shows up during enumeration of the properties on
//             the corresponding object. Defaults to false.
//
// Writable: True if and only if the value associated with the property may be changed with an
//           assignment operator. Defaults to false.

let Cpu = Object.create(Object.prototype);

// The Cpu object has a description property that is non-configurable and
// not writable but will show up on the enumerable properties of this object.
Object.defineProperty(Cpu, "description", {
    value: "CPU or central processing unit carries out instructions of a computer program",
    writable: false,
    enumerable: true,
    configurable: false,
});

console.log(Cpu.description); // => CPU or central processing unit carries out instructions of a computer program

// The cores property can be changed but it cannot be removed from the Cpu object.
// The cores property will default to undefined.
Object.defineProperty(Cpu, "cores", {
    enumerable: true,
    configurable: false,
    get() {
        return this.value;
    },
    set(value) {
        this.value = value;
    }
});

console.log(Cpu.cores); // => undefined

// Create a Cpu object based upon Cpu:
let AmdCpu = Object.create(Cpu);

console.log(AmdCpu.description); // => CPU or central processing unit carries out instructions of a computer program

console.log(AmdCpu.cores); // => undefined

AmdCpu.cores = 4;

console.log(AmdCpu.cores); // => 4


// You can get the writable, configurable, and enumerable values of a property for an object
// by calling Object.getOwnPropertyDescriptor() which returns a property descriptor for an
// own property (that is, one directly present on an object and not in the object's prototype
// chain) of a given object. In the case of the AmdCpu object we would not be able to get the
// cores property.
Object.defineProperty(AmdCpu, "company", {
    writable: false,
    configurable: false,
    enumerable: true,
    value: "Amd",
});

const descriptor = Object.getOwnPropertyDescriptor(AmdCpu, "company");

console.log(descriptor.writable); // => false
console.log(descriptor.configurable); // => false
console.log(descriptor.enumerable); // => true


// You can also prevent inherited properties:
// This creates an object as non enumerable, non configurable, not writable as defaults.
let obj = Object.create(null);


// If you want to prevent Object.defineProperty from throwing an error you can use
// Reflect.defineProperty which returns boolean. If the property is created true
// will be returned and if not false.
if (Reflect.defineProperty(Cpu, "description", {
    writable: true,
    configurable: true,
    enumerable: true,
})) {
    // The property was created. We won't get here since the original
    // configurable and writable are both false.
    console.log("The property was defined");
} else {
    console.log("Could not define property");
}