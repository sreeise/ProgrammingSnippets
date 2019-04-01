package interview_questions.linked_lists;

public class PrintReversedLinkedList {
  public static void reversePrint(SinglyLinkedListNode head) {
    if (head == null) {
      return;
    }

    SinglyLinkedListNode reversed = ReverseLinkedList.reverse(head);
    while (reversed != null) {
      System.out.println(reversed.data);
      reversed = reversed.next;
    }
  }
}
