package interview_questions.strings;

public class MakeAnagrams {
  /*
  Given two strings a, and b,that may or may not be of the same length, determine the minimum number of
  character deletions required to make and anagrams. Any characters can be deleted from either of the strings.
  */

  private static int LETTERS = 26;

  public static int makeAnagram(String a, String b) {
    return getDelta(getCharCounts(a), getCharCounts(b));
  }

  private static int[] getCharCounts(String s) {
    int[] charCounts = new int[LETTERS];
    for (int i = 0; i < s.length(); i++) {
      charCounts[s.charAt(i) - 'a']++;
    }

    return charCounts;
  }

  private static int getDelta(int[] array1, int[] array2) {
    if (array1.length != array2.length) {
      return -1;
    }

    int count = 0;
    for (int i = 0; i < array1.length; i++) {
      int diff = Math.abs(array1[i] - array2[i]);
      count += diff;
    }

    return count;
  }
}
