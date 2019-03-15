package data_structures.linked_lists;

import data_structures.NodeItem;

public class SingleLinkedList {
  private ListNode head; // ref to head link on list

  public SingleLinkedList() {
    head = null; // no items on list yet
  }

  public boolean isEmpty() {
    return (head == null);
  }


  public void insertFirst(int id, double dd) {
    ListNode newLink = new ListNode(id, dd);
    newLink.next = head; // newLink --> old head
    head = newLink; // head --> newLink
  }

  public ListNode deleteFirst() {
    ListNode temp = head; // save reference to link
    head = head.next; // delete it: head-->old next
    return temp; // return deleted link
  }
}
