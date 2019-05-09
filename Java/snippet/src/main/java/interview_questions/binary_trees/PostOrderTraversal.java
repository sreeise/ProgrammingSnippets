package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class PostOrderTraversal {
  /*
  Given the root of a binary tree node, perform in order traversal.
  Print the root node's data each time you visit the root.
   */

  public static void postOrder(BinaryTreeNode root) {
    // Since we are recursing through the binary tree node
    // we will eventually hit a null argument for the root.
    if (root == null) {
      return;
    }

    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.data);
  }
}
