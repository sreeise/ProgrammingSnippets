package interview_questions.greedy;

import java.util.Arrays;

public class Candies {
  /*
  Alice is a kindergarten teacher. She wants to give some candies to the
  children in her class.  All the children sit in a line and each of them
  has a rating score according to his or her performance in the class.
  Alice wants to give at least 1 candy to each child. If two children sit
  next to each other, then the one with the higher rating must get more candies.
  Alice wants to minimize the total number of candies she must buy.

  This question can be solved by taking a greedy approach. Specifically, given
  an array, arr, of ratings:
  if arr[i - 1] >= arr[i] && arr[i] <= arr[i + 1], we call it a valley.
  if arr[i - 1] < arr[i] && arr[i] <= arr[i + 1], we call it a rise.
  if arr[i - 1] >= arr[i] && arr[i] > arr[i + 1], we call it a fall.
  if arr[i -1] < arr[i] && arr[i] > arr[i + 1], we call it a peak.

  To evenly distribute the candies:
  For each valley, give the child 1 candy
  For each rise, give the child candies[i - 1] + 1 candies.
  For each fall, give the child candies[i + 1] + 1 candies.
  For each peak, give the child max(candies[i - 1], candies[i + 1]) + 1 candies.

  For the leftmost and rightmost child, assume they each have a neighbor with an
  infinite rating, so they can also be classified according to this scheme.

  Also note that the leftmost child cannot be a rise or a peak, and the rightmost
  child cannot be a fall or a peak.

  In order for this to work the order of distribution must be:
  Distribute the candies to the valleys.
  Distribute the candies to the rises from left to right.
  Distribute the candies to the falls from right to left.
  Distribute the candies to the peaks.
   */

  public static long candies(int n, int[] a) {
    int[] candies = new int[n + 1];
    int[] arr = new int[n + 2];
    arr[0] = Integer.MAX_VALUE;
    arr[arr.length -1] = Integer.MAX_VALUE;
    System.arraycopy(a, 0, arr, 1, a.length);

    for (int i = 1; i <= a.length; i++) {
      if (arr[i - 1] >= arr[i] && arr[i] <= arr[i + 1]) {
        candies[i] += 1;
      }
    }

    for (int i = 1; i < a.length + 1; i++) {
      if (arr[i - 1] < arr[i] && arr[i] <= arr[i + 1]) {
        candies[i] += candies[i - 1] + 1;
      }
    }

    for (int i = a.length; i >= 1; i--) {
      if (arr[i - 1] >= arr[i] && arr[i] > arr[i + 1]) {
        candies[i] += candies[i + 1] + 1;
      }
    }

    for (int i = 1; i < a.length + 1; i++) {
      if (arr[i -1] < arr[i] && arr[i] > arr[i + 1]) {
        candies[i] = Math.max(candies[i - 1], candies[i + 1]) + 1;
      }
    }

    return Arrays.stream(candies).mapToLong(i -> i).sum();
  }
}
