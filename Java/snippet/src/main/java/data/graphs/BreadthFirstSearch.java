package data.graphs;
import java.util.LinkedList;
/*
https://en.wikipedia.org/wiki/Breadth-first_search

Breadth First Search: Algorithm for traversing or searching tree or graph data structures. Starts at
  the tree root and explores all of the neighbor nodes at the present depth prior to moving on to the
  nodes at the next depth level.
*/

// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2004.%20Trees%20and%20Graphs/Q4_01_Route_Between_Nodes/Question.java
public class BreadthFirstSearch {
  public static boolean search(Graph graph, GraphNode start, GraphNode end) {
    if (start == end) {
      return true;
    }

    LinkedList<GraphNode> graphNodes = new LinkedList<>();

    for (GraphNode graphNode : graph.getNodes()) {
      graphNode.state = GraphNode.State.Unvisited;
    }

    start.state = GraphNode.State.Visiting;
    graphNodes.add(start);

    GraphNode u;
    while(!graphNodes.isEmpty()) {
      u = graphNodes.removeFirst();

      if (u != null) {
        for (GraphNode v : u.getAdjacent()) {
          if (v.state == GraphNode.State.Unvisited) {
            if (v == end) {
              return true;
            } else {
              v.state = GraphNode.State.Visiting;
              graphNodes.add(v);
            }
          }
        }
        u.state = GraphNode.State.Visited;
      }
    }
    return false;
  }
}
