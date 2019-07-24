from itertools import permutations

# print all possible permutations of size k of the string in lexicographic sorted order.

if __name__ == "__main__":
    inp = input()
    s = inp.split(" ")
    c = sorted(list(permutations(s[0], int(s[1]))))
    for i in c:
        print(''.join(i))
