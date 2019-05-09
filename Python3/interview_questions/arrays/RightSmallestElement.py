import bisect
import unittest

# Given an array of integers, return a new array where each element in the
# new array is the number of smaller elements to the right of that element
# in the original input array.


# Time complexity: O(N log N)
# Space complexity: O(N)
def smaller_counts(lst):
    result = []
    seen = []

    for num in reversed(lst):
        # Note on bisect left: bisect.bisect_left(a, x, lo = 0, hi = len(a))
        # bisect_left locates the insertion point for x in a to maintain
        # sorted order.
        i = bisect.bisect_left(seen, num)
        result.append(i)
        bisect.insort(seen, num)

    return list(reversed(result))


# The following function is the algorithm for bisect_left. This is the same algorithm that is in the
# Python standard library at: https://github.com/python/cpython/blob/master/Lib/bisect.py
def bisect_left(a, x, lo=0, hi=None):
    if lo < 0:
        raise ValueError('lo must be non-negative')
    if hi is None:
        hi = len(a)
    while lo < hi:
        mid = (lo + hi) // 2
        if a[mid] < x:
            lo = mid + 1
        else:
            hi = mid
    return lo


class TestWindow(unittest.TestCase):
    def test_window(self):
        array = smaller_counts([3, 4, 9, 6, 1])
        answers = [1, 1, 2, 1, 0]
        for i in range(len(array)):
            self.assertEqual(array[i], answers[i])


if __name__ == "__main__":
    unittest.main()
