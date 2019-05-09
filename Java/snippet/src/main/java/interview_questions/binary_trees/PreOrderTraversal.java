package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class PreOrderTraversal {
  /*
Given the root of a binary tree node, perform pre order traversal.
Print the root node's data each time you visit the root.
 */
  public static void postOrder(BinaryTreeNode root) {
    if (root == null) {
      return;
    }

    System.out.println(root.data);
    postOrder(root);
    postOrder(root);
  }
}
