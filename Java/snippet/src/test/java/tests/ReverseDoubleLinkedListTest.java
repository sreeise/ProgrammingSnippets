package tests;

import interview_questions.linked_lists.DoublyLinkedListNode;
import interview_questions.linked_lists.ReverseDoubleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseDoubleLinkedListTest {
  @Test
  public void reverseSolution1() {
    DoublyLinkedListNode head = new DoublyLinkedListNode(1);
    DoublyLinkedListNode tail1 = new DoublyLinkedListNode(2);
    DoublyLinkedListNode tail2 = new DoublyLinkedListNode(6);
    head.next = tail1;
    tail1.prev = head;
    tail1.next = tail2;
    tail2.prev = tail1;
    head = ReverseDoubleLinkedList.reverse(head);
    assertEquals(head.data, 6);
    assertEquals(head.next.data, 2);
    assertEquals(head.next.next.data, 1);
  }

  @Test
  public void reverseSolution2() {
    DoublyLinkedListNode head = new DoublyLinkedListNode(1);
    DoublyLinkedListNode tail1 = new DoublyLinkedListNode(2);
    DoublyLinkedListNode tail2 = new DoublyLinkedListNode(6);
    head.next = tail1;
    tail1.prev = head;
    tail1.next = tail2;
    tail2.prev = tail1;
    head = ReverseDoubleLinkedList.reverseWithCollections(head);
    assertEquals(head.data, 6);
    assertEquals(head.next.data, 2);
    assertEquals(head.next.next.data, 1);
  }
}
