/*
Given a string s consisting of small English letters,
find and return the first instance of a non-repeating character in it.
If there is no such character, return '_'.
 */

function firstNotRepeatingCharacter(s) {
    let array = s.split("").reverse();
    let arr = [];
    while (array.length > 0) {
        let next = array.pop();
        if (!array.includes(next) && !arr.includes(next)) {
            return next;
        } else {
            arr.push(next);
        }
    }

    return '_';
}
