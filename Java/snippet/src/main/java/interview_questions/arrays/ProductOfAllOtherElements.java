package interview_questions.arrays;

import java.util.Arrays;

public class ProductOfAllOtherElements {
  /*
  Given an array of integers, return a new array such that each element at
  index i of the new array is the product of all the numbers in the original
  array except the one at i.
   */

  // Sum of all elements excluding array[i] using base 10 logarithms
  // and a precision number.
  private static final double PRECISION = 1e-9;

  // Time complexity: O(N)
  // Space Complexity: O(N)
  public static int[] product(int[] arr) {
    // Create array to store the products.
    int[] result = new int[arr.length];
    // Initialize all integers in array to 1
    Arrays.fill(result, 1);

    // Calculate all elements on the left side excluding array[i]
    int temp = 1;
    for (int i = 0; i < arr.length; i++) {
      result[i] = temp;
      temp *= arr[i];
    }

    // Reset temp to 1 for numbers on right side of array;
    temp = 1;

    // Calculate all elements on the right side excluding array[i]
    for (int i = arr.length - 1; i >= 0; i--) {
      result[i] *= temp;
      temp *= arr[i];
    }

    return result;
  }

  public static int[] product2(int[] array) {
    double sum = 0;

    // Sum of all the elements base 10 logarithm in the array.
    for (int i = 0; i < array.length; i++) {
      sum += Math.log10(array[i]);
    }

    int[] result = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = (int) (PRECISION + Math.pow(10, sum - Math.log10(array[i])));
    }
    return result;
  }
}
