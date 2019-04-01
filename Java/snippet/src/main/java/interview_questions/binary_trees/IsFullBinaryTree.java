package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsFullBinaryTree {
  /*
  Given the root of a binary tree node, check whether the binary tree
  is a full binary tree.

  A full binary tree is a tree in which all nodes have either zero or
  two child nodes.
   */

  public static boolean iritativeCheck(BinaryTreeNode root) {
    if (root == null) {
      return true;
    }

    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      BinaryTreeNode node = queue.peek();
      queue.remove();

      if (node.left == null && node.right == null) {
        continue;
      }

      if (node.left == null || node.right == null) {
        return false;
      }

      queue.add(node.left);
      queue.add(node.right);
    }

    return true;
  }

  public static boolean recursiveCheck(BinaryTreeNode node) {
    if (node == null) {
      return true;
    }

    if (node.left == null && node.right == null) {
      return true;
    }

    if ((node.left != null) && (node.right != null)) {
      return recursiveCheck(node.left) && recursiveCheck(node.right);
    }

    return false;
  }
}
