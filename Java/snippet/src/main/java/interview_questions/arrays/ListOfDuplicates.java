package interview_questions.arrays;

import java.util.HashMap;
import java.util.Map;

public class ListOfDuplicates {

  /*
    Given an array of strings, return a Map<String, Boolean> where each different string is a key and
    its value is true if a string appears 2 or more times in the array.

    wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
    wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
    wordMultiple(["c", "c", "c", "c"]) → {"c": true}
  */

  // Faster approach
  public static Map<String, Boolean> wordMultiple(String[] strings) {
    Map<String, Boolean> map = new HashMap();
    for (String s : strings) {
      if (!map.containsKey(s)) {
        map.put(s, false);
      } else if (!map.get(s)) {
        map.put(s, true);
      }
    }
    return map;
  }

  // slower approach
  public static Map<String, Boolean> wordMultiple2(String[] strings) {
    Map<String, Boolean> map = new HashMap<>();
    Map<String, Integer> freq = new HashMap<>();

    for (String s : strings) {
      if (!freq.containsKey(s)) {
        freq.put(s, 0);
      } else {
        freq.put(s, freq.get(s) + 1);
      }
    }

    for (String s : strings) {
      int value = freq.get(s);
      if (value > 0) {
        map.put(s, true);
      } else {
        map.put(s, false);
      }
    }

    return map;
  }
}
