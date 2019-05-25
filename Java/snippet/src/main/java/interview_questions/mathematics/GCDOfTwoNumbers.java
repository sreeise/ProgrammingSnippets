package interview_questions.mathematics;

public class GCDOfTwoNumbers {
  /*
  Find the greatest common divisor (GCD) of two numbers.
   */
  public static int gcd(int a, int b) {
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
