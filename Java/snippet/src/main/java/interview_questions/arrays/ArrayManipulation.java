package interview_questions.arrays;

import java.util.Arrays;

public class ArrayManipulation {
  /*
  Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to
  each of the array element between two given indices, inclusive. Once all operations have been performed,
  return the maximum value in your array.

  For example, the length of your array of zeros n = 10. Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1

  Add the values of k between the indices a and b inclusive:

  index->	 1 2 3  4  5 6 7 8 9 10
	        [0,0,0, 0, 0,0,0,0,0, 0]
	        [3,3,3, 3, 3,0,0,0,0, 0]
	        [3,3,3,10,10,7,7,7,0, 0]
	        [3,3,3,10,10,8,8,8,1, 0]

  The largest value is 10 after all operations are performed.
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
      //  yi = yi − 1 + xi
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
