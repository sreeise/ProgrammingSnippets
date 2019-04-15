package data_structures.graphs.graph.adjacencylist;

import java.util.LinkedList;

public class AdjacencyList {
  int vertex;
  LinkedList<Integer>[] adjacent;

  public AdjacencyList(int v) {
    this.vertex = v;

    adjacent = new LinkedList[v];

    for (int i = 0; i < v; i++) {
      adjacent[i] = new LinkedList<>();
    }
  }

  public void addEdge(int src, int dest) {
    adjacent[src].add(dest);
    adjacent[dest].add(src);
  }

  public void printGraph() {
    for (int v = 0; v < vertex; v++) {
      System.out.println("Adjacency list of vertex " + v);
      System.out.print("head");
      for (Integer pCrawl : adjacent[v]) {
        System.out.print(" -> " + pCrawl);
      }
      System.out.println("\n");
    }
  }
}
