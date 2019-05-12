package interview_questions.arrays;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
  /*
  Consider an array of integers, arr = arr[0], arr[1],..., arr[n-1].  We define the absolute
  difference between two elements, a[i] and a[j] (where i != j), to be the absolute value of
  a[i] - a[j].

  Given an array of integers, find and print the minimum absolute difference between any two
  elements in the array.

  Keep in mind that the question is asking the minimum ABSOLUTE difference, so although the
  difference between two numbers could be the smallest, their absolute difference could be
  larger.
   */

  // The faster solution here is to sort the array first. When the array is sorted,
  // we know that we only have to find the absolute difference between adjacent
  // numbers. This cuts down on the number of calculations needed to find the
  // minimum absolute difference.
  // Starting out, set the variable for the running smallest number to the
  // absolute difference between the first number in the array minus the last
  // number in the array.
  public static int minimumAbsoluteDifference(int[] arr) {
    Arrays.sort(arr);
    int smallest = Math.abs(arr[0] - arr[arr.length -1]);

    for (int i = 0; i < arr.length; i++) {
      if (i + 1 < arr.length) {
        int current = Math.abs(arr[i + 1] - arr[i]);
        if (smallest > current) {
          smallest = current;
        }
      }
    }

    return smallest;
  }

  // Brute force approach. Iterate through each element in the
  // array and for each number find the absolute difference between
  // that number and the rest of the numbers in the array.
  static int minimumAbsoluteDifferenceSlower(int[] arr) {
    int smallest = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int current = Math.abs(arr[i] - arr[j]);
        if (i == 0) {
          smallest = current;
        } else if (smallest > current) {
          smallest = current;
        }
      }
    }

    return smallest;
  }
}
