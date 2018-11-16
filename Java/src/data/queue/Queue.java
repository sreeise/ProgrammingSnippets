package data.queue;

import java.util.NoSuchElementException;

// Queues are first in first out (FIFO) data structures.
public class Queue<T> {
  /**
   * Node class for a Queue
   * @param <T>
   */
  private static class QNode<T> {
    private T data;
    private QNode<T> next;

    QNode(T data) {
      this.data = data;
    }
  }

  private QNode<T> first;
  private QNode<T> last;

  /**
   * Add an item onto the end of the Queue
   * @param T item
   */
  public void add(T item) {
    QNode<T> t = new QNode<>(item);
    if (last != null) {
      last.next = t;
    }

    last = t;
    if (first == null) {
      first = last;
    }
  }

  /**
   * Remove an iem from the end of a Queue
   * @return T - Removed item
   */
  public T remove() {
    if (first == null) {
      throw new NoSuchElementException();
    }

    T data = first.data;
    first = first.next;

    if (first == null) {
      last = null;
    }
    return data;
  }

  public T peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }

    return first.data;
  }

  /**
   * Check if the Queue is empty;
   * @return Boolean - True if queue is empty else false
   */
  public boolean isEmpty() {
    return first == null;
  }
}
