package data_structures.graphs.trees;

/**
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:
 *
 * <p>The left subtree of a node contains only nodes with keys lesser than the node’s key. The right
 * subtree of a node contains only nodes with keys greater than the node’s key. The left and right
 * subtree each must also be a binary search tree. There must be no duplicate nodes.
 */
public class BinarySearchTree {
  private BinaryTreeNode root;

  public BinarySearchTree() {
    root = null;
  }

  /**
   * Insert a new BinarySearchTree
   *
   * <p>Inserting a new Node will take the following steps: 1. If the root Node is null a. Create a
   * new Node with the given data b. Set root to the new Node and return the root. 2. Else a. If the
   * given data for a new node is less then the root data then, using a helper insert method
   * insertNode, recursively call insertNode(root.left, data) where data is the data for a new node.
   * The original insert method will set the root node by calling: root = insertNode(root, data). b.
   * Else if the given data for a new node is greater then the root data then, using a helper insert
   * method insertNode, recursively call insertNode(root.right, data) where data is the data for a
   * new node. The original insert method will set the root node by calling: root = insertNode(root,
   * data). 3. In the insertNode method, return the node. the original insert method will set the
   * root node to the returned node from insertNode.
   *
   * @param data The data for a new BinaryTreeNode
   */
  public void insert(int data) {
    this.root = insertNode(root, data);
  }

  /**
   * Helper method to traverse the BinarySearchTree and insert a new BinaryTreeNode
   *
   * @param root The root Node of a BinarySearchTree
   * @param data The data for a new BinaryTreeNode
   * @return The new BinaryTreeNode
   */
  private BinaryTreeNode insertNode(BinaryTreeNode root, int data) {
    if (root == null) {
      root = new BinaryTreeNode(data);
      return root;
    }

    if (data < root.data) {
      root.left = insertNode(root.left, data);
    } else if (data > root.data) {
      root.right = insertNode(root.right, data);
    }

    return root;
  }

  public BinaryTreeNode search(BinaryTreeNode root, int data) {
    if (root == null || root.data == data) {
      return root;
    }

    if (root.data > data) {
      return search(root.left, data);
    }

    return search(root.right, data);
  }

  public BinaryTreeNode search(int data) {
    return search(this.root, data);
  }
}
