import bisect

"""
Common use of the array bisection algorithm
For python 2 See https://docs.python.org/2/library/bisect.html
For python 3 see https://docs.python.org/3/library/bisect.html
The algorithms for bisect from the Python standard library are also
show below. See https://github.com/python/cpython/blob/master/Lib/bisect.py
"""

# The next five functions show common use for bisect in searching
# through sorted lists.


def index(a, x):
    # Locate the leftmost value exactly equal to x
    i = bisect.bisect_left(a, x)
    if i != len(a) and a[i] == x:
        return i
    raise ValueError


def find_lt(a, x):
    # Find rightmost value less than x
    i = bisect.bisect_left(a, x)
    if i:
        return a[i-1]
    raise ValueError


def find_le(a, x):
    # Find rightmost value less than or equal to x
    i = bisect.bisect_right(a, x)
    if i:
        return a[i-1]
    raise ValueError


def find_gt(a, x):
    # 'Find leftmost value greater than x'
    i = bisect.bisect_right(a, x)
    if i != len(a):
        return a[i]
    raise ValueError


def find_ge(a, x):
    # Find leftmost item greater than or equal to x
    i = bisect.bisect_left(a, x)
    if i != len(a):
        return a[i]
    raise ValueError


"""
Bisect algorithms in the Python standard library.
See https://github.com/python/cpython/blob/master/Lib/bisect.py
"""


def insort_right(a, x, lo=0, hi=None):
    """Insert item x in list a, and keep it sorted assuming a is sorted.
    If x is already in a, insert it to the right of the rightmost x.
    Optional args lo (default 0) and hi (default len(a)) bound the
    slice of a to be searched.
    """

    lo = bisect_right(a, x, lo, hi)
    a.insert(lo, x)


def bisect_right(a, x, lo=0, hi=None):
    """Return the index where to insert item x in list a, assuming a is sorted.
    The return value i is such that all e in a[:i] have e <= x, and all e in
    a[i:] have e > x.  So if x already appears in the list, a.insert(x) will
    insert just after the rightmost x already there.
    Optional args lo (default 0) and hi (default len(a)) bound the
    slice of a to be searched.
    """

    if lo < 0:
        raise ValueError('lo must be non-negative')
    if hi is None:
        hi = len(a)
    while lo < hi:
        mid = (lo+hi)//2
        if x < a[mid]: hi = mid
        else: lo = mid+1
    return lo


def insort_left(a, x, lo=0, hi=None):
    """Insert item x in list a, and keep it sorted assuming a is sorted.
    If x is already in a, insert it to the left of the leftmost x.
    Optional args lo (default 0) and hi (default len(a)) bound the
    slice of a to be searched.
    """

    lo = bisect_left(a, x, lo, hi)
    a.insert(lo, x)


def bisect_left(a, x, lo=0, hi=None):
    """Return the index where to insert item x in list a, assuming a is sorted.
    The return value i is such that all e in a[:i] have e < x, and all e in
    a[i:] have e >= x.  So if x already appears in the list, a.insert(x) will
    insert just before the leftmost x already there.
    Optional args lo (default 0) and hi (default len(a)) bound the
    slice of a to be searched.
    """

    if lo < 0:
        raise ValueError('lo must be non-negative')
    if hi is None:
        hi = len(a)
    while lo < hi:
        mid = (lo+hi)//2
        if a[mid] < x:
            lo = mid+1
        else:
            hi = mid
    return lo
