package tests;

import interview_questions.strings.Compression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCompressionTest {
  @Test
  public void stringCompressionTest() {
    String compAns = "a2b1c5a3b5";
    String testCase = "aabcccccaaabbbbb";
    assertEquals(Compression.compress(testCase), compAns);
    assertEquals(Compression.compressString(testCase), compAns);
  }

  @Test
  public void stringCompressionTest2() {
    String compAns = "z3A2a1b3C2";
    String testCase = "zzzAAabbbCC";
    assertEquals(Compression.compress(testCase), compAns);
    assertEquals(Compression.compressString(testCase), compAns);
  }

  @Test
  public void stringCompressionDiff() {
    // The two methods, compress and compressString, differ
    // when it comes to strings that have no repeating characters.
    // The compressString method always returns a new string with
    // the count in these cases while the compress method does not.
    String compAns1 = "abc";
    String compAns2 = "a1b1c1";
    String testCase = "abc";
    assertEquals(Compression.compress(testCase), compAns1);
    assertEquals(Compression.compressString(testCase), compAns2);
  }
}
