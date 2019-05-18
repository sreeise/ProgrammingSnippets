package data_structures.stack;

import java.util.Iterator;

// Generic Stack Implementation
// Stacks are last in first out (LIFO) data structures.
public class ArrayStack<Item> implements Iterable<Item> {
  private Item[] a = (Item[]) new Object[1];
  private int length = 0;

  public boolean isEmpty() {
    return length == 0;
  }

  public int size() {
    return length;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < length; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item) {
    if (length == a.length) {
      resize(2 * a.length);
    }
    a[length++] = item;
  }

  public Item pop() {
    Item item = a[--length];
    a[length] = null;
    if (length > 0 && length == a.length / 4) {
      resize(a.length / 2);
    }
    return item;
  }

  public void clear() {
    this.a = (Item[]) new Object[1];
    this.length = 0;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = length;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return a[--i];
    }

    public void remove() {
    }
  }
}
