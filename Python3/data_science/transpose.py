import numpy as np


# One dimensional arrays do not really get transposed.
# Transposing a one dimensional array will yield the same array

# Transposing a matrix converts the rows data to columns and
# the columns data to rows

m1 = np.array([[1, 2, 3], [4, 5, 6]])

# The T method is used to transpose a numpy array.

print(m1.T)

# this converts the m1 matrix to:
# [
#     [1, 4],
#     [2, 5],
#     [3, 6]
# ]

# We can transpose the same matrix back to its original form by
# calling the T method again:
print(m1.T)
