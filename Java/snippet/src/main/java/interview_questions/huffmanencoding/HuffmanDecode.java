package interview_questions.huffmanencoding;

import data_structures.huffman.HuffmanNode;

import java.util.NoSuchElementException;

public class HuffmanDecode {
  public static void decode(String s, HuffmanNode root) {
    StringBuilder builder = new StringBuilder();
    HuffmanNode node = root;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        node = node.right;
        if (isLeaf(node)) {
          builder.append(node.data);
          node = root;
        }
      } else if (s.charAt(i) == '0') {
        node = node.left;
        if (isLeaf(node)) {
          builder.append(node.data);
          node = root;
        }
      } else {
        throw new NoSuchElementException("String must only have 0 or 1");
      }
    }

    System.out.println(builder.toString());
  }

  public static boolean isLeaf(HuffmanNode node) {
    return node.left == null && node.right == null;
  }
}
