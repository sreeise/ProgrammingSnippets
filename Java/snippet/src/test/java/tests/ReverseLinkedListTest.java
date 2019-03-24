package tests;

import interview_questions.linked_lists.ReverseLinkedList;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseLinkedListTest {
  @Test
  public void reverseLinkedList() {
    SinglyLinkedListNode linkedListNode = new SinglyLinkedListNode(1);
    linkedListNode.next = new SinglyLinkedListNode(2);
    linkedListNode.next.next = new SinglyLinkedListNode(3);

    assertEquals(linkedListNode.data, 1);
    assertEquals(linkedListNode.next.data, 2);
    assertEquals(linkedListNode.next.next.data, 3);
    assertNull(linkedListNode.next.next.next);

    SinglyLinkedListNode reversedLinkedList = ReverseLinkedList.reverse(linkedListNode);
    assertEquals(reversedLinkedList.data, 3);
    assertEquals(reversedLinkedList.next.data, 2);
    assertEquals(reversedLinkedList.next.next.data, 1);
    assertNull(reversedLinkedList.next.next.next);
  }
}
