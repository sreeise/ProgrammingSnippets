/*
Given an array nums and a value val, remove all instances of that value in-place
and return the new length. Do not allocate extra space for another array, you must
do this by modifying the input array in-place with O(1) extra memory.
 */

// The key here is to modify only the given array:
let removeElement = function(nums, val) {
    for (let i = 0; i < nums.length; i++) {
        if (val === nums[i]) {
            if (nums[i] === val) {
                nums.splice(i, 1);
                i--;
            }
        }
    }

    return nums.length;
};