# Graphs

The following information is by Robert Sedgewick and Kevin Wayne in Algorithms 4th Edition

### Adjacent Vertices
When there is an edge connecting two vertices, we say that the vertices are adjacent 
to one another and that the edge is incident to both vertices.

The degree of a vertex is the number of edges incident to it.

### Subgraph
A subgraph is a subset of a graph’s edges (and associated vertices) that constitutes a graph.

### Paths and Cycles
A path in a graph is a sequence of vertices connected by edges. A simple path is one 
with no repeated vertices. A cycle is a path with at least one edge whose first and 
last vertices are the same. A simple cycle is a cycle with no repeated edges or vertices 
(except the requisite repetition of the first and last vertices). The length of a path or 
a cycle is its number of edges.
 
We say that one vertex is connected to another if there exists a path that contains both of them.

A graph is connected if there is a path from every vertex to every other vertex in the graph. 
A graph that is not connected consists of a set of connected components, which are maximal 
connected subgraphs.

### Acyclic Graph
An acyclic graph is a graph with no cycles.

A tree is an acyclic connected graph. A disjoint set of trees is called a forest. A spanning tree 
of a connected graph is a subgraph that contains all of that graph’s vertices and is a single tree. 
A spanning forest of a graph is the union of spanning trees of its connected components.

### Density
The density of a graph is the proportion of possible pairs of vertices that are connected by edges. 
