package interview_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  // Question: Given an array of integers, return indices of two numbers such that they
  // enqueue up to the specific target. Assume that each input has exactly one solution and you
  // cannot use the same element twice.

  // Brute force approach.
  // Time complexity: O(N^2)
  // Space complexity: O(1)
  public static int[] twoSumSolution1(int[] nums, int target) {
    for (int j = 0; j < nums.length; j++) {
      for (int i = 1; i < nums.length; i++) {
        if (target == (nums[i] + nums[j]) && i != j) {
          return new int[] {j, i};
        }
      }
    }
    return null;
  }

  // Time complexity: Worst case is O(N) if a collision occurs but the
  //                  lookups are normally O(1).
  // Space complexity: O(N)
  public static int[] twoSumSolution2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {i, map.get(complement)};
      }
    }
    return null;
  }

  // Time complexity: O(N).
  // Space Complexity: O(1).
  public static int[] twoSumSolution3(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  /*
   Another TwoSum question

  Given an array of integers, count the number of pairs of Integers
  that sum to 0.
   */

  // Running time: O(N log N)
  public static int count(int[] a) {
    Arrays.sort(a);
    int length = a.length;
    int count = 0;

    for (int i = 0; i < length; i++) {
      if (rank(-a[i], a) > i) {
        count++;
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
      if (key < array[mid]) {
        high = mid - 1;
      } else if (key > array[mid]) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return 0;
  }
}
