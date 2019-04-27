import unittest

#   Given an array of integers that are out of order, determine the bound of the smallest
#   window that must be sorted in order for the entire array to be sorted.


def window(array):
    left = None
    right = None
    length = len(array)
    # float(inf) represents infinity or
    # negative infinity for a negative.
    max_seen = -float("inf")
    min_seen = float("inf")

    for i in range(length):
        # Get the max value seen so far.
        max_seen = max(max_seen, array[i])
        if array[i] < max_seen:
            right = i

    # Loop the array in reverse by 1.
    for i in range(length - 1, -1, -1):
        # Get the min value seen so far.
        min_seen = min(min_seen, array[i])
        if array[i] > min_seen:
            left = i

    return left, right


class TestWindow(unittest.TestCase):
    def test_window(self):
        array = window([3, 4, 7, 5, 6, 9])
        self.assertEqual(array[0], 2)
        self.assertEqual(array[1], 4)

    def test_window2(self):
        array = window([4, 1, 8, 9, 10])
        self.assertEqual(array[0], 0)
        self.assertEqual(array[1], 1)


if __name__ == "__main__":
    unittest.main()
