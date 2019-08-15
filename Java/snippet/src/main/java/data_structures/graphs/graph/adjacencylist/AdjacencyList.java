package data_structures.graphs.graph.adjacencylist;

import java.util.Iterator;
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
      System.out.print(v);
      for (Integer pCrawl : adjacent[v]) {
        System.out.print(" -> " + pCrawl);
      }
      System.out.println("\n");
    }
  }

  public int bfs(int s, int d) {
    boolean[] visited = new boolean[this.vertex];
    LinkedList<Integer> queue = new LinkedList<>();
    visited[s] = true;
    queue.add(s);

    int count = 0;
    while (!queue.isEmpty()) {
      int next = queue.poll();
   //   System.out.println("s: " + next);
      count++;
      if (next == d) {
        if (count == 1 || count == 2) {
          count = 6;
        } else {
          count = 6 * (count -1);
        }

        return count;
      }

      Iterator<Integer> i = adjacent[next].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
    return -1;
  }



}
