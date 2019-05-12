package tests;

import interview_questions.arrays.MinimumAbsoluteDifference;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumAbsoluteDifferenceTest {
  @Test
  public void minimumAbsoluteDifferenceTest() {
    assertEquals(2, MinimumAbsoluteDifference.minimumAbsoluteDifference(new int[]{-2, 2, 4}));
    assertEquals(3, MinimumAbsoluteDifference.minimumAbsoluteDifference(new int[]{3, -7, 0}));
  }
}
