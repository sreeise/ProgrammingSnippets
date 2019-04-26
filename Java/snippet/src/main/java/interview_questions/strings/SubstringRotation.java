package interview_questions.strings;

public class SubstringRotation {
  /*
  Assume you have a method isSubstring which checks if one word is a
  substring of another. Given two strings, s1 and s2, write code to check
  if s2 is a rotation of s1 using only one call to is substring.
   */

  public static boolean isSubstring(String s1, String s2) {
    int length = s1.length();

    if (length == s2.length() && length > 0) {
      String s1s1 = s1 + s1;
      return isSubstring(s1s1, s2);
    }

    return false;
  }
}
