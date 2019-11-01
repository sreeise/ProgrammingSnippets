package tests;

import interview_questions.numbers.ReverseNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseNumberTest {

  @Test
  public void reverseNumberTest() {
    assertEquals(0, ReverseNumber.reverseNumber(0));

    long number = 1234;
    long numberAns = 4321;
    assertEquals(numberAns, ReverseNumber.reverseNumber(number));

    long number1 = -1234;
    long number1Ans = -4321;
    assertEquals(number1Ans, ReverseNumber.reverseNumber(number1));

    long number2 = 11112111;
    long number2Ans = 11121111;
    assertEquals(number2Ans, ReverseNumber.reverseNumber(number2));

    long number3 = -11112111;
    long number3Ans = -11121111;
    assertEquals(number3Ans, ReverseNumber.reverseNumber(number3));
  }
}
