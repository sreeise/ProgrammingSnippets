package interview_questions.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
  /*
  Traverse a graph using breadth first search.

  Breadth first search is similar to bread first traversal in binary trees,
  however, in graphs there is a possibility for cycles so we may end up
  at the same node twice. To combat this, we use a boolean array to store
  true or false for whether we have visited the node before.
   */

  static class Graph {
    int v;
    LinkedList[] adjacent;

    Graph(int v) {
      this.v = v;
      this.adjacent = new LinkedList[v];
      for (int i = 0; i < v; i++) {
        this.adjacent[i] = new LinkedList<>();
      }
    }

    void addEdge(int v, int w) {
      this.adjacent[v].add(w);
    }
  }

  public static void breadthFirstSearch(Graph graph, int s) {
    boolean[] visited = new boolean[graph.v];

    Queue<Integer> queue = new LinkedList<>();

    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      s = queue.poll();
      System.out.print(s + " ");

      Iterator<Integer> i = graph.adjacent[s].listIterator();

      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  public static void print() {
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    breadthFirstSearch(g, 2);
  }
}
