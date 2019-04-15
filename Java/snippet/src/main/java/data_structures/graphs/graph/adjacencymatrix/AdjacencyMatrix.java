package data_structures.graphs.graph.adjacencymatrix;

import java.util.ArrayList;
import java.util.List;

// Space complexity: O(N^2)
public class AdjacencyMatrix {
  int n;
  boolean[][] matrix;

  public AdjacencyMatrix(int n) {
    this.n = n;
    matrix = new boolean[n][n];
  }

  // O(1)
  public void addEdge(int i, int j) {
    matrix[i][j] = true;
  }

  // O(1)
  public void removeEdge(int i, int j) {
    matrix[i][j] = false;
  }

  // O(1)
  public boolean hasEdge(int i, int j) {
    return matrix[i][j];
  }

  // O(N)
  public List<Integer> inEdges(int i) {
    List<Integer> edges = new ArrayList<>();
    for (int j = 0; j < n; j++) {
      if (matrix[j][i]) {
        edges.add(j);
      }
    }
    return edges;
  }

  // O(N)
  public List<Integer> outEdges(int i) {
    List<Integer> edges = new ArrayList<>();
    for (int j = 0; j < n; j++) {
      if (matrix[i][j]) {
        edges.add(j);
      }
    }

    return edges;
  }
}
