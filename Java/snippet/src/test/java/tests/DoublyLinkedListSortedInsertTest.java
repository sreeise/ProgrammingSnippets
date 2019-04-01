package tests;

import interview_questions.linked_lists.DoublyLinkedListNode;
import interview_questions.linked_lists.DoublyLinkedListSortedInsert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListSortedInsertTest {
  @Test
  public void sortedInsertTest() {
    DoublyLinkedListNode head = new DoublyLinkedListNode(1);
    DoublyLinkedListNode tail1 = new DoublyLinkedListNode(2);
    DoublyLinkedListNode tail2 = new DoublyLinkedListNode(6);
    head.next = tail1;
    tail1.prev = head;
    tail1.next = tail2;
    tail2.prev = tail1;

    head = DoublyLinkedListSortedInsert.sortedInsert(head, 10);
    head = DoublyLinkedListSortedInsert.sortedInsert(head, 8);
    head = DoublyLinkedListSortedInsert.sortedInsert(head, 5);

    assertEquals(head.data, 1);
    assertEquals(head.next.data, 2);
    assertEquals(head.next.next.data, 5);
    assertEquals(head.next.next.next.data, 6);
    assertEquals(head.next.next.next.next.data, 8);
    assertEquals(head.next.next.next.next.next.data, 10);
    assertEquals(head.next.next.next.next.next.prev.data, 8);
    assertEquals(head.next.next.next.next.prev.data, 6);
  }
}
