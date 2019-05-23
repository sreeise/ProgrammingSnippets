package tests;

import interview_questions.strings.MinimumNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumNumberTest {
  @Test
  public void testMinimumNumber() {
    assertEquals(1, MinimumNumber.minimumNumber("AUzs-nV"));
    assertEquals(3, MinimumNumber.minimumNumber("Ab1"));
  }
}
