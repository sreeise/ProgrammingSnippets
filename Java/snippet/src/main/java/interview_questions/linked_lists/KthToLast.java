package interview_questions.linked_lists;

// First solution reference: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_02_Return_Kth_To_Last/QuestionC.java
// Second solution reference: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2002.%20Linked%20Lists/Q2_02_Return_Kth_To_Last/QuestionD.java
public class KthToLast {
  /*
  Implement an algorithm to find the kth to last element of a singly linked list.

  k is defined as such: k = 1 would return the last element, k = 2 would return the
  second to last element and so on.
   */

  // Solution 1
  static class Index {
    public int value = 0;
  }

  public static SinglyLinkedListNode kthToLast(SinglyLinkedListNode head, int k) {
    Index idx = new Index();
    return kthToLast(head, k, idx);
  }

  private static SinglyLinkedListNode kthToLast(SinglyLinkedListNode head, int k, Index idx) {
    if (head == null) {
      return null;
    }
    SinglyLinkedListNode node = kthToLast(head.next, k, idx);
    idx.value = idx.value + 1;
    if (idx.value == k) {
      return head;
    }
    return node;
  }

  // Solution 2
  public static SinglyLinkedListNode nthToLast(SinglyLinkedListNode head, int k) {
    SinglyLinkedListNode p1 = head;
    SinglyLinkedListNode p2 = head;

    // Move p1 nodes into the list
    for (int i = 0; i < k; i++) {
      if (p1 == null) {
        return null;
      }
      p1 = p1.next;
    }

    // Move p1 and p2 the same pace. When p1 hits the end, p2 will be the right element.
    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p2;
  }
}
