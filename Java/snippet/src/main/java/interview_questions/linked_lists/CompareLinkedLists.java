package interview_questions.linked_lists;

public class CompareLinkedLists {
  /*
  You’re given the pointer to the head nodes of two linked lists. Compare the data in the nodes
  of the linked lists to check if they are equal. The lists are equal only if they have the
  same number of nodes and corresponding nodes contain the same data. Either head pointer
  given may be null meaning that the corresponding list is empty.
   */
  public static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    if (head1 == null && head2 == null) {
      return true;
    }

    if (head1 == null || head2 == null) {
      return false;
    }

    while (head1 != null) {
      if (head2 == null) {
        return false;
      }
      if (head1.data != head2.data) {
        return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }

    if (head2 != null) {
      return false;
    }

    return true;
  }
}
