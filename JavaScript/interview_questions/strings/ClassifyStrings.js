function classifyStrings(s) {
    if(s.match(/[aeiou]{3}/)) {
        return 'bad';
    }
    if(s.match(/[^aeiou?]{5}/)) {
        return 'bad';
    }

    if(s.match(/\?/)){
        let a = classifyStrings(s.replace(/\?/, 'a'));
        let b = classifyStrings(s.replace(/\?/, 'b'));

        if(a === b) {
            return a;
        }
        return 'mixed'
    }

    return 'good'
}
