package interview_questions.linked_lists;

import java.util.HashSet;

public class MergeNodePosition {
  /*
  Given pointers to the head nodes of linked lists that merge together at some point,
  find the Node where the two lists merge. It is guaranteed that the two head Nodes
  will be different, and neither will be NULL.

  Note: Don't use a node with the data equal to -1.
   */
  public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    HashSet<Integer> hashSet = mapNode(head1);
    SinglyLinkedListNode tail = head2;

    while (tail != null) {
      if (hashSet.contains(System.identityHashCode(tail))) {
        return tail.data;
      }

      tail = tail.next;
    }

    return -1;
  }

  private static HashSet<Integer> mapNode(SinglyLinkedListNode head) {
    HashSet<Integer> hashSet = new HashSet<>();
    SinglyLinkedListNode tail = head;

    while (tail != null) {
      hashSet.add(System.identityHashCode(tail));
      tail = tail.next;
    }

    return hashSet;
  }
}
