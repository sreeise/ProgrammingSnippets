package interview_questions.arrays;

import java.util.Arrays;

public class ArraySubset {
  /*
  Find whether an array is subset of another array.
   */
  public static <T> boolean isSubset(T[] arr, T[] arr2) {
    if (arr2.length > arr.length) {
      return false;
    }

    // Sort the array to use binary search.
    Arrays.sort(arr);

    for (int i = 0; i < arr2.length; i++) {
      int search = Arrays.binarySearch(arr, arr2[i]);
      if (search == -1) {
        return false;
      }
    }

    return true;
  }
}
