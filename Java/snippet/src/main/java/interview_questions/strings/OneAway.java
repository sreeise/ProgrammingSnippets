package interview_questions.strings;

// Reference: https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_05_One_Away

public class OneAway {
  /*
  There are three types of edits that can be performed on strings: insert a character,
  remove a character, or replace a character. Given two strings, write a function to check if they are
  one edit (or zero edits) away
   */
  public static boolean oneEditAway(String first, String second) {
    if (first.length() == second.length()) {
      return oneEditReplace(first, second);
    } else if (first.length() + 1 == second.length()) {
      return oneEditInsert(first, second);
    } else if (first.length() - 1 == second.length()) {
      return oneEditInsert(first, second);
    }

    return false;
  }

  // Check if the string, s2, is one edit away from being equal
  // to the string, s1. In other words, if changing only one
  // character in s2 will make it equal to s1 than return true
  // else return false.
  private static boolean oneEditReplace(String s1, String s2) {
    boolean diff = false;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (diff) {
          return false;
        }
        diff = true;
      }
    }

    return true;
  }

  private static boolean oneEditInsert(String s1, String s2) {
    int index1 = 0;
    int index2 = 0;

    while (index1 < s1.length() && index2 < s2.length()) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (index1 != index2) {
          return false;
        }
        index2++;
      } else {
        index1++;
        index2++;
      }
    }
    return true;
  }

  public static boolean oneEditAway2(String first, String second) {
    if (Math.abs(first.length() - second.length()) > 1) {
      return false;
    }

    String s1 = first.length() < second.length() ? first : second;
    String s2 = first.length() < second.length() ? second : first;

    int index1 = 0;
    int index2 = 0;
    boolean diff = false;

    while (index1 < s1.length() && index2 < s2.length()) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (diff) {
          return false;
        }
        diff = true;
        if (s1.length() == s2.length()) {
          index1++;
        }
      } else {
        index1++;
      }
      index2++;
    }

    return true;
  }
}
