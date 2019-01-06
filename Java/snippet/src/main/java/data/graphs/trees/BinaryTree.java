package data.graphs.trees;

/*
Binary Search Tree: All left descendants < N < All right descendents

Types of Binary Trees:

  1. Complete Binary Tree: Every level of hte tree is fully filled, except for possibly the last,
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

  1. In-Order Traversal: Visit the left branch, then the current node, and finally the right branch.
    Visits the nodes in ascending order.

  2. Pre-Order Traversal: Visit the current node before its child nodes. The root node is always the
    first node visited.

  3. Post-Order Traversal: Visit the current node after its child nodes. The root node is always the
    last node visited.
*/

public class BinaryTree {

}
