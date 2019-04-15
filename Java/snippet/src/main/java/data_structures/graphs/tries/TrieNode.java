package data_structures.graphs.tries;

/*
This is a version of a trie node adapted to allow changing the alphabet size.
Source: https://www.geeksforgeeks.org/trie-insert-and-search
 */
public class TrieNode {
  public TrieNode[] children;
  public boolean isEndOfWord;

  public TrieNode(int ALPHABET_SIZE) {
    this.isEndOfWord = false;
    children = new TrieNode[ALPHABET_SIZE];
    for (int i = 0; i < ALPHABET_SIZE; i++) {
      children[i] = null;
    }
  }
}
