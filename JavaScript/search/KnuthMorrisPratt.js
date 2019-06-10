function pattern(s) {
    const p = [0];
    let prefix = 0;
    let suffix = 1;

    while (suffix < s.length) {
        if (s[prefix] === s[suffix]) {
            p[suffix] = prefix + 1;
            suffix += 1;
            prefix += 1;
        } else if (prefix === 0) {
            p[suffix] = 0;
            suffix += 1;
        } else {
            prefix = p[prefix - 1];
        }
    }

    return p;
}


function find(s, x) {
    if (x.length === 0) {
        return 0;
    }

    let idx1 = 0;
    let idx2 = 0;

    const p = pattern(x);

    while (idx1 < s.length) {
        if (s[idx1] === x[idx2]) {
            if (idx2 === x.length - 1) {
                return (idx1 - x.length) + 1;
            }
            idx2 += 1;
            idx1 += 1;
        } else if (idx2 > 0) {
            idx2 = p[idx2 - 1];
        } else {
            idx2 = 0;
            idx1 += 1;
        }
    }

    return -1;
}
