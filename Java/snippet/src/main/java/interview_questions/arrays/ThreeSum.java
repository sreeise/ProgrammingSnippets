package interview_questions.arrays;

import java.util.Arrays;

public class ThreeSum {
  /*
  Given an array of integers, count the number of pairs of Integers
  that sum to 0.
   */

  // This is a slow irritative solution to three sum.
  // Time complexity: O(3N)
  public static int count(int[] array) {
    int length = array.length;
    int count = 0;

    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        for (int k = j + 1; k < length; k++) {
          if (array[i] + array[j] + array[k] == 0) {
            count++;
          }
        }
      }
    }

    return count;
  }

  public static int count2(int[] a) { // Count triples that sum to 0.
    Arrays.sort(a);
    int length = a.length;
    int count = 0;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (rank(-a[i] - a[j], a) > j) {
          count++;
        }
      }
    }

    return count;
  }

  // An adaption of binary sort.
  public static int rank(int key, int[] a) {
    return rank(key, a, 0, a.length - 1);
  }

  public static int rank(int key, int[] array, int low, int high) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (key < array[mid]) high = mid - 1;
      else if (key > array[mid]) low = mid + 1;
      else return mid;
    }
    return 0;
  }
}
