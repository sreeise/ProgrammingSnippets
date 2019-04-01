package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class IsPerfectBinaryTree {
  /*
  Given the root of a binary tree node, check whether the binary tree
  is a perfect inary tree.

  A perfect binary tree is also a full binary tree where all nodes have either zero or
  two child nodes. Unlike a full binary tree, a perfect binary tree requires that the
  the height of the leaf nodes must be at the same level on both sides.
   */

  public static boolean check(BinaryTreeNode node) {
    if (node == null) {
      return true;
    }

    if (!IsFullBinaryTree.recursiveCheck(node)) {
      return false;
    }

    // The BinaryTreeHeight class gets the height of the
    // binary tree which is the depth of the leaf of a binary tree.
    int left = BinaryTreeHeight.getHeight(node.left);
    int right = BinaryTreeHeight.getHeight(node.right);

    return left == right;
  }
}
