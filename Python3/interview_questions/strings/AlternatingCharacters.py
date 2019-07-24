"""
  You are given a string containing characters A and B only. Your task is to change it into a
  string such that there are no matching adjacent characters. To do this, you are allowed to
  delete zero or more characters in the string.

  Your task is to find the minimum number of required deletions.

  For example, given the string s = AABAAB, remove an A at positions 0 and 3 to make
  s = ABAB in 2 deletions.
"""
def alternatingCharacters(s):
    c = character_arr(s)
    count = 0
    for i in range(len(c)):
        temp = 0
        if i != 0 and c[i] == c[i - 1] and c[i] != -1 and c[i - 1] != -1:
            temp += 1
        count += temp
    return count


def character_arr(a):
    c = [-1] * len(a)
    for i in range(len(a)):
        c[i] = ord(a[i])
    return c


if __name__ == "__main__":
    print(alternatingCharacters("BAABAAABAAABBBAABAAAAABABAAAABABBAABBBABBAAAABABBABAAAAABBABAABBBBAAAABBAABABAAAABABABBBABAAABBBBBBB"))
