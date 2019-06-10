package interview_questions.strings;

import java.util.Arrays;

public class Permutation {
  /*
  Given two strings, write a method to decide if one is a permutation of the other.

  If two strings are permutations of each other then we known that the have the
  same characters just in a different order.
   */

  // Sort a String.
  private static String sort(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

  // Simple but inefficient solution.
  public static boolean isPermutation(String s, String s1) {
    if (s.length() != s1.length()) {
      return false;
    }

    return sort(s).equals(sort(s1));
  }

  // Counts the number of times each character
  // appears in a string assuming the character
  // set is ASCII.
  private static int[] countCharacters(String s) {
    int[] letters = new int[128];

    char[] array = s.toCharArray();
    for (char c : array) {
      letters[c]++;
    }

    return letters;
  }

  // Efficient solution.
  // Psuedo code:
  // 1. If the length of the first string, s, is not equal
  //    to the length of the second string, s1, return false.
  // 2. Count the number of times each character appears in
  //    the first string, s, storing the counts in an array.
  // 3. For each character in the second string, s1, reduce
  //    the amount of times the character appeared in the first
  //    string using the array.
  // 4. If at any time the count of that character is
  //    is less than zero we know that the strings are not
  //    permutations so return false.
  // 5. Return true if no character count is less than zero.
  public static boolean isPermutation2(String s, String s1) {
    if (s.length() != s1.length()) {
      return false;
    }

    int[] letters = countCharacters(s);
    for (int i = 0; i < s1.length(); i++) {
      int c = (int) s1.charAt(i);
      letters[c]--;
      if (letters[c] < 0) {
        return false;
      }
    }

    return true;
  }
}
