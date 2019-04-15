package tests;

import data_structures.graphs.tries.Trie;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
  private static String[] keys = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

  private Trie setup() {
    Trie trie = new Trie(26);
    for (String key : keys) {
      trie.insert(key);
    }

    return trie;
  }

  @Test
  public void trieTest() {
    Trie trie = setup();

    for (String s : keys) {
      assertTrue(trie.search(s));
    }

    assertFalse(trie.search("these"));
    assertFalse(trie.search("thaw"));
  }
}
