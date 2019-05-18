package interview_questions.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PairDifference {
  /*
  You will be given an array of integers and a target value. Determine the number of pairs of array
  elements that have a difference equal to a target value.

  For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting
  the condition: 2 - 1 = 1, 3 - 2 = 1, and 4 - 3 = 1.

  All of the elements of the given array are unique.
   */

  // O(N)
  public static int pairs(int k, int[] array) {
    int count = 0;
    Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());
    for (int i : array) {
      if (set.contains(i - k)) {
        count++;
      }
    }

    return count;
  }
}
