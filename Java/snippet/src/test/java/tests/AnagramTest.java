package tests;

import interview_questions.strings.Anagram;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramTest {
  @Test
  public void anagramTest() {
    assertTrue(Anagram.isAnagram("cinema", "iceman"));
    assertFalse(Anagram.isAnagram("cinem", "iceman"));
    assertFalse(Anagram.isAnagram("cinema", "icaman"));
    assertTrue(Anagram.isAnagram("Elbow", "Below"));
    assertTrue(Anagram.isAnagram("Elbow", "below"));
  }
}
