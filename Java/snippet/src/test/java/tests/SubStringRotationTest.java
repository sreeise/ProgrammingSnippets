package tests;

import interview_questions.strings.SubstringRotation;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubStringRotationTest {
  @Test
  public void subStringRotationTrue() {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";
    assertTrue(SubstringRotation.isRotation(s1, s2));
  }

  @Test
  public void subStringRotationFalse() {
    String s1 = "waterbottle";
    String s2 = "arbottlewat";
    assertFalse(SubstringRotation.isRotation(s1, s2));
  }
}
