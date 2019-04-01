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

    // This assumes that the two words are still anagrams regardless
    // of casing.
    word1 = word1.toLowerCase();
    word2 = word2.toLowerCase();

    String[] w1 = word1.split("");
    String[] w2 = word2.split("");
    Arrays.sort(w1);
    Arrays.sort(w2);
    String sorted1 = String.join("", w1);
    String sorted2 = String.join("", w2);

    return sorted1.equals(sorted2);
  }
}
