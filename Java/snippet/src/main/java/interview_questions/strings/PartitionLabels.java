package interview_questions.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
  /*
  A string S of lowercase letters is given. We want to partition this string into as
  many parts as possible so that each letter appears in at most one part, and return
  a list of integers representing the size of these parts.

  Example:
  S = "ababcbacadefegdehijhklij"
  The partition is "ababcbaca", "defegde", "hijhklij".
   */

  public static int[] lastIndex(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); i++) {
      last[s.charAt(i) - 'a'] = i;
    }

    return last;
  }

  public static List<Integer> partition(String S) {
    int[] last = lastIndex(S);

    int j = 0, anchor = 0;
    ArrayList<Integer> list = new ArrayList();
    for (int i = 0; i < S.length(); i++) {
      j = Math.max(j, last[S.charAt(i) - 'a']);

      if (i == j) {
        list.add(i - anchor + 1);
        anchor = i + 1;
      }
    }

    return list;
  }


  public static List<Integer> partition2(String s) {
    // Get the last index for each character a - z
    int[] last = lastIndex(s);

    int boundary = 0;
    int count = 0;
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      boundary = Math.max(boundary, last[current - 'a']);
      count++;

      if (i == boundary) {
        list.add(count);
        count = 0;
      }
    }

    return list;
  }

}
