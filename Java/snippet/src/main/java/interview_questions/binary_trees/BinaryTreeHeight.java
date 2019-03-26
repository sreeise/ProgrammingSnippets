package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class BinaryTreeHeight {
  /*
  The height of binary tree with single node is taken to be 1
  and the height of the empty binary tree is taken to be -1.

  1. If the root is null, return -1
  2. Else return 1 plus the greatest height between the left and right subtree

  Math.max returns the greater of two int values. That is, the result is the argument
  closer to positive infinity. If the arguments have the same value, the result is that same value
   */
  public static int getHeight(BinaryTreeNode root) {
    if (root == null) {
      return -1;
    } else {
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
  }
}
