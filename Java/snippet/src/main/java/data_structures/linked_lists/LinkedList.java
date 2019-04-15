package data_structures.linked_lists;

import data_structures.NodeItem;

import java.util.ArrayList;
import java.util.HashSet;

/*
Another definition for a linked list:

  A linked list is a recursive data structure that is either empty (null) or a reference
  to a node having a generic item and a reference to a linked list.
    - Robert Sedgewick & Kevin Wayne in Algorithms 4th Edition


 Operations:

    Insert: public void enqueue(Node node) (or push())
      1. Create a temporary Node setting the node to the root node.
      2. Create a new Node to represent the node being inserted.
      3. Set the new Nodes data to the value given as an argument.
      4. Set the new Node to the root Node.
      5. Set the new Nodes next Node to the original root stored in the temporary variable.
      6. Increment the linked lists size or length instance variable.

    Remove: public void pop()

 */

/**
 * A linked list is a linear data structure where each element is a separate object. Linked list
 * elements are not stored at contiguous location; the elements are linked using pointers.
 *
 * @param <T>
 */
public class LinkedList<T> {
  private NodeItem<T> head;
  private int size;

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
    NodeItem<T> newNode = new NodeItem<>(data);
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
    NodeItem<T> ref = this.head;
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

  boolean hasCycle() {
    if (head == null) {
      return false;
    }

    HashSet<Integer> hashSet = new HashSet<>();
    NodeItem<T> tail = head;
    while (tail != null) {
      if (hashSet.contains(System.identityHashCode(tail))) {
        return true;
      }

      hashSet.add(System.identityHashCode(tail));
      tail = tail.next;
    }

    return false;
  }

  public boolean contains(T data) {
    if (head == null) {
      return false;
    }

    NodeItem<T> tail = head;
    while (tail != null) {
      if (tail.data == data) {
        return true;
      }

      tail = tail.next;
    }

    return false;
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
    NodeItem<T> current = this.head;
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
    NodeItem<T> current = this.head;
    ArrayList<T> list = new ArrayList<>();
    while (current != null) {
      list.add(current.data);
      current = current.next;
    }
    return list;
  }
}
