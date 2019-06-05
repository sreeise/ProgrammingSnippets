package interview_questions.strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
  /*
  Generate all permutations of the characters in a string.
  What if needed only distinct permutations?
   */

  public static List<String> permutations(String str) {
    List<String> list = new ArrayList<>();

    if (str.length() == 1) {
      list.add(str);
    } else {
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        String sub = str.substring(0, i) + str.substring(i + 1);

        list.add(c + sub);
        list.add(sub + c);
      }
    }

    return list;
  }

  public static List<String> distinctPermutations(String str) {
    List<String> list = new ArrayList<>();

    if (str.length() == 1) {
      list.add(str);
    } else {
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        String sub = str.substring(0, i) + str.substring(i + 1);

        if (!list.contains(c + sub)) {
          list.add(c + sub);
        }

        if (!list.contains(sub + c)) {
          list.add(sub + c);
        }
      }
    }

    return list;
  }
}
