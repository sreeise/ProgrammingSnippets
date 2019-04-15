package data_structures.graphs.tries;
/*
A trie is a variant of an n-ary tree in which characters are stored at each node.
Each path down the three may represetn a word.
Source: Cracking the coding interview by Gayle Laakmann Mcdowell

n-ary: The concept of n-ary group (also called n-group or multiary group) is a generalization
of hte concept of group to a set G with n-ary operation instead of a binary operation.
Source: https://en.wikipedia.org/wiki/N-ary_group
 */

/*
This is a version of a Trie data structure adapted to allow any alphabet size.
Source: https://www.geeksforgeeks.org/trie-insert-and-search/


The following information on Trie's is from leetcode.com: https://leetcode.com/explore/learn/card/n-ary-tree

TRAVERSAL:

Source: https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/916/

A binary tree can be traversed in preorder, inorder, postorder or level-order.
Among these traversal methods, preorder, postorder and level-order traversal are
suitable to be extended to an N-ary tree.

1. Preorder Traversal

In an N-ary tree, preorder means visit the root node first and then traverse the subtree rooted at
its children one by one. For instance, the preorder of the 3-ary tree above is: A->B->C->E->F->D->G.

2. Postorder Traversal

In an N-ary tree, postorder means traverse the subtree rooted at its children first and then visit the root
node itself. For instance, the postorder of the 3-ary tree above is: B->E->F->C->G->D->A.

3. Level-order Traversal

Level-order traversal in an N-ary tree is the same with a binary tree. Typically, when we do
 breadth-first search in a tree, we will traverse the tree in level order. For instance,
 the level-order of the 3-ary tree above is: A->B->C->D->E->F->G.
*/

public class Trie {
  private TrieNode root;

  public Trie(int ALPHABET_SIZE) {
    this.root = new TrieNode(ALPHABET_SIZE);
  }

  public TrieNode getRoot() {
    return this.root;
  }

  public void insert(String key) {
    int level;
    int length = key.length();
    int index;

    TrieNode node = root;

    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode(26);
      }

      node = node.children[index];
    }

    node.isEndOfWord = true;
  }

  public boolean search(String key) {
    int level;
    int length = key.length();
    int index;
    TrieNode node = root;

    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';

      if (node.children[index] == null) {
        return false;
      }

      node = node.children[index];
    }

    return node != null && node.isEndOfWord;
  }
}
