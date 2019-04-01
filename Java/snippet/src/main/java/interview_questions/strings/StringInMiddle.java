package interview_questions.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInMiddle {
  /*
    Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of
    chars to the left and right of the "xyz" must differ by at most one.

  xyzMiddle("AAxyzBB") → true
  xyzMiddle("AxyzBB") → true
  xyzMiddle("AxyzBBB") → false

   Edge cases: The string is equal to the substring
  The string has multiple occurrences of the substring placed throughout the string.
     */

  public static boolean find(String str, String substr) {
    if (!str.contains(substr)) {
      return false;
    } else if (str.length() == substr.length() + 1 || str.equals(substr)) {
      return true;
    }

    // Get a list of indexes for all occurrences of the substring.
    List<Integer> list = findAll(substr, str);
    for (Integer i : list) {
      if (i + substr.length() < str.length()) {
        // Get the substring before and after the current current substr.
        String front = str.substring(0, i);
        String back = str.substring(i + substr.length());
        // If the substring length difference is less then 1 then we found a match.
        if (Math.abs(front.length() - back.length()) < 2) {
          return true;
        }
      }
    }

    return false;
  }

  private static List<Integer> findAll(String substr, String str) {
    String pattern = Pattern.quote(substr);
    Matcher m = Pattern.compile(pattern).matcher(str);

    List<Integer> pos = new ArrayList<>();
    while (m.find()) {
      pos.add(m.start());
    }

    return pos;
  }
}
