package data_structures.graphs.graph.depth_first_search;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
  // No. of vertices
  private int vertices;

  // Array  of lists for Adjacency List Representation
  private LinkedList[] adjacent;

  public Graph(int vertices) {
    this.vertices = vertices;
    adjacent = new LinkedList[vertices];
    for (int i = 0; i < vertices; ++i) {
      adjacent[i] = new LinkedList();
    }
  }

  //Function to add an edge into the graph
  public void addEdge(int v, int w) {
    adjacent[v].add(w);
  }

  // A function used by DFS
  private List<Integer> depthFirstSearch(List<Integer> list, int v, boolean[] visited) {
    visited[v] = true;
    // Add the integer that was visited to the list.
    list.add(v);

    for (Object n : adjacent[v]) {
      if (!visited[(int) n]) {
        depthFirstSearch(list, (Integer) n, visited);
      }
    }

    return list;
  }

  public List<Integer> depthFirstSearch(int vertices) {
    // Mark all the vertices as not visited to false.
    // Java will automatically set these to false.
    boolean[] visited = new boolean[this.vertices];
    // List of integers that are visited.
    List<Integer> list = new ArrayList<>();

    // Recursive depth first search.
    return depthFirstSearch(list, vertices, visited);
  }
}
