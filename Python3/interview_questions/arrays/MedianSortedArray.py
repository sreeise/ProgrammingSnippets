
"""
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.
"""


def findMedianSortedArrays(nums1, nums2):
    newNums = nums1 + nums2

    newNums.sort()

    value = len(newNums)

    if (value % 2) == 0:
        num1 = newNums[value // 2 - 1]
        num2 = newNums[value // 2]
        return (num1 + num2) / 2
    else:
        return float(newNums[value // 2])