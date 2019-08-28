package tests;

import org.junit.Test;
import sort.LeastSignificantDigit;

import static org.junit.Assert.assertArrayEquals;

public class LeastSignificantDigitTest {
  private static String[] a = {
        "4PGC938", "2IYE230", "3CIO720", "1ICK750", "4JZY524", "1ICK750",
        "3CIO720", "1OHV845", "1OHV845", "2RLA629", "2RLA629", "3ATW723",
  };

  private static String[] answer = {
        "1ICK750", "1ICK750", "1OHV845", "1OHV845", "2IYE230", "2RLA629",
        "2RLA629", "3ATW723", "3CIO720", "3CIO720", "4JZY524", "4PGC938"
  };

  @Test
  public void leastSignificantDigitTest() {
    LeastSignificantDigit.sort(a, 7);
    assertArrayEquals(answer, a);
  }
}
