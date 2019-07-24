package interview_questions.linked_lists;

// Reference: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_03_Delete_Middle_Node/Question.java

public class DeleteMiddleNode {
  /*
  Implement an algorithm to delete a node in the middle. You are given
  the middle node directly not the head node of the linked list.
   */

  public static boolean deleteMiddle(SinglyLinkedListNode middle) {
    if (middle == null || middle.next == null) {
      return false;
    }

    // Copy the data from the next node over to the current node.
    SinglyLinkedListNode next = middle.next;
    middle.data = next.data;
    middle.next = next.next;
    return true;
  }
}
