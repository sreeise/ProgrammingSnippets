"""
A string is said to be a special string if either of two conditions is met:

    All of the characters are the same, e.g. aaa.
    All characters except the middle one are the same, e.g. aadaa.

For example, given the string s = "mnonopoo", we have the following special substrings:
{m, n, o, n, o, p, o, o, non, ono, opo, oo}
"""


def substrCount(s):
    tot = 0
    count_sequence = 0
    prev = ''
    for i, v in enumerate(s):
        count_sequence += 1
        if i and (prev != v):
            j = 1
            while ((i-j) >= 0) and ((i+j) < len(s)) and j <= count_sequence:
                if s[i-j] == prev == s[i+j]:
                    tot += 1
                    j += 1
                else:
                    break
            count_sequence = 1
        tot += count_sequence
        prev = v
    return tot