package interview_questions.tries;

import java.util.List;

public class TrieNode {
  public int val;
  public List<TrieNode> children;

  public TrieNode() {
  }

  public TrieNode(int _val, List<TrieNode> _children) {
    val = _val;
    children = _children;
  }
}
