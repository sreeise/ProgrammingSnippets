package interview_questions.arrays;

import java.util.*;

public class GenerateSubArrays {
  // Given an array of integers, return all possible
  // contiguous sub arrays with no repeating arrays.

  public static Set<int[]> subArray(int[] array) {
    Set<int[]> set = new HashSet<>();
    int n = array.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int[] t = new int[Math.abs(j - i) + 1];
        int count = 0;
        for (int k = i; k <= j; k++) {
          t[count] = array[k];
          count++;
        }

        Arrays.sort(t);
        if (set.stream().noneMatch(a -> Arrays.equals(a, t))) {
          set.add(t);
        }
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

  // Generate contiguous subarray chunks equal in length to k.
  public static Set<int[]> chunks(int[] array, int k) {
    Set<int[]> set = new HashSet<>();
    for(int i = 0; i < array.length; i += k){
      final int[] arr =  Arrays.copyOfRange(array, i, Math.min(array.length, i + k));
      boolean noneMatch = set.stream().noneMatch(a -> Arrays.equals(a, arr));
      if (noneMatch && arr.length == k) {
        set.add(arr);
      }
    }
    return set;
  }
}
