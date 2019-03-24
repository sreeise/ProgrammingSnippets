package interview_questions.linked_lists;

import java.util.HashSet;

public class RemoveDuplicates {
  /*
  You're given the pointer to the head node of a sorted linked list, where the data in the nodes
  is in ascending order. Delete as few nodes as possible so that the list does not contain any
  value more than once. The given head pointer may be null indicating that the list is empty.
   */
  public static SinglyLinkedListNode removeDuplicatesRecursive(SinglyLinkedListNode head) {
    if (head == null) {
      return null;
    }

    SinglyLinkedListNode next = head.next;
    while (next != null && head.data == next.data) {
      next = next.next;
    }

    head.next = removeDuplicates(next);
    return head;
  }

  public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    HashSet<Integer> hashSet = countFrequency(head);
    SinglyLinkedListNode ref = new SinglyLinkedListNode(0);
    SinglyLinkedListNode temp = ref;

    for (Integer integer : hashSet) {
      temp.next = new SinglyLinkedListNode(integer);
      temp = temp.next;
    }

    return ref.next;
  }

  private static HashSet<Integer> countFrequency(SinglyLinkedListNode head) {
    HashSet<Integer> map = new HashSet<>();
    while (head != null) {
      map.add(head.data);
      head = head.next;
    }
    return map;
  }
}
