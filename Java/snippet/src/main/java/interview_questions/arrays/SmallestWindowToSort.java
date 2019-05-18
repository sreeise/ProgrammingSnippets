package interview_questions.arrays;

public class SmallestWindowToSort {
  /*
  Given an array of integers that are out of order, determine the bound of the smallest
  window that must be sorted in order for the entire array to be sorted. For example,
  given [3, 5, 7, 6, 9], you should return (1, 3).
   */

  private static int left;
  private static int right;

  // Time complexity: O(N)
  // Space complexity: O(1)
  public static int[] window(int[] array) {
    // We set the minimum and maximum seen values
    // to to smallest and largest possible Integer values
    // in order to ensure Math.min and Math.max returns
    // the smallest and largest values when checking against
    // the current value in the array while looping.
    int max_seen = Integer.MIN_VALUE;
    int min_seen = Integer.MAX_VALUE;

    // Loop through the array.
    for (int i = 0; i < array.length; i++) {
      // Get the greatest current value since iteration started.
      max_seen = Math.max(max_seen, array[i]);

      // If the current value is less than then current maximum value seen
      // set the right bound to the index of the current value.
      if (array[i] < max_seen) {
        right = i;
      }
    }

    // Loop through the array in reverse.
    for (int i = array.length - 1; i >= 0; i--) {
      // Get the smallest current value since iteration started.
      min_seen = Math.min(min_seen, array[i]);

      // If the current value is greater than the current minimum value seen
      // set the right bound to the index of the current value.
      if (array[i] > min_seen) {
        left = i;
      }
    }

    // Return the left and right bounds.
    return new int[]{left, right};
  }

}
