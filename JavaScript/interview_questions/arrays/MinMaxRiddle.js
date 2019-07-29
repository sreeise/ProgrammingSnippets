/*
Given an integer array of size n, find the maximum of the minimum(s) of every window
size in the array. The window size varies from 1 to n.
 */

function riddle(arr) {
    let n = arr.length;
    const s = []; // Used to find previous and next smaller

    // Arrays to store previous and next smaller
    const left = [];
    const right = [];

    // Initialize elements of left[] and right[]
    for (let i = 0; i < n; i++) {
        left[i] = -1;
        right[i] = n;
    }

    // Fill elements of left[] (closer lower value on the left of i)
    for (let i = 0; i < n; i++) {
        while (s.length && arr[s[s.length - 1]] >= arr[i]) {
            s.pop()
        }

        if (s.length) {
            left[i] = s[s.length - 1]
        }

        s.push(i)
    }

    // Empty the stack as stack is going to be used for right[]
    while (s.length) {
        s.pop()
    }

    // Fill elements of right[] (closer lower value on the right of i)
    for (let i = n - 1; i >= 0; i--) {
        while (s.length && arr[s[s.length - 1]] >= arr[i]) {
            s.pop()
        }

        if (s.length) {
            right[i] = s[s.length - 1]
        }

        s.push(i)
    }

    // Create and initialize answer array
    const ans = [];
    for (let i = 0; i <= n; i++) {
        ans[i] = 0
    }

    // Fill answer array by comparing minimums of all
    // lengths computed using left[] and right[]
    for (let i = 0; i < n; i++) {
        // length of the interval
        const len = right[i] - left[i] - 1;

        // arr[i] is a possible answer for this length
        // 'len' interval, check if arr[i] is more than
        // max for 'len'
        ans[len] = Math.max(ans[len], arr[i]);
    }

    // Some entries in ans[] may not be filled yet. Fill
    // them by taking values from right side of ans[]
    for (let i = n - 1; i >= 1; i--) {
        ans[i] = Math.max(ans[i], ans[i + 1])
    }

    ans.shift(); // The first 0 is useless

    return ans
}