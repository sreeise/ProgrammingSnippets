package data_structures.graphs.trees;

/*
Binary Tree: A tree whose elements have at most 2 children is called a binary tree. Since each element in
             a binary tree can have only 2 children, we typically name them the left and right child.

Binary Search Tree: Is a binary tree where all left descendants < N < All right descendents - See class BinarySearchTree

Types of Binary Trees:

  1. Complete Binary Tree: Every level of the tree is fully filled, except for possibly the last,
    is completely filled, and all nodes are as far left as possible

  2. Full Binary Tree: Every node has either zero or two children. That is, no nodes have only one child.

  3. Perfect Binary Tree: Both full and complete. All leaf nodes will be at the same level, and this
    level has the maximum number of nodes. Perfect trees are always 2^k - 1.

Binary Heaps:

    Min-Heap: Complete binary tree where each node is smaller then it's children. The root node
    is the minimum element in the tree.

      1. Min-Heap Inserting: Start by inserting the element at the bottom. Insert at the rightmost spot so as to
        maintain the complete tree property. Then, swap the new element with its parent, until
        the the appropriate spot for the element is found.

        Min-Heap Inserts Time Complexity: O(log n) where n is the number of nodes in the heap.

      2. Getting the minimum element: The minimum element is always at the top.

        Remove the minimum element and swap it wit h the last element in the heap (the bottom most,
        right most element). Then bubble down this element, swapping it with one of its children until
        the min-heap property is restored.

Binary Tree Traversal:

  Depth first traversal methods:

  1. In-Order Traversal: Visit the left branch, then the current node, and finally the right branch.
    Visits the nodes in ascending order.
      1. Traverse the left subtree and recursively call inOrder(node.left)
      2. Visit the root
      3. Traverse the right subtree and recursively call inOrder(node.right)

  2. Pre-Order Traversal: Visit the current node before its child nodes. The root node is always the
    first node visited.
      1. Visit the root
      2. Traverse the left subtree and recursively call preOrder(root.left).
      3. Traverse the right subtree and recursively call preOrder(root.right).

  3. Post-Order Traversal: Visit the current node after its child nodes. The root node is always the
    last node visited.
      1. Traverse the left subtree and recursively call postOrder(root.left)
      2. Traverse the right subtree and recursively call postOrder(root.right)
      3. Visit the root


  Breadth first traversal methods:

  1. Breadth first traversal or level order

Other Notes:
   It is a basic combinatorial property of binary trees that a tree of height h has no more
   than 2h leaves — the tree of height h with the maximum number of leaves is perfectly balanced, or complete.
   - Robert Sedgewick and Kevin Wayne in Algorithms 4th Edition
*/

/*
In a binary search tree, all nodes on the left branch of a node are less than the node value.
All values on the right branch are greater than the node value.
 */

import data_structures.queue.Queue;

public class BinaryTree {
  public BinaryTreeNode root;

  public BinaryTree(int data) {
    root = new BinaryTreeNode(data);
  }

  public BinaryTree() {
    root = null;
  }

  /**
   * Pre-order traversal takes the following steps:
   *
   * <p>1. Visit the root 2. Traverse the left subtree and recursively call preOrder(root.left) 3.
   * Traverse the right subtree and recursively call preOrder(root.right)
   *
   * <p>One each call the algorithm will first visit the left node and then the right. When it
   * reaches a null for a subtree, we return to the current subtrees parent and follow the next
   * child node.
   *
   * @param node BinaryTreeNode
   */
  public void printPreOrder(BinaryTreeNode node) {
    if (node == null) {
      return;
    }

    System.out.println(node.data + " ");
    printPreOrder(node.left);
    printPreOrder(node.right);
  }

  /**
   * A recursive wrapper around printPreOrder(BinaryTreeNode) that uses the BinaryTrees root node
   * instead of one passed to the first printPreOrder method.
   */
  public void printPreOrder() {
    printPreOrder(this.root);
  }

  /**
   * Post-order traversal takes the following steps:
   *
   * <p>1. Traverse the left subtree and recursively call postOrder(root.left) 2. Traverse the right
   * subtree and recursively call postOrder(root.right) 3. Visit the root
   *
   * <p>One each call the algorithm will first visit the left node and then the right. When it
   * reaches a null for a subtree, we return to the current subtrees parent and follow the next
   * child node.
   *
   * @param node BinaryTreeNode
   */
  public void printPostOrder(BinaryTreeNode node) {
    if (node == null) {
      return;
    }

    printPostOrder(node.left);
    printPostOrder(node.right);
    System.out.println(node.data + " ");
  }

  /**
   * A recursive wrapper around printPostOrder(BinaryTreeNode) that uses the BinaryTrees root node
   * instead of one passed to the first printPostOrder method.
   */
  public void printPostOrder() {
    printPostOrder(this.root);
  }

  /**
   * Inorder traversal takes the following steps:
   *
   * <p>1. Traverse the left subtree and recursively call inOrder(node.left) 2. Visit the root 3.
   * Traverse the right subtree and recursively call inOrder(node.right)
   *
   * @param node BinaryTreeNode
   */
  public void printInOrder(BinaryTreeNode node) {
    if (node == null) {
      return;
    }

    printInOrder(node.left);
    System.out.println(node.data + " ");
    printInOrder(node.right);
  }

  /**
   * A recursive wrapper around printInOrder(BinaryTreeNode) that uses the BinaryTrees root node
   * instead of one passed to the first printInOrder method.
   */
  public void printInOrder() {
    printInOrder(this.root);
  }

  /**
   * Level order traversal of a tree is breadth first traversal for the tree.
   *
   * @param BinaryTreeNode node
   */
  public void printLevelOrder(BinaryTreeNode root) {
    int height = height(root);
    for (int i = 1; i <= height; i++) {
      printGivenLevel(root, i);
    }
  }

  private void printGivenLevel(BinaryTreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (level == 1) {
      System.out.print(root.data + " ");
    } else if (level > 1) {
      printGivenLevel(root.left, level - 1);
      printGivenLevel(root.right, level - 1);
    }
  }

  /**
   * A recursive wrapper around printLevelOrder(BinaryTreeNode) that uses the BinaryTrees root node
   * instead of one passed to the first printLevelOrder method.
   */
  public void printLevelOrder() {
    printLevelOrder(this.root);
  }

  private int height(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftHeight = height(root.left);
      int rightHeight = height(root.right);

      if (leftHeight > rightHeight) {
        return leftHeight + 1;
      } else {
        return rightHeight + 1;
      }
    }
  }

  /**
   * Same as level order traversal because it traverses all the nodes
   * at each level before going to the next level.
   * @param node BinaryTreeNode
   */
  public static void printBreadthFirstTraversal(BinaryTreeNode node) {
    Queue<BinaryTreeNode> queue = new Queue<>();
    queue.enqueue(node);
    while (!queue.isEmpty()) {

      BinaryTreeNode root = queue.dequeue();
      System.out.print(root.data + " ");

      if (root.left != null) {
        queue.enqueue(root.left);
      }

      if (root.right != null) {
        queue.enqueue(root.right);
      }
    }
  }
}
