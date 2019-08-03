// Write a function to return whether a string is a palindrome.

// The \W searches for a-z, A-Z, 0-9 and underscores.
function isPalindrome(str) {
    str = str.replace(/\W/g, '').toLowerCase();
    return str === str.split('').reverse().join('');
}

// Or a simple approach:
function isPalindromeSimple(s) {
    let s1 = s.split("");
    s1 = s1.reverse();
    return s === s1.join("");
}
