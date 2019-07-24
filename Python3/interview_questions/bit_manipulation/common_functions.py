import math


# Bit count
def bit_count(int_type):
    count = 0
    while int_type:
        int_type &= int_type - 1
        count += 1
    return count


def count_freq(s, t):
    return s.count(t)


def min_and_max():
    print(-float("inf"))
    print(float("inf"))


# gives result accurate to 11 places
def accurate_result_places():
    print(math.exp(1e-5) - 1)
