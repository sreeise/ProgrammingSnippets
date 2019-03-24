package interview_questions.linked_lists;

public class DoublyLinkedListSortedInsert {
  public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    DoublyLinkedListNode node = new DoublyLinkedListNode(data);

    if (head == null) {
      return node;
    } else if (data < head.data) {
      node.next = head;
      head.prev = node;
      return node;
    } else {
      DoublyLinkedListNode n = sortedInsert(head.next, data);
      head.next = n;
      n.prev = head;
      return head;
    }
  }
}
