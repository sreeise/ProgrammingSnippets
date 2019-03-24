package tests;

import interview_questions.linked_lists.MergeSinglyLinkedLists;
import interview_questions.linked_lists.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeLinkedListsTest {
  @Test
  public void mergeLinkedListTest() {
    SinglyLinkedListNode node = new SinglyLinkedListNode(1);
    node.next = new SinglyLinkedListNode(10);
    SinglyLinkedListNode node2 = new SinglyLinkedListNode(1);
    node2.next = new SinglyLinkedListNode(8);
    SinglyLinkedListNode mergeLists = MergeSinglyLinkedLists.mergeLists(node, node2);
    assertEquals(mergeLists.data, 1);
    assertEquals(mergeLists.next.data, 1);
    assertEquals(mergeLists.next.next.data, 8);
    assertEquals(mergeLists.next.next.next.data, 10);
    assertNull(mergeLists.next.next.next.next);
  }
}
