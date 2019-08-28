package sort;

// LSD String sort - Least Significant Digit First String Sort.

import java.util.Arrays;

// LSD Sort uses Key-Indexed counting to sort a string. LSD sort is useful
// for Strings that have a fixed length of characters such as phone numbers
// and IP Addresses.

// The following is from Algorithms 4th Edition by Robert Sedgewick and Kevin Wayne
public class LeastSignificantDigit {
  public static void sort(String[] a, int W) {
    int N = a.length;
    int R = 256;
    String[] aux = new String[N];

    for (int d = W - 1; d >= 0; d--) {
      int[] count = new int[R + 1];

      // Get the frequency counts of each character in the array.
      for (int i = 0; i < N; i++) {
        count[a[i].charAt(d) + 1]++;
      }

      // Transform the counts to indices.
      for (int r = 0; r < R; r++) {
        count[r + 1] += count[r];
      }

      // Distribute.
      for (int i = 0; i < N; i++) {
        aux[count[a[i].charAt(d)]++] = a[i];
      }

      for (int i = 0; i < N; i++) {
        a[i] = aux[i];
      }
    }
  }
}
