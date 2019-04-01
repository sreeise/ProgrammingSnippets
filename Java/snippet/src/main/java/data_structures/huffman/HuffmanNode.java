package data_structures.huffman;

public class HuffmanNode {
  public int frequency;
  public char data;
  public HuffmanNode left;
  public HuffmanNode right;

  public HuffmanNode(int frequency, char data) {
    this.frequency = frequency;
    this.data = data;
  }
}
