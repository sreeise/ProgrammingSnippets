// Object Scope and Call Contexts


// The following call to getName using getNameFunc returns undefined because
// the function is extracted from the Person object. When this happens
// JavaScript tries looking for the _firstName variable on the global
// scope which it does not have and so the call is returned as undefined.
var Person = {
    _firstName: "John",
    getName: function() {
        return this._firstName;
    }
};

var getNameFunc = Person.getName;

console.log(getNameFunc()); // => Undefined

console.log(Person.getName()); // => John


// To fix the issue above the bind method can be used:

var getNameFunc2 = Person.getName.bind(Person);

console.log(getNameFunc2()); // => John