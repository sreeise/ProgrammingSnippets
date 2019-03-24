package interview_questions.linked_lists;

public class GetNodeFromTailPosition {
  public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
    SinglyLinkedListNode current = ReverseLinkedList.reverse(head);
    int count = 0;

    while (count < positionFromTail) {
      current = current.next;
      count++;
    }

    return current.data;
  }
}
