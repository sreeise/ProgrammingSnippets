import unittest

#   Given an array of integers, return a new array such that each element at
#   index i of the new array is the product of all the numbers in the original
#   array except the one at i.


def main():
    array = [1, 2, 3, 4, 5]
    print(products(array))
    # [120, 60, 40, 30, 24]


def products(nums):
    prefix_products = []
    for num in nums:
        if prefix_products:
            prefix_products.append(prefix_products[-1] * num)
        else:
            prefix_products.append(num)

    suffix_products = []
    for num in reversed(nums):
        if len(suffix_products) > 0:
            suffix_products.append(suffix_products[-1] * num)
        else:
            suffix_products.append(num)
    suffix_products = list(reversed(suffix_products))

    result = []
    for i in range(len(nums)):
        if i == 0:
            result.append(suffix_products[i + 1])
        elif i == len(nums) - 1:
            result.append(prefix_products[i - 1])
        else:
            result.append(prefix_products[i - 1] * suffix_products[i + 1])
    return result


class TestWindow(unittest.TestCase):
    def test_window(self):
        array = products([1, 2, 3, 4, 5])
        answers = [120, 60, 40, 30, 24]
        for i in range(len(array)):
            self.assertEqual(array[i], answers[i])


if __name__ == "__main__":
    unittest.main()

