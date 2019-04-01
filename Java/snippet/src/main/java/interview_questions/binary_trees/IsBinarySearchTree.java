package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class IsBinarySearchTree {
  /*
   For the purposes of this challenge, we define a binary tree to be a binary search tree with the following ordering requirements:

   The data value of every node in a node's left subtree is less than the data value of that node.
   The data value of every node in a node's right subtree is greater than the data value of that node.
  */

  private BinaryTreeNode root;
  private BinaryTreeNode prev;

  // Performs in order traversal to check if the tree is a binary tree.

  public IsBinarySearchTree(BinaryTreeNode node) {
    this.root = node;
  }

  // Starts at the root and each time resets a temporary node
  // that acts as the previous node.
  boolean check() {
    prev = null;
    return check(this.root);
  }

  private boolean check(BinaryTreeNode node) {
    if (node != null) {
      if (!check(node.left)) {
        return false;
      }

      if (prev != null && node.data <= prev.data) {
        return false;
      }
      prev = node;
      return check(node.right);
    }
    return true;
  }
}
