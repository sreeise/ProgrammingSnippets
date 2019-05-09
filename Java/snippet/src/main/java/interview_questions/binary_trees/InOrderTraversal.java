package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class InOrderTraversal {
  /*
  Given the root of a binary tree node, perform in order traversal.
  Print the root node's data each time you visit the root.
   */

  public static void inOrder(BinaryTreeNode root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);
    System.out.println(root.data);
    inOrder(root.right);
  }
}
