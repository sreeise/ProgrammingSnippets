package interview_questions.binary_trees;

import data_structures.graphs.trees.BinaryTreeNode;

public class BinarySearchTreeLCA {
  /*
  You are given pointer to the root of the binary search tree and two values v1 and v2.
  You need to return the lowest common ancestor (LCA) of and in the binary search tree.

  Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as
  the lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).

  The distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance
  from the root to n2, minus twice the distance from the root to their lowest common ancestor.

  Source from: https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
  Also see: https://en.wikipedia.org/wiki/Lowest_common_ancestor
  */

  public static BinaryTreeNode lca(BinaryTreeNode root, int v1, int v2) {
    if (root == null) {
      return null;
    }

    if (root.data > v1 && root.data > v2) {
      return lca(root.left, v1, v2);
    }

    if (root.data < v1 && root.data < v2) {
      return lca(root.right, v1, v2);
    }

    return root;
  }
}
