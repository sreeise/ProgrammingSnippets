package sort;

// Time complexity worst case: O(N log N)^2
// Space complexity worst case: 0(1)
public class ShellSort {
  public static void sort(Comparable[] a) {
    int n = a.length;
    int h = 1;

    while (h < n / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && compare(a[j], a[j - h]); j -= h) {
          swap(a, j, j - h);
        }
      }
      // Divide by 3 and store the result in h.
      h /= 3;
    }
  }

  private static boolean compare(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void swap(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) if (compare(a[i], a[i - 1])) return false;
    return true;
  }

  private static boolean isHsorted(Comparable[] a, int h) {
    for (int i = h; i < a.length; i++) if (compare(a[i], a[i - h])) return false;
    return true;
  }
}
