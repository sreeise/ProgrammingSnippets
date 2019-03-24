package data_structures.linked_lists;

/**
 * A linked list is a linear data structure where each element is a separate object. Linked list
 * elements are not stored at contiguous location; the elements are linked using pointers.
 *
 * A double linked list consists of nodes that store pointers to the previous and next nodes in the list.
 *
 * @param <T>
 */
public class DoubleLinkedList<T> {
  private ListNode head;
  private int size;

  /**
   * A ListNode represents a Node in a DoubleLinkedList, storing a Node T (any type) and a pointer
   * to the next and previous node in a DoubleLinkedList.
   *
   * <p>Because all classes in Java are references we can use classes to the data as pointers.
   */
  class ListNode {
    T data;
    ListNode next;
    ListNode prev;

    ListNode(T data) {
      this.data = data;
    }
  }

  /**
   * DoublyLinkedList constructor.
   */
  public DoubleLinkedList() {}

  /**
   * Creates a new Node consisting of the data given and adds
   * the node to the linked list.
   * @param data Any - the type that the DoubleLinkedList was instantiated with.
   */
  public void add(T data) {
    if (this.head == null) {
      head = new ListNode(data);
      this.size = 1;
    } else {
      ListNode temp = new ListNode(data);
      temp.next = this.head;
      this.head.prev = temp;
      this.head = temp;
      this.size += 1;
    }
  }

  /**
   *
   * @return Int Remove the first node in the linked list and return the nodes data.
   * @throws NullPointerException If the linked list is empty.
   */
  public T pop() {
    ListNode temp = head;
    head = head.next;
    this.size -= 1;
    return temp.data;
  }

  /**
   * @return int the number of nodes in the linked list.
   */
  public int size() {
    return this.size;
  }

  /**
   * @return boolean True if the list is empty else false.
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  public void print() {
    ListNode ref = this.head;
    while (ref != null) {
      System.out.println(ref.data);
      ref = ref.next;
    }
  }
}
