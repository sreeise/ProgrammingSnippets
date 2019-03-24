package tests;

import interview_questions.linked_lists.DetectCycle;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DetectCycleLinkedListTest {
  @Test
  public void detectCycleTestTrue() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(1);
    SinglyLinkedListNode node2 = new SinglyLinkedListNode(2);
    node.next = node2;
    node.next.next = new SinglyLinkedListNode(3);
    node.next.next.next = new SinglyLinkedListNode(2);
    node.next.next.next.next = node2;
    assertTrue(DetectCycle.hasCycle(node2));
  }

  @Test
  public void detectCycleTestFalse() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(1);
    node.next = new SinglyLinkedListNode(3);
    node.next.next = new SinglyLinkedListNode(2);
    assertFalse(DetectCycle.hasCycle(node));
  }
}
