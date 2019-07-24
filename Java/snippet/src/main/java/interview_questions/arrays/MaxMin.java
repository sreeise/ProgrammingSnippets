package interview_questions.arrays;

import java.util.Arrays;

public class MaxMin {
  /*
  You will be given a list of integers, arr, and a single integer k.
  You must create an array of length from elements of such that its unfairness is minimized.
  Call that array subarr. Unfairness of an array is calculated as:

    max(subarr) - min(subarr)

  Where:
    - max denotes the largest integer in subarr.
    - min denotes the smallest integer in subarr.
   */

  public static int maxMin(int k, int[] arr) {
    Arrays.sort(arr);
    int minimum = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - k + 1; i++) {
      int diff = arr[i + k - 1] - arr[i];
      if (diff < minimum) {
        minimum = diff;
      }
    }
    return minimum;
  }
}
