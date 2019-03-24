package tests;

import interview_questions.linked_lists.CompareLinkedLists;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompareLinkedListsTest {
  @Test
  public void compareLinkedListsTrue() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(1);
    node.next = new SinglyLinkedListNode(4);
    node.next.next = new SinglyLinkedListNode(4);
    SinglyLinkedListNode node2 = new SinglyLinkedListNode(1);
    node2.next = new SinglyLinkedListNode(4);
    node2.next.next = new SinglyLinkedListNode(4);
    assertTrue(CompareLinkedLists.compareLists(node, node2));
  }

  @Test
  public void compareLinkedListsFalse() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(1);
    node.next = new SinglyLinkedListNode(4);
    node.next.next = new SinglyLinkedListNode(4);
    SinglyLinkedListNode node2 = new SinglyLinkedListNode(1);
    node2.next = new SinglyLinkedListNode(4);
    node2.next.next = new SinglyLinkedListNode(4);
    node2.next.next.next = new SinglyLinkedListNode(8);
    assertFalse(CompareLinkedLists.compareLists(node, node2));
  }
}
