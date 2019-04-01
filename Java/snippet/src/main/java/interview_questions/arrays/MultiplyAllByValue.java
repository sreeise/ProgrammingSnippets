package interview_questions.arrays;

import java.util.List;

public class MultiplyAllByValue {
  /*
  Given a list of integers, return a list where each integer is multiplied by a given number.

  If the given number is 2 then the following lists change as shown:
  doubling([1, 2, 3]) → [2, 4, 6]
  doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
  doubling([]) → []
  */

  public static List<Integer> doubling(List<Integer> nums, int multiplier) {
    nums.replaceAll(n -> n * multiplier);
    return nums;
  }
}
