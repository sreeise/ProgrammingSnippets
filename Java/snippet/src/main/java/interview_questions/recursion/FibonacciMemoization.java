package interview_questions.recursion;

import java.util.HashMap;

public class FibonacciMemoization {
  /*
  This uses a memoization technique to store previously
  computed values reducing the running time of a
  simple fibonacci algorithm which is badly exponential.
 */
  static HashMap<Integer, Long> map = new HashMap<>();
  static {
    map.put(0, 1L);
    map.put(1, 1L);
  }

  public static long fibonacci(int n) {
    if (map.containsKey(n)) {
      return map.get(n);
    } else {
      long ans = fibonacci(n - 1) + fibonacci(n - 2);
      System.out.println(ans);
      map.put(n, ans);
      return ans;
    }
  }
}
