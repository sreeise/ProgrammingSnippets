// Array Sorting Using A Comparator

// Rules:
//  1. If a number less than 0 is returned, a will come first
//  2. If a number greater than 0 is returned, b will comes first
//  3. If the number returned is equal to 0, the positions of a and b will be left the same.

// Sort an array by descending order:
let arr = [1, 4, 8, 2, 3, 10];

arr.sort(function(a, b) {
    if (a > b) {
        return -1;
    }

    if (b > a) {
        return 1;
    }

    return 0;
});

console.log(arr); // => [ 10, 8, 4, 3, 2, 1 ]