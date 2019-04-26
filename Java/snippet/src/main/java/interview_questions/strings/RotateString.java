package interview_questions.strings;

import java.math.BigInteger;
import java.util.Arrays;

public class RotateString {
  /*
  We are given two strings, A and B.

  A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
  For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if
  A can become B after some number of shifts on A.
 */

  public static boolean rotateString(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    } else if (s1.equals(s2)) {
      return true;
    }

    String tempA = s1;

    for (int i = 0; i < s1.length(); i++) {
      String[] a1 = s1.split("");
      a1 = copy(a1);
      s1 = String.join("", a1);

      if (s1.equals(s2)) {
        return true;
      } else if (s1.equals(tempA)) {
        return false;
      }
    }

    return false;
  }

  public static String[] copy(String[] array) {
    String[] arr = new String[array.length];
    System.arraycopy(array, 1, arr, 0, arr.length -1);
    arr[array.length -1] = array[0];
    return arr;
  }

  // Solution 2
  public boolean rotateString2(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
  }

  public boolean rotateString3(String A, String B) {
    if (A.equals(B)) return true;

    int MOD = 1_000_000_007;
    int P = 113;
    int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

    long hb = 0, power = 1;
    for (char x: B.toCharArray()) {
      hb = (hb + power * x) % MOD;
      power = power * P % MOD;
    }

    long ha = 0; power = 1;
    char[] ca = A.toCharArray();
    for (char x: ca) {
      ha = (ha + power * x) % MOD;
      power = power * P % MOD;
    }

    for (int i = 0; i < ca.length; ++i) {
      char x = ca[i];
      ha += power * x - x;
      ha %= MOD;
      ha *= Pinv;
      ha %= MOD;
      if (ha == hb && (A.substring(i+1) + A.substring(0, i+1)).equals(B))
        return true;

    }
    return false;
  }

  // Time complexity: O(N)
  // Space complexity: O(N)
  public boolean rotateString4(String A, String B) {
    int lengthA = A.length();

    if (lengthA != B.length()) {
      return false;
    }

    if (lengthA == 0) {
      return true;
    }

    int[] shifts = new int[lengthA + 1];
    Arrays.fill(shifts, 1);

    int left = -1;
    for (int right = 0; right < lengthA; ++right) {
      while (left >= 0 && (B.charAt(left) != B.charAt(right))) {
        left -= shifts[left];
      }

      shifts[right + 1] = right - left++;
    }

    int matchLen = 0;
    for (char c: (A+A).toCharArray()) {
      while (matchLen >= 0 && B.charAt(matchLen) != c) {
        matchLen -= shifts[matchLen];
      }

      if (++matchLen == lengthA) {
        return true;
      }
    }

    return false;
  }
}
