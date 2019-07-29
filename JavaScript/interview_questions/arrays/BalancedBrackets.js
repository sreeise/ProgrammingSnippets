/*
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket
(i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the
exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are
not matched. For example, {[(])} is not balanced because the contents in between
{ and } are not balanced. The pair of square brackets encloses a single, unbalanced
opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing
square bracket, ]

Given n strings of brackets, determine whether each sequence of brackets is balanced.
If a string is balanced, return YES. Otherwise, return NO.
 */

let BracketCodes = {
    bracketLeft: '['.charCodeAt(0),
    bracketRight: ']'.charCodeAt(0),
    braceLeft: '{'.charCodeAt(0),
    braceRight: '}'.charCodeAt(0),
    tupleLeft: '('.charCodeAt(0),
    tupleRight: ')'.charCodeAt(0),

    inverse: function(s) {
        switch (s.charCodeAt(0)) {
            case this.bracketRight: return this.bracketLeft;
            case this.bracketLeft: return this.bracketRight;
            case this.braceLeft: return this.braceRight;
            case this.braceRight: return this.braceLeft;
            case this.tupleLeft: return this.tupleRight;
            case this.tupleRight: return this.tupleLeft;
        }
    },

    isInverse: function(s1, s2) {
        return this.inverse(s1) === s2.charCodeAt(0);
    },

    isLeft: function(s) {
        s = s.charCodeAt(0);
        return s === this.braceLeft
            || s === this.bracketLeft
            || s === this.tupleLeft;
    },

    isRight: function(s) {
        s = s.charCodeAt(0);
        return s === this.braceRight
            || s === this.bracketRight
            || s === this.tupleRight;
    }
};


exports.isBalanced = function isBalanced(s) {
    let array = s.split("");
    let stack = [];

    while (array.length > 0) {
        let next = array.shift();
        if (BracketCodes.isLeft(next)) {
            stack.push(next);
        } else if (BracketCodes.isRight(next)) {
            if (stack.length > 0) {
                let previous = stack.pop();
                if (!BracketCodes.isInverse(previous, next)) {
                    return "NO";
                }
            } else {
                return "NO";
            }
        }
    }

    if (array.length > 0 || stack.length > 0) {
        return "NO";
    }

    return "YES";
}