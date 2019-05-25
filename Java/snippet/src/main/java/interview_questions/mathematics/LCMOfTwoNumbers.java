package interview_questions.mathematics;

public class LCMOfTwoNumbers {
  /*
  Find the least common multiple (LCD) of two numbers.
   */
  public static int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
  }

  private static int gcd(int a, int b) {
    while (a > 0 && b > 0) {
      if (a >= b) {
        a = a % b;
      } else {
        b = b % a;
      }
    }

    return a + b;
  }
}
