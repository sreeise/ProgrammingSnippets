package data_structures.linked_lists;

/**
 * Node class for LinkedList data_structures structures.
 */
public class ListNode {
  private int id; // data_structures item (key)
  private double nodeData; // data_structures item
  public ListNode next; // next link in list

  public ListNode(int id, double nodeData) {
    this.id = id; // initialize data_structures
    this.nodeData = nodeData; // 'next' is automatically set to null
  }

  public void displayLink() {
    System.out.print("{" + this.id + ", " + this.nodeData + "} ");
  }
}
