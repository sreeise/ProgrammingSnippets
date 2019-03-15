package data_structures.linked_lists;

import data_structures.NodeItem;

class LinkedListGenerics<T> {
  NodeItem<T> head;

  public LinkedListGenerics() {
    head = null;
  }

  public boolean isEmpty() {
    return (head == null);
  }

  public void insertFront(T item) {
    NodeItem<T> nodeItem = new NodeItem<>(item);
    nodeItem.next = head;
    head = nodeItem;
  }

  public NodeItem<T> deleteFront() {
    NodeItem<T> item = head;
    head = head.next;
    return item;

  }

  public void displayList() {
    System.out.print("List (head-->last): ");
    NodeItem<T> current = head; // start at beginning of list
    while (current != null) // until end of list,
    {
      System.out.println(current); // print data_structures
      current = current.next; // move to next link
    }
    System.out.println("");
  }
}
