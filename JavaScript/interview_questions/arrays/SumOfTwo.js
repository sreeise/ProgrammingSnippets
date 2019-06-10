function sumOfTwo(a, b, v) {
    let comp = new Set();
    for (let i = 0; i < a.length; i++) {
        comp.add(v - a[i]);
    }

    for (let i = 0; i < b.length; i++) {
        if (comp.has(b[i])) {
            return true;
        }
    }

    return false;
}