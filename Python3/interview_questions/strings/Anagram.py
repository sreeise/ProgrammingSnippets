
"""
  Given two strings a, and b,that may or may not be of the same length, determine the minimum number of
  character deletions required to make and anagrams. Any characters can be deleted from either of the strings.
"""

def make_anagram(a, b):
    return get_delta(char_count(a), char_count(b))


def char_count(a):
    b = [0] * 26
    for i in range(len(a)):
        b[ord(a[i]) - ord('a')] += 1
    return b


def get_delta(a, b):
    if len(a) != len(b):
        return -1
    count = 0
    for i in range(len(a)):
        diff = abs(a[i] - b[i])
        count += diff
    return count


if __name__ == "__main__":
    print(make_anagram("abcaddc", "abcd"))