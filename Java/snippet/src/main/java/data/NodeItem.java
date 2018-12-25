package data;

// Node Class for data structures
public class NodeItem<T> {
  public T data;
  public NodeItem<T> next;

  public NodeItem(T data) {
    this.data = data;
  }
}
