package search;

import java.util.Arrays;

public class SubSequence {
  private static String sortString(String input) {
    char[] array = input.toCharArray();
    Arrays.sort(array);
    return new String(array);
  }

  public static String find(String[] words, String input) {
    int wordIndex = 0;
    int longestIndex = 0;
    int length = 0;
    for (String word : words) {
      if (input.equals(word)) {
        if (length == 0) {
          length = word.length() - 1;
          longestIndex = wordIndex;
        } else if (word.length() - 1 > length) {
          length = word.length() - 1;
          longestIndex = wordIndex;
        }
      }
      wordIndex++;
    }
    System.out.println(wordIndex);
    return words[longestIndex];
  }
}
