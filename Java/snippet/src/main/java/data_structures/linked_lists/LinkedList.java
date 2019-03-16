package data_structures.linked_lists;

import java.util.ArrayList;

/**
 * A linked list is a linear data structure where each element is a separate object. Linked list
 * elements are not stored at contiguous location; the elements are linked using pointers.
 *
 * @param <T>
 */
public class LinkedList<T> {
  private ListNode head;
  private int size;

  /**
   * A ListNode represents a Node in a LinkedList, storing a Node T (any type) and a pointer to the
   * next Node in a LinkedList.
   *
   * <p>Because all classes in Java are references we can use classes to the data as pointers.
   */
  class ListNode {
    T data;
    ListNode next;

    ListNode(T data) {
      this.data = data;
    }
  }

  /** Create an empty LinkedList. */
  public LinkedList() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Add T to the front of the list where T: Any.
   *
   * @param T Any type.
   */
  public void add(T data) {
    ListNode newNode = new ListNode(data);
    // The new Node is equal to the old head.next.
    newNode.next = this.head;
    // The head is equal to the new Node.
    this.head = newNode;
    this.size += 1;
  }

  /**
   * Remove and return T at the front of the list where T: Any
   *
   * @return T Any type.
   */
  public T pop() {
    // Store a reference to the current head Node.
    ListNode ref = this.head;
    // Delete the current head Node by setting
    // head to the next Node in the list.
    this.head = head.next;
    // return the reference to the deleted Node.
    this.size -= 1;
    return ref.data;
  }

  /**
   * The LinkedList will always be empty if the head of the list is null.
   *
   * @return Boolean True if the list is empty, else false.
   */
  public boolean isEmpty() {
    return this.head == null;
  }

  /**
   * Return the length or total number of items in the list as an integer.
   *
   * @return Int representing the size of items in the list.
   */
  public int size() {
    return this.size;
  }

  /**
   * String version of list where each type in the list is appended to a String with a space in
   * between each element.
   *
   * <p>Note: This will not show elements who themselves have toString versions and may only be
   * useful for primitive types.
   *
   * @return String
   */
  @Override
  public String toString() {
    ListNode current = this.head;
    StringBuilder builder = new StringBuilder();
    while (current != null) {
      builder.append(current.data);
      current = current.next;
      if (current != null) {
        builder.append(" ");
      }
    }
    return builder.toString();
  }

  /** @return ArrayList of elements in the list. */
  public ArrayList<T> toArrayList() {
    ListNode current = this.head;
    ArrayList<T> list = new ArrayList<>();
    while (current != null) {
      list.add(current.data);
      current = current.next;
    }
    return list;
  }
}
