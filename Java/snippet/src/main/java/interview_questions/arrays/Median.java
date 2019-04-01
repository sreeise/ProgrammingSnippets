package interview_questions.arrays;

import java.util.Arrays;

public class Median {
  /*
  Find the median in an unsorted array in O(N log N) time.
   */

  public static double find(int[] arr, int n) {
    Arrays.sort(arr);

    if (n % 2 != 0) {
      return (double) arr[n / 2];
    }

    return (double) (arr[(n - 1) / 2] + arr[n / 2]) / 2.0;
  }
}
