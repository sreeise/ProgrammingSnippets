package interview_questions.strings;
/*
Given a string, consider the prefix string made of the first N chars of the string. Does that
prefix string appear somewhere else in the string? Assume that the string is not empty and that
N is in the range 1..str.length().

prefixAgain("abXYabc", 1) → true
prefixAgain("abXYabc", 2) → true
prefixAgain("abXYabc", 3) → false
 */
public class PrefixSubstring {
  public static boolean prefixAgain(String str, int n) {
    if (str.length() <= 1) {
      return false;
    } else if (str.length() == 2 && str.charAt(0) == str.charAt(1)) {
      return true;
    }
    String prefix = str.substring(0, n);
    String after = str.substring(n, str.length() - 1);

    return after.contains(prefix);
  }
}
