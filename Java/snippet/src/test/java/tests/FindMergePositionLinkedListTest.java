package tests;

import interview_questions.linked_lists.MergeNodePosition;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FindMergePositionLinkedListTest {
  @Test
  public void findMergePositionTest() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(1);
    SinglyLinkedListNode node2 = new SinglyLinkedListNode(2);
    node.next = node2;
    node.next.next = new SinglyLinkedListNode(3);
    node.next.next.next = new SinglyLinkedListNode(2);

    SinglyLinkedListNode node3 = new SinglyLinkedListNode(44);
    node3.next = new SinglyLinkedListNode(22);
    node3.next.next = node2;
    node3.next.next.next = new SinglyLinkedListNode(11);

    assertNotEquals(MergeNodePosition.findMergeNode(node, node3), -1);
    assertEquals(MergeNodePosition.findMergeNode(node, node3), 2);
  }
}
