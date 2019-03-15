package data_structures;

// Node Class for data_structures structures
public class NodeItem<T> {
  public T data;
  public NodeItem<T> next;

  public NodeItem(T data) {
    this.data = data;
  }
}
