package interview_questions.numbers;

public class ReverseNumber {
  /*
  Reverse a number.

  Example:
    Input: 123
    Output: 321
   */

  public static long reverseNumber(long number) {
    if (number == 0) {
      return 0;
    }

    long reverse = 0;

    while (number != 0) {
      reverse = (reverse * 10) + (number % 10);
      number = number / 10;
    }

    return reverse;
  }
}
