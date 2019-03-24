package tests;

import interview_questions.linked_lists.InsertLinkedListHead;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertLinkedListTest {
  @Test
  public void insertLinkedListHeadTest() {
    SinglyLinkedListNode head = null;
    head = InsertLinkedListHead.insertNodeAtHead(head, 321);
    head = InsertLinkedListHead.insertNodeAtHead(head, 975);
    assertEquals(head.data, 975);
    assertEquals(head.next.data, 321);
  }
}
