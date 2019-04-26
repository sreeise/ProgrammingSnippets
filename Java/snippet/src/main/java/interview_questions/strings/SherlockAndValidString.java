package interview_questions.strings;

import java.util.HashSet;

public class SherlockAndValidString {
  /*
  Sherlock considers a string to be valid if all characters of the string appear the same number
  of times. It is also valid if he can remove just character at index in the string, and the remaining
  characters will occur the same number of times. Given a string , determine if it is valid. If so,
  return YES, otherwise return NO.
   */

  static String isValid(String s) {
    int[] cnt = new int[26];
    int n = s.length();
    char[] s1 = s.toCharArray();

    for (int i = 0; i < n; i++) {
      cnt[s1[i] - 'a']++;
    }

    for (int i = -1; i < 26; i++) {
      if (i >= 0 && cnt[i] == 0) {
        continue;
      }

      if (i >= 0) {
        cnt[i]--;
      }

      HashSet<Integer> set = new HashSet<>();
      for (int j = 0; j < 26; j++) {
        if (cnt[j] != 0) {
          set.add(cnt[j]);
        }
      }

      if (set.size() == 1) {
        return "YES";
      }

      if (i >= 0) {
        cnt[i]++;
      }
    }

    return "NO";
  }
}
