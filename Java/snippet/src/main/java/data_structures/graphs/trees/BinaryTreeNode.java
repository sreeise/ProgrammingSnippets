package data_structures.graphs.trees;

public class BinaryTreeNode implements Comparable<BinaryTreeNode> {
  public int data;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  public BinaryTreeNode(int data) {
    this.data = data;
  }

  @Override
  public int compareTo(BinaryTreeNode node) {
    return Integer.compare(node.data, data);
  }
}
