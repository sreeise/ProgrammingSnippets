package interview_questions.graphs;

import java.util.LinkedList;

public class DepthFirstSearch {
  private int V;
  private LinkedList<Integer>[] adj;

  public DepthFirstSearch(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList();
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public int vertex() {
    return this.V;
  }


  public void depthFirstSearch(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");

    for (int n : adj[v]) {
      if (!visited[n])
        depthFirstSearch(n, visited);
    }
  }
}
