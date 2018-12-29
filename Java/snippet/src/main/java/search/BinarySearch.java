package search;

/*
Binary Search Algorithm

Requirements:
  1. Array must be sorted

Algorithm:
  1. Given a number N, look for N in the array
  2.  Compare N to the midpoint of th array.
      2.a If N is greater than the midpoint then search the right half of the array
      2.b If N is less then the midpoint then search the left half of the array
  3. Repeat process until N is found or the subarray has size 0
 */

// Basic Binary Search
public class BinarySearch {
  public static int find(int[] array, int n) {
    // Start of array
    int low = 0;
    // End of array
    int high = array.length;
    // Used to get midpoint of array
    int mid;

    // Continue searching a specific half of the array
    // until the number is found or there are no array
    // elements left.
    while (low <= high) {
      // Get the middle of the array
      mid = (low + high) / 2;

      // Search half of the array repeatedly until
      // the number is found or not more elements are left.
      if (array[mid] < n) {
        low = mid + 1;
      } else if (array[mid] > n) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    // Number not found
    return -1;
  }

  // Recursive Binary Search
  public static int recursiveFind(int[] a, int x, int low, int high) {
    if (low > high) {
      return -1;
    }
]\
    int mid = (low + high) / 2;
    if (a[mid] < x) {
      return recursiveFind(a, x, mid + 1, high);
    } else if (a[mid] > x) {
      return recursiveFind(a, x, low, mid -1);
    } else {
      return mid;
    }
  }
}
