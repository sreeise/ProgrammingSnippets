/*
Given a 6 * 6 2D array, arr we define in A to be a subset of values with indices falling
in this pattern in arr's graphical representation:

    a b c
      d
    e f g

There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values.
Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.

Constraints:
    -9 <= arr[i][j] <= 9
 */

function hourglassSum(arr) {
    // We can get our minimum possible value by taking
    // the length of each hour glass, which is 7, times
    // the least possible value: -9 * 7 = -63
    let sum = -63;

    // For each loop, get the next three values for the top
    // of the hour glass, the mid value for the hour glass,
    // and the bottom three values for the hour glass.
    // Sum the hour glass and check if it is the largest
    // sum seen so far.
    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            // Get the next 3 values.
            let temp = arr[i].slice(j, j + 3);
            let top = temp.reduce((x, y) => x + y);

            // Get the mid value.
            let mid= arr[i + 1][j + 1];

            // Get the bottom three values.
            temp = arr[i + 2].slice(j, j + 3);
            let bottom = temp.reduce((x, y) => x + y);

            let hourglass = top + mid + bottom;

            if (hourglass > sum) {
                sum = hourglass;
            }
        }
    }

    return sum;
}