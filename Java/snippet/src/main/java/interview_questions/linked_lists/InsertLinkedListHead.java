package interview_questions.linked_lists;

public class InsertLinkedListHead {
  /*
  You’re given the pointer to the head node of a linked list and an integer to enqueue to the list.
  Create a new node with the given integer, insert this node at the head of the linked list and
  return the new head node. The head pointer given may be null meaning that the initial list is empty.
   */
  public static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode list, int data) {
    if (list == null) {
      list = new SinglyLinkedListNode(data);
      list.next = null;
      return list;
    }
    SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    node.next = list;
    list = node;
    return list;
  }
}
