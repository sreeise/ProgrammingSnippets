from statistics import *

"""
Find the most frequently occurring character in an array.
"""

def most_frequent(arr):
    counter = 0
    num = arr[0]

    for i in arr:
        curr_frequency = arr.count(i)
        if curr_frequency > counter:
            counter = curr_frequency
            num = i

    return num


def most_frequent2(arr):
    dct = {}
    count, itm = 0, ''
    for item in reversed(arr):
        dct[item] = dct.get(item, 0) + 1
        if dct[item] >= count:
            count, itm = dct[item], item
    return itm


def most_frequent3(List):
    return mode(List)
