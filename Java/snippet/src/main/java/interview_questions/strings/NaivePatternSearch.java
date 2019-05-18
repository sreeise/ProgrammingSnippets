package interview_questions.strings;

import java.util.ArrayList;
import java.util.List;

// Source code adapted from https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
public class NaivePatternSearch {
  public static List<Integer> search(String txt, String pat) {
    int m = pat.length();
    int n = txt.length();
    List<Integer> patterns = new ArrayList<>();

    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (txt.charAt(i + j) != pat.charAt(j)) {
          break;
        }
      }

      if (j == m) {
        patterns.add(i);
      }
    }

    return patterns;
  }
}
