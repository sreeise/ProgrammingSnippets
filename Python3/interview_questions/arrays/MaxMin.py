import unittest

"""
  You will be given a list of integers, arr, and a single integer k.
  You must create an array of length from elements of such that its unfairness is minimized.
  Call that array subarr. Unfairness of an array is calculated as:

    max(subarr) - min(subarr)

  Where:
    - max denotes the largest integer in subarr.
    - min denotes the smallest integer in subarr.
"""


def max_min(k, arr):
    arr = sorted(arr)
    minimum = float("inf")
    for index in range(len(arr) - k + 1):
        diff = arr[index + k - 1] - arr[index]
        if diff < minimum:
            minimum = diff
    return minimum


class TestWindow(unittest.TestCase):
    def test_max_min(self):
        num = max_min(4, [1, 2, 3, 4, 10, 20, 40, 100, 200])
        self.assertEqual(num, 3)
        num = max_min(3, [10, 100, 300, 200, 1000, 20, 30])
        self.assertEqual(num, 20)


if __name__ == "__main__":
    unittest.main()
