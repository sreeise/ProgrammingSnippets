package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class DeleteBinarySearchTreeNode {
  /*
  Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
  insert the value into the BST. Return the root node of the BST after the insertion. It is
  guaranteed that the new value does not exist in the original BST.
   */
  /*
  One step right and then always left
  */
  public static int successor(BinaryTreeNode root) {
    root = root.right;
    while (root.left != null) {
      root = root.left;
    }
    return root.data;
  }

  /*
  One step left and then always right
  */
  public static int predecessor(BinaryTreeNode root) {
    root = root.left;
    while (root.right != null) {
      root = root.right;
    }
    return root.data;
  }

  public static BinaryTreeNode deleteNode(BinaryTreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (key > root.data) {
      root.right = deleteNode(root.right, key);
    } else if (key < root.data) {
      root.left = deleteNode(root.left, key);
    } else {
      // the node is a leaf
      if (root.left == null && root.right == null) {
        root = null;
      } else if (root.right != null) {
        // the node is not a leaf and has a right child
        root.data = successor(root);
        root.right = deleteNode(root.right, root.data);
      } else {
        // the node is not a leaf, has no right child, and has a left child
        root.data = predecessor(root);
        root.left = deleteNode(root.left, root.data);
      }
    }
    return root;
  }
}
