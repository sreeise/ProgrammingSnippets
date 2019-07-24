import re
from itertools import product
from itertools import combinations
from itertools import combinations_with_replacement
from itertools import groupby


# A group() expression returns one or more subgroups of the match
def match_digits(s):
    a = re.search(r'([A-Za-z0-9])\1+', s)
    if a:
        print(a.group(1))
    else:
        print(-1)


def cartesian_product(a, a1):
    a = a.split(" ")
    a1 = a1.split(" ")
    a = [a, a1]
    l = [[int(j) for j in i] for i in a]
    b = sorted(product(*l))
    for i in b:
        print(i, end=" ")


def sorted_combinations_up_to_k(s, num):
    for i in range(num + 1):
        s1 = list(sorted(combinations(s, i)))
        lst2 = []
        for j in s1:
            lst2.append(sorted(''.join(j)))
        lst2 = sorted(lst2)
        for j in lst2:
            if j:
                print(''.join(j))


def replacement_combinations_up_to_k(s, num):
    a = list(combinations_with_replacement(s, num))
    lst = []
    for i in a:
        lst.append(''.join(sorted(i)))
    lst = sorted(lst)
    for i in lst:
        print(i)


def group_by_count(s):
    for i, j in groupby(map(int, list(s))):
        print(tuple([len(list(j)), i]), end=" ")
