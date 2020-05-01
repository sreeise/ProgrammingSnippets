# numpy is a data science library for python
import numpy as np


# This goes over the basics needed for Tensorflow

# A scalar is a 1x1 array

s1 = np.array(3)

# A vector is a tuple of one ore more values called scalars

v1 = np.array([1, 3, 4])

# A matrix is a collection of numbers ordered in rows and columns
# A matrix can be created using numpy as follows:

m1 = np.array([[1, 2, 3], [4, 5, 6]])

# You can get the shape of a scalar, vector, or matrix by calling shape method:

print(m1.shape)
