package data_structures.graphs.breadth_first_search;
/*
(Graph overview and code from Cracking the coding interviewing by Gayle Laakmann Mcdowell).
Graphs can either be directed or undirected.

Graphs with edges that are directed means that the edge can only go one way where
as an undirected graph can go both ways, meaning two edges can gan both be pointing
teach each other and another edge.

Graphs can either have cycles or have no cycles.
An acyclic graph is a graph without cycles.

There are two common ways to represent Graphs: Adjacency List and Adjacency Matrix

An adjacency matrix is an NxN boolean matrix (where N is hte number of nodes), where a true value at matrix[i][j]
indicates an edge from the node i to node j. (An integer matrix with 0s and 1s can also be used).
 */

// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2004.%20Trees%20and%20Graphs/Q4_01_Route_Between_Nodes/Graph.java
public class Graph {
  public static int MAX_VERTICES = 6;
  public int count;
  private GraphNode[] vertices;

  public Graph() {
    vertices = new GraphNode[MAX_VERTICES];
    count = 0;
  }

  public void addNode(GraphNode x) {
    if (count < vertices.length) {
      vertices[count] = x;
      count++;
    } else {
      System.out.print("Graph full");
    }
  }

  public GraphNode[] getNodes() {
    return vertices;
  }
}
