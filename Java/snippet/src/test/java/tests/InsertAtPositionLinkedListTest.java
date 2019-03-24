package tests;

import interview_questions.linked_lists.InsertAtPositionLinkedList;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertAtPositionLinkedListTest {
  @Test
  public void insertAtPositionLinkedListTest() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(1);
    node.next = new SinglyLinkedListNode(2);
    node.next.next = new SinglyLinkedListNode(4);
    assertEquals(node.data, 1);
    assertEquals(node.next.data, 2);
    assertEquals(node.next.next.data, 4);
    node = InsertAtPositionLinkedList.insertNodeAtPosition(node, 3, 2);
    assertEquals(node.data, 1);
    assertEquals(node.next.data, 2);
    assertEquals(node.next.next.data, 3);
    assertEquals(node.next.next.next.data, 4);
  }
}
