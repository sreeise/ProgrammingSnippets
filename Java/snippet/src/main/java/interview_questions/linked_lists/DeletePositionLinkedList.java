package interview_questions.linked_lists;

public class DeletePositionLinkedList {
  /*
  You’re given the pointer to the head node of a linked list and the position of a node to delete.
  Delete the node at the given position and return the head node. A position of 0 indicates head,
  a position of 1 indicates one node away from the head and so on. The list may become empty after
  you delete the node.
   */
  public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    if (head == null) {
      return null;
    }

    SinglyLinkedListNode temp = head;
    if (position == 0) {
      head = temp.next;
      return head;
    }

    int count = 1;
    while (count < position) {
      temp = temp.next;
      count++;
    }

    SinglyLinkedListNode next = temp.next.next;
    temp.next = next;

    next = head;
    return next;
  }
}
