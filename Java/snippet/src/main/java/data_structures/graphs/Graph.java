package data_structures.graphs;

// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2004.%20Trees%20and%20Graphs/Q4_01_Route_Between_Nodes/Graph.java
public class Graph {
  public static int MAX_VERTICES = 6;
  private GraphNode vertices[];
  public int count;
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
