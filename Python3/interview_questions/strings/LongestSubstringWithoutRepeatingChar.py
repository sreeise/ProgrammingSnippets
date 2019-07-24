def lengthOfLongestSubstring(s):
    map = {}
    max_so_far = curr_max = start = 0
    for index, i in enumerate(s):
        if i in map and map[i] >= start:
            max_so_far = max(max_so_far, curr_max)
            curr_max = index - map[i]
            start = map[i] + 1
        else:
            curr_max += 1
        map[i] = index
    return max(max_so_far, curr_max)


if __name__ == "__main__":
    print(lengthOfLongestSubstring("abcabcbb"))