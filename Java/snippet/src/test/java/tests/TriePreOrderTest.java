package tests;

import interview_questions.tries.PreOrderTraversal;
import interview_questions.tries.TrieNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TriePreOrderTest {
  private static void addChild(TrieNode node, int val) {
    if (node.children == null) {
      node.children = new ArrayList<>();
    }

    TrieNode child = new TrieNode();
    child.val = val;
    node.children.add(child);
  }

  @Test
  public void triePreorderTraversalTest() {
    List<Integer> answers = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 2, 4));
    List<Integer> list = PreOrderTraversal.preorder(setup(answers));
    assertEquals(list, answers);
  }

  @Test
  public void triePreorderTraversalTest2() {
    List<Integer> answers = new ArrayList<>(Arrays.asList(1, 3, 4, 7, 2, 4));
    List<Integer> list = PreOrderTraversal.preorder(setup(answers));
    assertEquals(list, answers);
  }

  @Test
  public void triePreorderTraversalTest3() {
    List<Integer> answers = new ArrayList<>(Arrays.asList(1, 2, 8, 12, 100, 333));
    List<Integer> list = PreOrderTraversal.preorder(setup(answers));
    assertEquals(list, answers);
  }

  private TrieNode setup(List<Integer> values) {
    List<TrieNode> list = new ArrayList<>();
    TrieNode node1 = new TrieNode();
    node1.val = values.get(1);
    addChild(node1, values.get(2));
    addChild(node1, values.get(3));

    list.add(node1);
    TrieNode root = new TrieNode();
    root.val = values.get(0);
    root.children = list;
    addChild(root, values.get(4));
    addChild(root, values.get(5));
    return root;
  }
}
