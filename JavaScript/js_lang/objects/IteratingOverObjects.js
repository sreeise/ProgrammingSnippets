// Iterating Over Objects

// Iterating over an object enumerable properties using the for..in syntax. Don't confuse
// for..of with for..in. The for..of loop is for looping over iterables while the for..in
// loop is for iterating over the enumerable properties of an object. Objects are not
// iterable in JavaScript, so they cannot be iterated over using for..of unless an iterator
// is created for that object using the Symbol keyword shown below.

let Person = {
    firstName: "John",
    lastName: "Doe",
};

for (let value in Person) {
    console.log(value + ": " + Person[value]);
    // => firstName: John
    // => lastName: Doe
}

// The for..in syntax will iterate over all enumerable properties of
// both the object itself and its prototype. The built-in function,
// getOwnPropertyNames can be used to get only those properties
// that are on the object itself.
let propertyNames = Object.getOwnPropertyNames(Person);
for (let i = 0; i < propertyNames.length; i++) {
    console.log(propertyNames[i] + ": " + Person[propertyNames[i]]);
    // => firstName: John
    // => lastName: Doe
}


// You can also use hasOwnProperty to check for only properties defined
// on the object. Since the object Person is defined on the prototype
// of JohnDoe the firstName and lastName values will not be printed.
function JohnDoe() {
    this.age = 21;
}

JohnDoe.prototype.name = Person;

let johnDoe = new JohnDoe();

for (const property in johnDoe) {
    if (johnDoe.hasOwnProperty(property)) {
        console.log(`${property}: ${johnDoe[property]}`);
        // => 21
    }
}


// You can create an iterable object using JavaScripts built-in Symbol keyword.
const PersonIter = {
  [Symbol.iterator]() {
      let counter = 0;
      return {
          next() {
              counter++;

              switch (counter) {
                  case 1:
                      return { firstName: "John", lastName: "Doe" };
                  case 2:
                      return { firstName: "Jane", lastName: "Doe" };
              }

              return { firstName: "Unknown", lastName: "Unknown" };
          }
      }
  }
};

let iter = PersonIter[Symbol.iterator]();

console.log(iter.next()); // => { firstName: 'John', lastName: 'Doe' }
console.log(iter.next()); // => { firstName: 'Jane', lastName: 'Doe' }
console.log(iter.next()); // => { firstName: 'Unknown', lastName: 'Unknown' }

// Continuing to call the iterator this will return the the Unknown person.
console.log(iter.next()); // => { firstName: 'Unknown', lastName: 'Unknown' }