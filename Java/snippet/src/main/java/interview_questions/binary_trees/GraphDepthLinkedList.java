package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;
import data_structures.linked_lists.LinkedList;

import java.util.ArrayList;

public class GraphDepthLinkedList {
  /*
  Given the root of a binary tree, design an algorithm which creates a linked list of all the nodes
  at each depth (e.g. If you have a tree with depth D, you'll have D linked lists).
   */

  public void createList(
      BinaryTreeNode root, ArrayList<LinkedList<BinaryTreeNode>> lists, int level) {
    if (root == null) {
      return;
    }

    LinkedList<BinaryTreeNode> list = null;
    if (lists.size() == level) {
      list = new LinkedList<BinaryTreeNode>();
      lists.add(list);
    } else {
      list = lists.get(level);
    }

    list.add(root);

    createList(root.left, lists, level + 1);
    createList(root.right, lists, level + 1);
  }

  public ArrayList<LinkedList<BinaryTreeNode>> createList(BinaryTreeNode root) {
    ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<>();
    createList(root, lists, 0);
    return lists;
  }
}
