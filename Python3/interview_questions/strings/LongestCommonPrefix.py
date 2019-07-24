"""
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string ""
"""


# The purpose of zip() is to map the similar index of multiple containers so that they
# can be used just using as single entity.
def longestCommonPrefix(strs):
    prefix = []
    for x in zip(*strs):
        if len(set(x)) == 1:
            prefix.append(x[0])
        else:
            break
    return "".join(prefix)


if __name__ == "__main__":
    print(longestCommonPrefix(["flower", "flow", "flight"]))
