package interview_questions.strings;

public class SamAndSubstrings {
  /*
  Samantha and Sam are playing a numbers game. Given a number as a string, no leading zeros,
  determine the sum of all integer values of substrings of the string. For example, if the
  string is 42, the substrings are 4, 2 and 42. Their sum is 48. Given an integer as a string, sum all
  of its substrings cast as integers. As the number may become large, return the value modulo 10^9 + 7.

  A brute force approach would be to generate all possible substrings of a string. For large strings
  the runtime will be very large. According to HackerRank, the runtime of this brute force approach
  would be len(N) * (len(N) + 1) / 2

  Instead of the brute force approach, a dynamic programming approach can be used to solve the problem
  in linear time with respect to the given number.

  Taking the sum modulo 10^9 + 7 prevents integer overflows.
   */

  // The modulo value to use: 10^9 + 7.
  private static int MOD = 1000000007;

  public static int substrings(String s) {
    // Total sum.
    long sum = (long) s.charAt(0) - '0';

    // Temp sum which stores the sum of all substrings ending at index i.
    long temp = (long) s.charAt(0) - '0';

    for (int i = 1; i < s.length(); i++) {
      temp = temp * 10 + (i + 1) * (s.charAt(i) - '0');
      temp = temp % MOD;
      sum = (sum + temp) % MOD;
    }

    return (int) sum;
  }
}
