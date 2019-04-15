package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class MinimalHeight {
  /*
  Given a sorted (increasing order) array with unique integer elements,
  write an algorithm to create a binary search tree with minimal height;
   */

  public BinaryTreeNode createMinimalBST(int[] array) {
    return createMinimalBST(array, 0, array.length - 1);
  }

  public BinaryTreeNode createMinimalBST(int[] arr, int start, int end) {
    if (end < start) {
      return null;
    }

    int mid = (start + end) / 2;
    BinaryTreeNode node = new BinaryTreeNode(arr[mid]);
    node.left = createMinimalBST(arr, start, mid - 1);
    node.right = createMinimalBST(arr, mid + 1, end);
    return node;
  }
}
