package interview_questions.linked_lists;

public class MergeSinglyLinkedLists {
  /*
  You’re given the pointer to the head nodes of two sorted linked lists. The data in both lists
  will be sorted in ascending order. Change the next pointers to obtain a single, merged linked
  list which also has data in ascending order. Either head pointer given may be null meaning
  that the corresponding list is empty.
   */

  public static SinglyLinkedListNode mergeLists(
        SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode ref = new SinglyLinkedListNode(0);
    SinglyLinkedListNode tail = ref;

    while (true) {
      if (head1 == null) {
        tail.next = head2;
        break;
      }

      if (head2 == null) {
        tail.next = head1;
        break;
      }

      if (head1.data < head2.data) {
        tail.next = head1;
        head1 = head1.next;
      } else {
        tail.next = head2;
        head2 = head2.next;
      }

      tail = tail.next;
    }

    return ref.next;
  }
}
