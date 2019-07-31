// Function Constructors vs Prototypes

/*
You can use prototypes to extend objects with methods and values.
You can also use function constructors to add methods and values
to objects as well. However, the constructor function notation
is memory inefficient for declaring methods compared to using prototypes.

This is because a constructor function methods will create these methods
for each new object from that function. A prototype, on the other hand,
will create the methods only once for all instances of an object.

Consider a constructor function object that is used to create several
hundreds of instances of that object. For every single object you
would be creating the methods defined on that object over again
which could easily slow down execution time and browser speed.
 */

// Consider the function object below:
function Counter() {
    this.count = 0;

    this.increment = function() {
        this.count += 1;
    }
}

// When creating two objects of Counter, we also have to create
// the increment function for each. If we needed to define many
// Counter objects, the memory consumption would be drastically
// increased and would slow down client execution.

let counter1 = new Counter(); // Creates a new increment method.
let counter2 = new Counter(); // Also Creates a new increment method.


// Instead, it is better to add the increment method to the prototype
// of an object which would create that function only once for all
// new instances of that object.  Each object will have its own this.count
// variable but the increment function, which doesn't change, will be defined
// only once and will be the same across all instances.

function Counter2() {
    this.count = 0;
}

Counter2.prototype.increment = function() {
    this.count += 1;
};

let count1 = new Counter2(); // Uses the same increment function already defined.
let count2 = new Counter2(); // Uses the same increment function already defined.



