package data_structures.graphs.breadth_first_search;

public class GraphNode {
  GraphNode.State state;
  private GraphNode[] adjacent;
  private int adjacentCount;
  private String vertex;

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

  public enum State {
    Unvisited,
    Visited,
    Visiting;
  }
}
