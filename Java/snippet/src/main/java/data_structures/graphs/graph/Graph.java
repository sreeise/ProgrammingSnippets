package data_structures.graphs.graph;

/*
"Vertex" is a synonym for a node of a graph, i.e., one of the points on which the graph is
defined and which may be connected by graph edges


 */

public class Graph {
  private static final String NEWLINE = System.getProperty("line.separator");

  private final int vertex;
  private int edge;
  private GraphNode<Integer>[] adj;

  public Graph(int vertex) {
    if (vertex < 0) {
      throw new IllegalArgumentException("Number of vertices must be nonnegative");
    }

    this.vertex = vertex;
    this.edge = 0;
    adj = new GraphNode[vertex];
    for (int i = 0; i < vertex; i++) {
      adj[i] = new GraphNode<>();
    }
  }

  /**
   * Returns the number of vertices in this graph.
   *
   * @return the number of vertices in this graph
   */
  public int vertexSize() {
    return vertex;
  }

  /**
   * Returns the number of edges in this graph.
   *
   * @return the number of edges in this graph
   */
  public int edgeSize() {
    return edge;
  }

  // throw an IllegalArgumentException unless {@code 0 <= v < V}
  private void validateVertex(int v) {
    if (v < 0 || v >= this.vertex)
      throw new IllegalArgumentException(
            "vertex " + v + " is not between 0 and " + (this.vertex - 1));
  }

  public void addEdge(int v, int w) {
    validateVertex(v);
    validateVertex(w);
    edge++;
    adj[v].add(w);
    adj[w].add(v);
  }

  public Iterable<Integer> adj(int v) {
    validateVertex(v);
    return adj[v];
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(vertex + " vertices, " + edge + " edges " + NEWLINE);
    for (int v = 0; v < vertex; v++) {
      s.append(v + ": ");
      for (int w : adj[v]) {
        s.append(w + " ");
      }
      s.append(NEWLINE);
    }
    return s.toString();
  }
}
