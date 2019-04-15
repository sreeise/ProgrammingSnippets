package data_structures.bags;

import data_structures.NodeItem;

import java.util.Iterator;

/*
A bag is a collection where removing items is not supported—its purpose is to provide clients
with the ability to collect items and then to iterate through the collected items (the client
can also test if a bag is empty and find its number of items).
 */
public class Bag<T> implements Iterable<T> {
  private NodeItem<T> first;

  public void add(T item) {
    NodeItem<T> original = first;
    first = new NodeItem<>(item);
    first.next = original;
  }

  public Iterator<T> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<T> {
    private NodeItem<T> current = first;

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {}

    public T next() {
      T item = current.data;
      current = current.next;
      return item;
    }
  }
}
