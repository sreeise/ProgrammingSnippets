package interview_questions.strings;

import java.util.Arrays;

public class Anagram {
  /*
  Write a function to check if two Strings are anagrams.
  Anagrams are a word, phrase, or name formed by rearranging the
  the letters of another.
   */
  public static boolean isAnagram(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    char[] chars = word1.toCharArray();
    char[] chars1 = word2.toCharArray();
    Arrays.sort(chars);
    Arrays.sort(chars1);
    String s1 = String.valueOf(chars);
    String s2 = String.valueOf(chars1);
    return s1.equals(s2);
  }

  public static boolean isAnagram2(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    String[] w1 = word1.split("");
    String[] w2 = word2.split("");
    Arrays.sort(w1);
    Arrays.sort(w2);
    String sorted1 = String.join("", w1);
    String sorted2 = String.join("", w2);

    return sorted1.equals(sorted2);
  }
}
