package data_structures.graphs.graph.path;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
Represents either a directed or undirected graph for checking if there
is a path between two nodes.

For use as an undirected graph the path must be added twice. For instance,
a vertex 1 and edge 2 must be added as:
  graph.addEdge(1, 2)
  graph.addEdge(2, 1)

Be sure to call addNode on both nodes 1 and 2 before adding edges.

See the example method below.
 */

public class PathGraph {
  private HashMap<Integer, PathNode> map;

  public PathGraph() {
    map = new HashMap<>();
  }

  public static void example() {
    int[][] nodes = {
          {1, 2},
          {3, 1},
          {2, 3},
          {4, 1},
    };

    PathGraph graph = new PathGraph();
    // Add the nodes to the graph.
    for (int[] node : nodes) {
      // A HashSet is used so only nodes that are
      // new will be added.
      graph.addNode(node[0]);
      graph.addNode(node[1]);
    }

    // Add the edges - the nodes that are connected
    // to each other.
    for (int[] node : nodes) {
      graph.addEdge(node[0], node[1]);
    }

    // Prints true. Node 1 has an edge going to Node 2. Node 2
    // has an edge going to 3 so the path will be 1 -> 2 -> 3.
    System.out.println(graph.hasPathBFS(1, 3)); // => true
  }

  public void addNode(int id) {
    this.map.put(id, new PathNode(id));
  }

  private PathNode getNode(int id) {
    return this.map.get(id);
  }

  public void addEdge(int source, int destination) {
    PathNode s = getNode(source);
    PathNode d = getNode(destination);
    s.adjacent.add(d);
  }

  public boolean hasPathDFS(int source, int destination) {
    PathNode s = getNode(source);
    PathNode d = getNode(destination);

    // List of node id's that have already been visited.
    HashSet<Integer> visited = new HashSet<>();
    return hasPathDFS(s, d, visited);
  }

  private boolean hasPathDFS(PathNode source, PathNode destination, HashSet<Integer> visited) {
    if (visited.contains(source.id)) {
      return false;
    }

    visited.add(source.id);

    if (source == destination) {
      return true;
    }

    for (PathNode child : source.adjacent) {
      if (hasPathDFS(child, destination, visited)) {
        return true;
      }
    }

    return false;
  }

  public boolean hasPathBFS(int source, int destination) {
    return hasPathBFS(getNode(source), getNode(destination));
  }

  private boolean hasPathBFS(PathNode source, PathNode destination) {
    LinkedList<PathNode> next = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    next.add(source);

    while (!next.isEmpty()) {
      PathNode node = next.remove();

      if (node == destination) {
        return true;
      }

      if (visited.contains(node.id)) {
        continue;
      }

      visited.add(node.id);

      next.addAll(node.adjacent);
    }
    return false;
  }
}
