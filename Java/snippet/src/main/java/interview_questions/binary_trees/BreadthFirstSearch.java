package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
  /*
  Breadth first search in binary trees traverses all the nodes at each level before
  going to the next level. Given the root of a binary tree, traverse the root node
  using breadth first traversal and print the data of each node.
   */

  public static void breadthFirst(BinaryTreeNode root) {
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      BinaryTreeNode node = queue.poll();
      System.out.print(node.data + " ");

      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }
    }
  }
}
