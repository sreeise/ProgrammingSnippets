package tests;

import data_structures.graphs.trees.BinaryTree;
import data_structures.graphs.trees.BinaryTreeNode;
import interview_questions.binary_trees.BinaryTreeHeight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryTreeHeightTest {
  @Test
  public void binaryHeightTest() {
    BinaryTree tree = new BinaryTree(1);
    tree.root.left = new BinaryTreeNode(2);
    tree.root.right = new BinaryTreeNode(3);
    tree.root.left.left = new BinaryTreeNode(4);
    assertEquals(BinaryTreeHeight.getHeight(tree.root), 2);
  }
}
