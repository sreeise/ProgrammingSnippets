import unittest

# Given an array of numbers, find the maximum sum of any contiguous subarray of
# the array. [34, -50, 42, 14, -5, 86] => 137
# Additionally, find any the maximum sum of any contiguous subarray of the array
# if the subarray is allowed to wrap around. [8, -1, 3, 4] => 15 because
# we take 3, 4, and 8.


def max_subarray_sum(arr):
    max_ending_here = max_so_far = 0

    for x in arr:
        max_ending_here = max(x, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far


def min_subarray_sum(arr):
    min_ending_here = min_so_far = 0

    for x in arr:
        min_ending_here = min(x, min_ending_here + x)
        min_so_far = min(min_so_far, min_ending_here)
    return min_so_far


def maxi_circular_subarray(arr):
    max_wrap_around = sum(arr) - min_subarray_sum(arr)
    return max(max_subarray_sum(arr), max_wrap_around)


class TestWindow(unittest.TestCase):
    def test_window(self):
        sum_num = max_subarray_sum([34, -50, 42, 14, -5, 86])
        self.assertEqual(137, sum_num)
        sum_circular = maxi_circular_subarray([8, -1, 3, 4])
        self.assertEqual(sum_circular, 15)


if __name__ == "__main__":
    unittest.main()