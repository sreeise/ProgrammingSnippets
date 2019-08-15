package tests;

import data_structures.graphs.graph.path.PathGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathGraphTest {
  private int[][] nodes = {
        {1, 2},
        {3, 1},
        {2, 3},
        {4, 1}
  };

  private int[][] nodes2 = {
        {1, 6},
        {2, 7},
        {3, 8},
        {4, 9},
        {2, 6},
        {1, 2}
  };


  private PathGraph createGraph(int[][] nodes) {
    PathGraph graph = new PathGraph();
    for (int i = 0; i < nodes.length; i++) {
      graph.addNode(nodes[i][0]);
      graph.addNode(nodes[i][1]);
    }

    for (int i = 0; i < nodes.length; i++) {
      graph.addEdge(nodes[i][0], nodes[i][1]);
    }

    return graph;
  }

  @Test
  public void bfs1() {
    PathGraph graph = createGraph(nodes);
    assertTrue(graph.hasPathBFS(1, 2));
    assertTrue(graph.hasPathBFS(3, 1));
    assertTrue(graph.hasPathBFS(2, 3));
    assertTrue(graph.hasPathBFS(4, 1));
    assertTrue(graph.hasPathBFS(1, 3));
    assertTrue(graph.hasPathBFS(2, 1));
    assertTrue(graph.hasPathBFS(3, 2));

    assertFalse(graph.hasPathBFS(1, 4));
  }

  @Test
  public void bfs2() {
    PathGraph graph = createGraph(nodes2);
    assertTrue(graph.hasPathBFS(1, 6));
    assertTrue(graph.hasPathBFS(1, 2));
    assertTrue(graph.hasPathBFS(2, 6));
    assertTrue(graph.hasPathBFS(4, 9));
    assertTrue(graph.hasPathBFS(3, 8));
    assertTrue(graph.hasPathBFS(2, 7));

    assertFalse(graph.hasPathBFS(6, 2));
    assertFalse(graph.hasPathBFS(9, 4));
    assertFalse(graph.hasPathBFS(8, 3));
    assertFalse(graph.hasPathBFS(7, 2));
  }

  @Test
  public void dfs1() {
    PathGraph graph = createGraph(nodes);
    assertTrue(graph.hasPathDFS(1, 2));
    assertTrue(graph.hasPathDFS(3, 1));
    assertTrue(graph.hasPathDFS(2, 3));
    assertTrue(graph.hasPathDFS(4, 1));
    assertTrue(graph.hasPathDFS(1, 3));
    assertTrue(graph.hasPathDFS(2, 1));
    assertTrue(graph.hasPathDFS(3, 2));

    assertFalse(graph.hasPathDFS(1, 4));
  }

  @Test
  public void dfs2() {
    PathGraph graph = createGraph(nodes2);
    assertTrue(graph.hasPathDFS(1, 6));
    assertTrue(graph.hasPathDFS(1, 2));
    assertTrue(graph.hasPathDFS(2, 6));
    assertTrue(graph.hasPathDFS(4, 9));
    assertTrue(graph.hasPathDFS(3, 8));
    assertTrue(graph.hasPathDFS(2, 7));

    assertFalse(graph.hasPathDFS(6, 2));
    assertFalse(graph.hasPathDFS(9, 4));
    assertFalse(graph.hasPathDFS(8, 3));
    assertFalse(graph.hasPathDFS(7, 2));
  }
}
