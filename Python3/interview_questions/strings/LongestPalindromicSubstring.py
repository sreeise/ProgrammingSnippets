"""
Given a string s, find the longest palindromic substring in s. You may assume that
the maximum length of s is 1000.
"""


def longestPalindrome(s):
    if not s:
        return s

    res = ""
    for i in range(len(s)):
        j = i + 1
        while j <= len(s) and len(res) <= len(s[i:]):
            if s[i:j] == s[i:j][::-1] and len(s[i:j]) > len(res):
                res = s[i:j]
            j += 1
    return res


if __name__ == "__main__":
    print(longestPalindrome("babad"))
