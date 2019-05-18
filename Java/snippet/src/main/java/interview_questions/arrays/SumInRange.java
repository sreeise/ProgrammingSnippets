package interview_questions.arrays;

public class SumInRange {
  public static int sumInRange(int[] nums, int[][] queries) {
    int mod = (int) 1e9 + 7;
    int[] s = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      s[i + 1] = s[i] + nums[i];
    }

    long rs = 0;
    for (int[] query : queries) {
      rs += s[query[1] + 1] - s[query[0]];
      rs = (rs + mod) % mod;
    }
    return (int) ((rs + mod) % mod);
  }
}
