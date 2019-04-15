# Order of Growth

Source: Algorithms 4th Edition by Robert Sedgewick and Kevin Wayne

### Constant

    A program whose running time’s order of growth is constant executes a fixed
    number of operations to finish its job; consequently its running time does not depend on N. 
    Most Java operations take constant time.
    
### Logarithmic

    A program whose running time’s order of growth is logarithmic is barely slower than 
    a constant-time program. The classic example of a program whose running time is logarithmic 
    in the problem size is binary search. The base of the logarithm  is not relevant with respect 
    to the order of growth (since all logarithms with a constant base are related by a 
    constant factor), so we use log N when referring to order of growth.

### Linear

    Programs that spend a constant amount of time processing each piece of input data, or that are 
    based on a single for loop, are quite common. The order of growth of such a program is said to 
    be linear—its running time is proportional to N.
   
   
### Linearithmic

    We use the term linearithmic to describe programs whose running time for a problem 
    of size N has order of growth N log N. Again, the base of the logarithm is not relevant 
    with respect to the order of growth. The prototypical examples of linearithmic algorithms
    merge sort and quick sort.

### Quadratic

    A typical program whose running time has order of growth N2 has two nested for loops, 
    used for some calculation involving all pairs of N elements. The elmentary sorting 
    algorithms selection sort and insertion sort are in this classification.

### Cubic

    A typical program whose running time has order of growth N3 has three nested for loops, 
    used for some calculation involving all triples of N elements. An example is the three sum
    algorithm.

### Exponential

    Generally, we use the term exponential to refer to algorithms whose order of growth is bN 
    for any constant b > 1, even though different values of b lead to vastly different running 
    times. Exponential algorithms are extremely slow—you will never run one of them to completion 
    for a large problem. Still, exponential algorithms play a critical role in the theory of 
    algorithms because there exists a large class of problems for which it seems that an exponential 
    algorithm is the best possible choice.
