package tests;

import interview_questions.strings.StringInMiddle;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringInMiddleTest {
  @Test
  public void stringInMiddleTest() {
    assertTrue(StringInMiddle.find("xyzxyzAxyzBxyzxyz", "xyz"));
    assertTrue(StringInMiddle.find("xyzAxyzBxyz", "xyz"));
    assertFalse(StringInMiddle.find("AxyzxyzBB", "xyz"));
    assertFalse(StringInMiddle.find("xyzxyzAxyzxyzxy", "xyz"));
    assertTrue(StringInMiddle.find("xyzxyzAxyzxyzxyz", "xyz"));
    assertTrue(StringInMiddle.find("xyzxyzxyzBxyzxyz", "xyz"));
    assertTrue(StringInMiddle.find("xyzz", "xyz"));
    assertTrue(StringInMiddle.find("xyz", "xyz"));
    assertFalse(StringInMiddle.find("xy", "xyz"));
    assertFalse(StringInMiddle.find("", "xyz"));
    assertFalse(StringInMiddle.find("AxyzBBBB", "xyz"));
  }
}
