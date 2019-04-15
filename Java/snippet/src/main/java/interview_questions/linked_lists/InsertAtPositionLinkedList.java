package interview_questions.linked_lists;

public class InsertAtPositionLinkedList {
  /*
  You’re given the pointer to the head node of a linked list, an integer to enqueue to the list
  and the position at which the integer must be inserted. Create a new node with the given
  integer, insert this node at the desired position and return the head node.
   */
  public static SinglyLinkedListNode insertNodeAtPosition(
      SinglyLinkedListNode head, int data, int position) {
    int count = 1;
    SinglyLinkedListNode current = head;
    while (count < position) {
      current = current.next;
      count++;
    }
    SinglyLinkedListNode ref = current.next;
    SinglyLinkedListNode newRef = new SinglyLinkedListNode(data);
    current.next = newRef;
    newRef.next = ref;
    current = head;
    return current;
  }
}
