package interview_questions.strings;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {
  /*
  Two strings are anagrams of each other if the letters of one string can be rearranged
  to form the other string. Given a string, find the number of pairs of substrings of
  the string that are anagrams of each other.
   */
  public static int sherlockAndAnagrams(String s) {
    HashMap<String, Integer> map = new HashMap<>();
    int count = 0;

    for(int i = 0 ; i < s.length(); i++) {
      for(int j= i + 1; j <= s.length(); j++) {
        String sub = s.substring(i,j);
        sub = sort(sub);

        if(map.containsKey(sub)) {
          int value = map.get(sub);
          count += value;

          map.put(sub,  value + 1);
        } else {
          map.put(sub, 1);
        }
      }
    }

    return count;
  }

  private static String sort(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}
