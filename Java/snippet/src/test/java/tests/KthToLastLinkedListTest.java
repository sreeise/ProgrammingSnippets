package tests;

import interview_questions.linked_lists.KthToLast;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KthToLastLinkedListTest {
  private static SinglyLinkedListNode testCase() {
    SinglyLinkedListNode head = new SinglyLinkedListNode(3);
    head.next = new SinglyLinkedListNode(2);
    head.next.next = new SinglyLinkedListNode(82);
    head.next.next.next = new SinglyLinkedListNode(3);
    head.next.next.next.next = new SinglyLinkedListNode(2);
    return head;
  }

  @Test
  public void testKthToLast() {
    SinglyLinkedListNode kthToLast = KthToLast.kthToLast(testCase(), 3);
    assertNotNull(kthToLast);
    assertEquals(kthToLast.data, 82);
    SinglyLinkedListNode nthToLast = KthToLast.nthToLast(testCase(), 3);
    assertNotNull(nthToLast);
    assertEquals(nthToLast.data, 82);
  }
}
