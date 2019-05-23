package tests;

import interview_questions.strings.SuperReducedString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuperReduceStringTest {
  @Test
  public void testSuperReducedString() {
    assertEquals("acdqgacdqj", SuperReducedString.reduce("acdqglrfkqyuqfjkxyqvnrtysfrzrmzlygfveulqfpdbhlqdqrrqdqlhbdpfqluevfgylzmrzrfsytrnvqyxkjfquyqkfrlacdqj"));
  }
}
