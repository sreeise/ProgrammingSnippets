package interview_questions.arrays;

import java.util.Arrays;
import java.util.Collections;

// See these links for different solutions:
// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array
// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time

public class KSmallest {
  /*
  Given an array and a number k where k is smaller than size of array,
  find and print the k’th smallest element in the given array.

  The kth smallest element is the minimum possible n such that there are at least
  k elements in the array <= n.
   */
  public static void printSmallest(Integer[] arr, int k) {
    // Collections.reverseOrder will return the reverse of the
    // natural ordering of the elements.
    Arrays.sort(arr, Collections.reverseOrder());

    for (int i = 0; i < k; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  /*
  Find the kth smallest element using quick sort.
   */
  public int smallest(int[] arr, int l, int r, int k) {
    // If k is smaller than number of elements in array
    if (k > 0 && k <= r - l + 1) {
      // Partition the array around a random element and
      // get position of pivot element in sorted array
      int pos = randomPartition(arr, l, r);

      // If position is same as k
      if (pos - l == k - 1) return arr[pos];

      // If position is more, recur for left subarray
      if (pos - l > k - 1) return smallest(arr, l, pos - 1, k);

      // Else recur for right subarray
      return smallest(arr, pos + 1, r, k - pos + l - 1);
    }

    // If k is more than number of elements in array
    return Integer.MAX_VALUE;
  }

  // Utility method to swap arr[i] and arr[j]
  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Standard partition process of QuickSort().  It considers
  // the last element as pivot and moves all smaller element
  // to left of it and greater elements to right. This function
  // is used by randomPartition()
  private int partition(int[] arr, int l, int r) {
    int x = arr[r], i = l;
    for (int j = l; j <= r - 1; j++) {
      if (arr[j] <= x) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, r);
    return i;
  }

  // Picks a random pivot element between l and r and
  // partitions arr[l..r] arount the randomly picked
  // element using partition()
  private int randomPartition(int[] arr, int l, int r) {
    int n = r - l + 1;
    int pivot = (int) (Math.random()) * (n - 1);
    swap(arr, l + pivot, r);
    return partition(arr, l, r);
  }
}
