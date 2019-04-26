package tests;

import interview_questions.strings.SherlockAndAnagrams;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SherlockAndAnagramTest {

  @Test
  public void sherlockAnagramTest() {
    assertEquals(3, SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq"));
    assertEquals(10, SherlockAndAnagrams.sherlockAndAnagrams("kkkk"));
  }
}
