package data_structures.huffman;

import java.util.Comparator;

public class HuffmanComparator implements Comparator<HuffmanNode> {
  @Override
  public int compare(HuffmanNode node1, HuffmanNode node2) {
    return node1.data - node2.data;
  }
}
