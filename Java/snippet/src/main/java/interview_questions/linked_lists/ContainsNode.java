package interview_questions.linked_lists;

import data_structures.NodeItem;

public class ContainsNode {
  /*
  Given the head of a linked list, named head, and another node, item, check if
  the the head node has a reference to the item node.
  */

  public boolean contains(NodeItem<Integer> head, NodeItem<Integer> item) {
    if (head == null) {
      return false;
    }

    NodeItem<Integer> tail = head;
    while (tail != null) {
      if (System.identityHashCode(tail) == System.identityHashCode(item)) {
        return true;
      }

      tail = tail.next;
    }

    return false;
  }
}
