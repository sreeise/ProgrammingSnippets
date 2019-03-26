package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

A node x is there in output if x is the topmost node at its horizontal distance.
Horizontal distance of left child of a node x is equal to horizontal distance of
x minus 1, and that of right child is horizontal distance of x plus 1.
*/
public class TopView {
  public static void topView(BinaryTreeNode root) {
    Queue<ObjectQueue> queue = new LinkedList<>();
    Map<Integer, BinaryTreeNode> map = new TreeMap<>();

    if (root == null) {
      return;
    } else {
      queue.add(new ObjectQueue(root, 0));
    }

    while (!queue.isEmpty()) {
      ObjectQueue temp = queue.poll();

      if (!map.containsKey(temp.hd)) {
        map.put(temp.hd, temp.node);
      }

      if (temp.node.left != null) {
        queue.add(new ObjectQueue(temp.node.left, temp.hd - 1));
      }

      if (temp.node.right != null) {
        queue.add(new ObjectQueue(temp.node.right, temp.hd + 1));
      }
    }

    for (Map.Entry<Integer, BinaryTreeNode> entry : map.entrySet()) {
      System.out.print(entry.getValue().data + " ");
    }
  }

  static class ObjectQueue {
    BinaryTreeNode node;
    int hd;

    ObjectQueue(BinaryTreeNode node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }
}
