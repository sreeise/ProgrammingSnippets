package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

import java.util.Stack;

public class DFSLargeTree {
  /*
  Perform depth-first search on an arbitrarily large tree.

  The key words being 'arbitrarily large' which basically means
  that using recursion could possibly cause stack overflow due to
  the amount of recursive calls needed for the tree possibly being
  larger than the actual call stack in the current run time. Thus,
  the solution would be to do an iterative depth-first search instead
  of a recursive one.
   */

  public static boolean depthFirstSearch(BinaryTreeNode node, int value) {
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      BinaryTreeNode current = stack.pop();

      if (current.data == value) {
        return true;
      }

      if (current.right != null) {
        stack.push(current.right);
      }

      if (current.left != null) {
        stack.push(current.left);
      }
    }

    return false;
  }
}
