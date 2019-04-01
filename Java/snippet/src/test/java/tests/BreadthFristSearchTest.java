package tests;

import data_structures.graphs.breadth_first_search.BreadthFirstSearch;
import data_structures.graphs.breadth_first_search.Graph;
import data_structures.graphs.breadth_first_search.GraphNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BreadthFristSearchTest {

  private static Graph createNewGraph() {
    Graph g = new Graph();
    GraphNode[] temp = new GraphNode[6];

    temp[0] = new GraphNode("a", 3);
    temp[1] = new GraphNode("b", 0);
    temp[2] = new GraphNode("c", 0);
    temp[3] = new GraphNode("d", 1);
    temp[4] = new GraphNode("e", 1);
    temp[5] = new GraphNode("f", 0);

    temp[0].addAdjacent(temp[1]);
    temp[0].addAdjacent(temp[2]);
    temp[0].addAdjacent(temp[3]);
    temp[3].addAdjacent(temp[4]);
    temp[4].addAdjacent(temp[5]);

    for (int i = 0; i < 6; i++) {
      g.addNode(temp[i]);
    }
    return g;
  }

  @Test
  public void testBreadthFirstSearch() {
    Graph g = createNewGraph();
    GraphNode[] n = g.getNodes();
    GraphNode start = n[3];
    GraphNode end = n[5];
    assertTrue(BreadthFirstSearch.search(g, start, end));
  }
}
