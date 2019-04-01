package data_structures.graphs.graph;

import java.util.Iterator;

public class GraphNode<T> implements Iterable<T> {
  private Node<T> first;
  private int n;

  public GraphNode() {
    first = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void add(T item) {
    Node<T> old = first;
    first = new Node<>();
    first.item = item;
    first.next = old;
    n++;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator(first);
  }

  // helper linked list class
  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  private class ListIterator implements Iterator<T> {
    private Node<T> current;

    public ListIterator(Node<T> first) {
      current = first;
    }

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public T next() {
      if (!hasNext()) {
        throw new UnsupportedOperationException();
      }

      T item = current.item;
      current = current.next;
      return item;
    }
  }
}
