package interview_questions.strings;

public class SuperReducedString {
  /*
  Steve has a string of lowercase characters in range ascii[‘a’..’z’]. He wants to reduce the string
  to its shortest length by doing a series of operations. In each operation he selects a pair of adjacent
  lowercase letters that match, and he deletes them. For instance, the string aab could be shortened to
  b in one operation.

  Steve’s task is to delete as many characters as possible using this method and print the resulting string.
  If the final string is empty, print Empty String
   */

  public static String reduce(String s) {
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        s = s.substring(0, i - 1) + s.substring(i + 1);
        i = 0;
      }
    }
    if (s.length() == 0) {
      return "Empty String";
    }

    return s;
  }
}
