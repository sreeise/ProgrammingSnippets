package tests;

import interview_questions.strings.Anagram;
import interview_questions.strings.MakeAnagrams;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
  @Test
  public void anagramTest() {
    assertTrue(Anagram.isAnagram("cinema", "iceman"));
    assertFalse(Anagram.isAnagram("cinem", "iceman"));
    assertFalse(Anagram.isAnagram("cinema", "icaman"));
    assertFalse(Anagram.isAnagram("Elbow", "Below"));
    assertTrue(Anagram.isAnagram("elbow", "below"));

    assertTrue(Anagram.isAnagram2("cinema", "iceman"));
    assertFalse(Anagram.isAnagram2("cinem", "iceman"));
    assertFalse(Anagram.isAnagram2("cinema", "icaman"));
    assertFalse(Anagram.isAnagram2("Elbow", "Below"));
    assertTrue(Anagram.isAnagram2("elbow", "below"));
  }

  @Test
  public void makeAnagramTest() {
    assertEquals(4, MakeAnagrams.makeAnagram("cde", "abc"));
    assertEquals(30, MakeAnagrams.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
  }
}
