package data.stack;

import data.NodeItem;
import java.util.NoSuchElementException;

// Stacks are last in first out (LIFO) data structures
public class Stack<T> {
  private NodeItem<T> top;

  /**
   * Remove the last item in the stack
   * @return T - Last item that was put in the stack
   */
  public T pop() {
    if (top == null) {
      throw new NoSuchElementException();
    }

    T item = top.data;
    top = top.next;
    return item;
  }

  /**
   * Adds item to end of stack
   * @param T Item
   */
  public void push(T item) {
    NodeItem<T> t = new NodeItem<T>(item);
    t.next = top;
    top = t;
  }

  /**
   * Look at the last item in the stack
   * @return T Item
   */
  public T peek() {
    if (top == null) {
      throw new NoSuchElementException();
    }

    return top.data;
  }

  /**
   * Check if stack is empty
   * @return Boolean - True if stack is empty else false
   */
  public boolean isEmpty() {
    return top == null;
  }
}
