import numpy as np

"""
Dot product
The dot product multiplies two vectors and results in a scalar. This is also
why it is called the scalar product.
- The dot product is the sum of the products of the corresponding elements.
- When we have a dot product we always multiply a row vector by a column vector
"""

# Scalar multiplication

s1 = np.array(3)
s2 = np.array(6)

s3 = np.dot(s1, s2)

# Prints 18

print(s3)

"""
Vector multiplication
Vectors must be the same length for multiplication

There are two types of products that can be produced from vector multiplication
1. Dot product also known as inner product (also known as scalar product)
2. Tensor product also known as outer product
"""

v1 = np.array([2, 8, -4])
v2 = np.array([1, -7, 3])

# In numpy you can use the dot method to multiply vectors
# This calculation is: [2 * 1 + 8 * (-7) + (-4) x 3]
s = np.dot(v1, v2)

# This results in the scalar product of [-66]
print(s)


# Multiplying a scalar times a vector results in a vector
# where each number in a vector is multiplied by that scalar

s4 = np.array(4)
v3 = np.array([1, 2, 3])

# Here the operation would be [4 * 1, 4 * 2, 4 * 3] resulting in the vector: [4, 8, 12]
v4 = np.dot(s4, v3)
print(v4)

# The same happens when multiplying a scalar times a matrix

m1 = np.array([[1, 2, 3], [3, 2, 1]])
m2 = np.dot(2, m1)

# This results in the matrix: [[2, 4, 6], [6, 4, 2]]
print(m2)

"""
Multiply Matrix's
 - We can only multiply an m x n matrix with an n x k matrix
 For example, we can multiply a 2 x 3 matrix with a 3 x 1 matrix
 If we wanted to multiply a 5 x 7 matrix, compatible matrix's are any 7 * n matrix
"""

# The first matrix is 2 x 3
m1 = np.array([[5, 12, 6], [-3, 0, 14]])

# The second matrix is 3 x 2
m2 = np.array([[2, -1], [8, 0], [3, 0]])

"""
When multiplying the common property, here 3, will disappear and the
resulting matrix is a 2 x 2

Using the dot product we always multiply a row vector by a column vector and so the above two 
matrix's will be multiplied as follows:

the first row we have is 5, 12, 6 from the first matrix and from the second matrix
we have the column 2, 8, 3 and with this we get:
[5, 12, 6] * [2, 8, 3] = 124
or
5 * 2 + 12 * 8 + 6 * 3 = 124

Still using the first row: [5, 12, 6] Next we take the second column of the second matrix (-1, 0, 0) and do:
[5, 12, 6] * [-1, 0, 0] = -5
or
(5 * -1) + (12 * 0) + (6 * 0) = -5

124 and -5 represent the first row in our 2 x 2 matrix. Next we take the second row
of our first matrix and do the same multiplication:

[-3, 0, 14] * [2, 8, 3] = 36
and
[-3, 0, 14] * [-1, 0, 0] = 3

This results in a matrix equal to [[124, -5], [36, 3]]
"""
m3 = np.dot(m1, m2)
print(m3)



