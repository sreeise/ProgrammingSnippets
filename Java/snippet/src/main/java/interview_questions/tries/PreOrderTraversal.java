package interview_questions.tries;

import java.util.ArrayList;
import java.util.List;

/*
In an N-ary tree, preorder means visit the root node first and then traverse the subtree rooted at
its children one by one. For instance, the preorder of the 3-ary tree above is: A->B->C->E->F->D->G.
*/

public class PreOrderTraversal {
  /*
  Given an n-ary tree (trie), return the preorder traversal of its nodes' values. You must
  provide an irritative solution as opposed to a recursive solution.

  {"$id":"1",
  "children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},
  {"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},
  {"$id":"4","children":[],"val":4}],"val":1}
   */

  private static void traverse(TrieNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    if (root.children != null) {
      for (TrieNode child : root.children) {
        // Visit root.
        list.add(child.val);
        // Visit children.
        traverse(child, list);
      }
    }
  }

  public static List<Integer> preorder(TrieNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> list = new ArrayList<>();
    list.add(root.val);
    traverse(root, list);

    return list;
  }
}
