package interview_questions.linked_lists;

import java.util.HashSet;

public class DetectCycle {
  /*
  A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
  It has one parameter: a pointer to a Node object named that points to the head of a linked list.
  Your function must return a boolean denoting whether or not there is a cycle in the list.
  If there is a cycle, return true; otherwise, return false.
   */
  public static boolean hasCycle(SinglyLinkedListNode head) {
    if (head == null) {
      return false;
    }

    HashSet<Integer> hashSet = new HashSet<>();
    SinglyLinkedListNode tail = head;

    while (tail != null) {
      if (hashSet.contains(System.identityHashCode(tail))) {
        return true;
      }
      hashSet.add(System.identityHashCode(tail));
      tail = tail.next;
    }

    return false;
  }
}
