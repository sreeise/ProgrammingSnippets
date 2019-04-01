package tests;

import interview_questions.strings.PrefixSubstring;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrefixStringTest {
  @Test
  public void prefixStringTest() {
    assertTrue(PrefixSubstring.prefixAgain("abXYabc", 1));
    assertTrue(PrefixSubstring.prefixAgain("abXYabc", 2));
    assertFalse(PrefixSubstring.prefixAgain("abXYabc", 3));
  }
}
