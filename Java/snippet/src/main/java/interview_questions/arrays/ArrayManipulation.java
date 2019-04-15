package interview_questions.arrays;

import java.util.Arrays;

public class ArrayManipulation {
  /*
  Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to
  each of the array element between two given indices, inclusive. Once all operations have been performed,
  return the maximum value in your array.
  */
  public static long arrayManipulation(int n, int[][] queries) {
    long[] arr = new long[n];
    Arrays.fill(arr, 0);

    for (int[] query : queries) {
      int lower = query[0];
      int upper = query[1];
      long sum = query[2];
      arr[lower - 1] += sum;

      if (upper < n) {
        arr[upper] -= sum;
      }
    }

    long max = 0;
    long temp = 0;

    for (int i = 0; i < n; i++) {
      temp += arr[i];
      if (temp > max) {
        max = temp;
      }
    }

    return max;
  }
}
