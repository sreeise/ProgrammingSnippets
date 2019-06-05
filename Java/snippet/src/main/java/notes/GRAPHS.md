# Graphs

### Using an Adjacency List vs a Adjacency Matrix

An adjacency list is list of edges between nodes in a graph and takes
O(N) time to check if an edge exists.

An adjacency matrix is typically implemented using a two-dimensional
array that have nodes on each dimension forming a matrix. A matrix
with n nodes takes n^2 units of memory. An adjacency matrix has
the advantage of doing lookups for existing edges in O(1) time.

Use a matrix when you have fewer nodes with dense connections
and a list when you have many nodes with sparse connections.
