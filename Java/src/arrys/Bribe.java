package arrys;

public class Bribe {
  // 1. Queue is least to greatest
  // 2. Bribes move number 1 position to the left

  /**
   * Return the minimum number of moves it would take for an
   * array of integers that if sorted would be in sequential order
   * with no numbers skipped.
   *
   * Example: [1, 2, 3, 5, 4, 6] -> [1, 2, 3, 4, 5, 6]
   *
   * @param q Array of integers
   * @param minimum A minimum amount of moves that one number can make
   * @return -1 if a number moves more then the minimum amount else return
   *          the total amount of moves made for all numbers or in other
   *          words the total amount of bribes all numbers made.
   */
  public static int minimumBribes(int[] q, int minimum) {
    int count = 0;
    for (int i = q.length - 1; i >= 0; i--) {
      // If the total moves made by one number is greater
      // then integer minimum then return -1.
      if (q[i] - (i + 1) > minimum) {
        return -1;
      }

      // Count the number of moves made incrementing count.
      for (int t = Math.max(0, q[i] - 2); t < i; t++) {
        if (q[t] > q[i]) {
          count++;
        }
      }
    }
    return count;
  }
}
