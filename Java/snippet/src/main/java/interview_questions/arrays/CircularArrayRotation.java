package interview_questions.arrays;

public class CircularArrayRotation {
  /*
  For each array, perform a number of right circular rotations and return the value of the
  element at a given index.

  For example, array a = [3, 4, 5], k = 2 number of rotations, and indices to check, queries = [1, 2].
  First we perform the two rotations:
    [3, 4, 5] -> [5, 4, 3] -> [4, 5, 3]
    a[1] = 5
    a[2] = 3
   */

  public static int[] circularArrayRotation(int[] a, int k, int[] queries) {
    int q = queries.length;
    int n = a.length;
    int[] nums = new int[q];

    for (int i = 0; i < q; i++) {
      nums[i] = a[(n - (k % n) + queries[i]) % n];
    }

    return nums;
  }
}
