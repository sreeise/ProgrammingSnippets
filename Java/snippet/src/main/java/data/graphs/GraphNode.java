package data.graphs;

public class GraphNode {
  public enum State {
    Unvisited, Visited, Visiting;
  }

  private GraphNode[] adjacent;
  private int adjacentCount;
  private String vertex;
  GraphNode.State state;

  public GraphNode(String vertex, int adjacentLength) {
    this.vertex = vertex;
    adjacentCount = 0;
    adjacent = new GraphNode[adjacentLength];
  }

  public void addAdjacent(GraphNode x) {
    if (adjacentCount < adjacent.length) {
      this.adjacent[adjacentCount] = x;
      adjacentCount++;
    } else {
      System.out.print("No more adjacent can be added");
    }
  }

  public GraphNode[] getAdjacent() {
    return adjacent;
  }

  public String getVertex() {
    return vertex;
  }
}
