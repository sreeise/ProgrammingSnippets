package interview_questions.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GenerateSubArrays {
  // Given an array of integers, return all possible
  // sub arrays with no repeating arrays.

  public static Set<int[]> subArray(int[] array) {
    Set<int[]> set = new HashSet<>();
    int n = array.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int[] t = new int[j + 1];
        int count = 0;
        for (int k = i; k <= j; k++) {
          t[count] = array[k];
          count++;
        }
        set.add(t);
      }
    }
    return set;
  }

  // Sub array using generics
  public static <T> Set<ArrayList<T>> subArray2(T[] array) {
    Set<ArrayList<T>> set = new HashSet<>();
    int n = array.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        ArrayList<T> list = new ArrayList<>();
        for (int k = i; k <= j; k++) {
          list.add(array[k]);
        }
        set.add(list);
      }
    }
    return set;
  }
}
