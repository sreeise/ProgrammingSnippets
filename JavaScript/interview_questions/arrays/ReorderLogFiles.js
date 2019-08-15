/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.

We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each
log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered
lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should
be put in their original order.

Return the final order of the logs.
 */

// Note: It would probably be faster to account for the number logs
// within the sort comparator if you can get it to work.
let reorderLogFiles = function (logs) {
    // Put the logs that have numbers after the identifier
    // in another array in their original order and remove
    // them from logs.
    let numLogs = [];
    for (let i = 0; i < logs.length; i++) {
        let arr = logs[i].split(" ");
        if (Number.isInteger(parseInt(arr[1]))) {
            numLogs.push(logs[i]);
            logs.splice(i, 1);
            i--;
        }
    }

    // Use a comparator to sort the remaining strings which
    // are all of the logs that have words after the identifier.
    logs.sort((a, b) => {
        let s1 = a.split(" ");
        let s2 = b.split(" ");

        let key1 = s1.shift();
        let key2 = s2.shift();

        let arr1 = s1.join(" ");
        let arr2 = s2.join(" ");
        if (Object.is(arr1, arr2)) {
            // If the strings, excluding the key, are equal
            // then compare the keys.
            let arr = [key1, key2];
            arr.sort();
            return arr[0] === s1[0] ? -1 : 1;
        } else {
            // If the strings are not equal, excluding the keys,
            // the compare the strings without the keys.
            let arr = [arr1, arr2];
            arr.sort();
            return arr[0] === arr1 ? -1 : 1;
        }
    });

    return logs.concat(numLogs);
};


// The second solution uses a map to store values with the same keys:

let reorderLogFilesMap = function (logs) {
    let values = [];
    let map = new Map();

    for (let i = 0; i < logs.length; i++) {
        let s = logs[i];
        let arr = s.split(" ");

        if (!Number.isInteger(parseInt(arr[1]))) {
            logs.splice(i, 1);

            let key = arr.shift();
            let value = arr.join(" ");

            if (map.has(value)) {
                let array = map.get(value);
                array.push(key);
                map.set(value, array);
            } else {
                map.set(value, [key]);
            }

            values.push(arr.join(" "));
            i--;
        }
    }

    values.sort();
    for (let i = 0; i < values.length; i++) {
        let val = values[i];
        let keys = map.get(val);
        keys.sort();

        if (keys.length > 1) {
            values[i] = keys[0] + " " + val;
            keys.shift();
            map.set(val, keys);
        } else {
            values[i] = keys[0] + " " + val;
        }
    }

    return values.concat(logs);
};

module.exports.reorderLogFiles = reorderLogFiles;
module.exports.reorderLogFilesMap = reorderLogFilesMap;