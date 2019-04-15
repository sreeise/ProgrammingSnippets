package interview_questions.arrays;

import java.util.HashMap;

public class SparseArrays {
  // Complete the matchingStrings function below.
  public static int[] matchingStrings(String[] array, String[] queries) {
    int[] count = new int[queries.length];
    HashMap<String, Integer> map = findAll(array);

    for (int i = 0; i < queries.length; i++) {
      count[i] = map.getOrDefault(queries[i], 0);
    }

    return count;
  }

  private static HashMap<String, Integer> findAll(String[] array) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String arr : array) {
      if (!map.containsKey(arr)) {
        map.put(arr, 1);
      } else {
        map.put(arr, map.get(arr) + 1);
      }
    }
    return map;
  }
}
