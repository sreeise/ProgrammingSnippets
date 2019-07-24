from collections import deque

"""
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
"""


# Time Complexity: 0(N)
def max_k_length_subarray(lst, k):
    arr = []
    q = deque()
    for i in range(k):
        while q and lst[i] >= lst[q[-1]]:
            q.pop()
        q.append(i)

    for i in range(k, len(lst)):
        arr.append(lst[q[0]])
        while q and q[0] <= i - k:
            q.popleft()
        while q and lst[i] >= lst[q[-1]]:
            q.pop()
        q.append(i)
    arr.append(lst[q[0]])
    return arr


# Time Complexity: 0(N * K)
def max_k_length_subarray2(arr, k):
    nums = []
    n = len(arr)
    for i in range(n - k + 1):
        max_num = arr[i]
        for j in range(1, k):
            if arr[i + j] > max_num:
                max_num = arr[i + j]
        nums.append(max_num)
    return nums


if __name__ == "__main__":
    print(max_k_length_subarray([8, 5, 10, 7, 9, 4, 15, 12, 90, 13], 4))
    print(max_k_length_subarray2([8, 5, 10, 7, 9, 4, 15, 12, 90, 13], 4))