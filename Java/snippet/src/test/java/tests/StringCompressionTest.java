package tests;

import interview_questions.strings.Compression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCompressionTest {

  @Test
  public void stringCompressionTest() {
    String compressed = Compression.compress("aabcccccaaabbbbb");
    assertEquals(compressed, "a2b1c5a3b5");

    String compressed2 = Compression.compress("zzzAAabbbCC");
    assertEquals(compressed2, "z3A2a1b3C2");
  }
}
