package interview_questions.arrays;

public class DivisibleSumPairs {
  /*
  You are given an array of n integers, array = [array[0], array[1], ... , array[n -1], and
  a positive integer, k. Find and print the number of pairs (i, j) where i < j and
  array[i] + array[j] is divisible by k.

  For example, array = [1, 2, 3, 4, 5, 6] and k = 5. Our three pairs meeting the criteria
  are [1, 4], [2, 3], and [4, 6].
   */

  static int divisibleSumPairsBruteForce(int n, int k, int[] array) {
    int count = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if ((array[i] + array[j]) % k == 0 && j < i) {
          count++;
        }
      }
    }

    return count;
  }

  public static int divisibleSumPairsEfficient(int n, int k, int[] ar) {
    int[] freq = new int[n];
    for (int i = 0; i < n; i++) {
      ++freq[ar[i] % k];
    }

    int sum = freq[0] * (freq[0] - 1) / 2;
    for (int i = 1; i <= k / 2 && i != (k - i); i++) {
      sum += freq[i] * freq[k - i];
    }

    if (k % 2 == 0) {
      sum += (freq[k / 2] * (freq[k / 2] - 1) / 2);
    }

    return sum;
  }
}
