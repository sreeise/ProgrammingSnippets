def find_unique(arr):
    result_arr = [0] * 32
    for num in arr:
        for i in range(32):
            bit = num >> i & 1
            result_arr[i] += bit

    result = 0
    for i, bit in enumerate(result_arr):
        if bit % 3 != 0:
            result += 2 ** i
    return result


if __name__ == "__main__":
    print(find_unique([6, 1, 3, 3, 3, 6, 6]))