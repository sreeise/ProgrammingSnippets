package data_structures.graphs.graph.path;

import java.util.LinkedList;

public class PathNode {
  public int id;
  LinkedList<PathNode> adjacent = new LinkedList<>();

  public PathNode(int id) {
    this.id = id;
  }
}
