package sort.mergesort;

public class InPlaceMergeSort {
  public static void sort(Comparable[] array, Comparable[] temp, int low, int high) {
    if (high <= low) {
      return;
    }

    int mid = low + (high - low) / 2;
    sort(array, temp, low, mid);
    sort(array, temp, mid + 1, high);
    merge(array, temp, low, mid, high);
  }

  public static void sort(Comparable[] array) {
    Comparable[] temp = new Comparable[array.length];
    sort(array, temp, 0, array.length - 1);
  }

  public static void merge(Comparable[] array, Comparable[] temp, int low, int mid, int high) {
    // Copy the array over to a temp array.
    for (int k = low; k <= high; k++) {
      temp[k] = array[k];
    }

    int i = low;
    int j = mid + 1;

    // Copy the temp array back to the original array
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        array[k] = temp[j++];
      } else if (j > high) {
        array[k] = temp[i++];
      } else if (less(temp[j], temp[i])) {
        array[k] = temp[j++];
      } else {
        array[k] = temp[i++];
      }
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }
}
