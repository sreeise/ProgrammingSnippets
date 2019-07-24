def value(letter, power):
    return (26 ** power) * (ord(letter) - 96)


def rabin_hash(prev, start, new, k):
    return (prev - value(start, k - 1)) * 26 + value(new, 0)


def find_matches(pattern, string):
    matches = []
    k = len(pattern)

    pattern_val = 0
    for i, char in enumerate(string[:k]):
        pattern_val += value(char, k - i - 1)

    hash_val = 0
    for i, char in enumerate(string[:k]):
        hash_val += value(char, k - i - 1)

    if pattern_val == hash_val:
        if string[:k] == pattern:
            matches.append(0)

    for i in range(len(string) - k):
        hash_val = rabin_hash(hash_val, string[i], string[i - k], k)
        if pattern_val == hash_val:
            if string[i + 1 : i + k + 1] == pattern:
                matches.append(i + 1)

    return matches


if __name__ == "__main__":
    print(find_matches("a", "aabcca"))