# Binary search algorithm. Requires that the array is sorted
def binary_search(target, nums):
    floor_index = -1
    ceiling_index = len(nums)

    while floor_index + 1 < ceiling_index:
        distance = ceiling_index - floor_index
        half_distance = distance / 2
        guess_index = floor_index + half_distance
        guess_value = nums[guess_index]

        if guess_value == target:
            return guess_index
        if guess_value > target:
            ceiling_index = guess_index
        else:
            floor_index = guess_index

    return -1
