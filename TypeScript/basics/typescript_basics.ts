// Types
const str: string = "A String";
const num: number = 1;
let bool: boolean = true;

// Array
let array1: string[] = ["string", "array"];
// Generic array
let array2: Array<String> = ["string", "array"];

// Tuple: Fixed Element array
let tup: [string, boolean];
tup = ["is True?", true];

// Undefined and null
let undef: undefined = undefined;
let _null: null = null;

// Functions

// Must return a string
function strGetter(str: string) {
    return str;
}

// Void functions - don't return values
function doSomething(): void {
    console.log("did something");
}
