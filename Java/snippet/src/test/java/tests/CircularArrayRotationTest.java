package tests;

import interview_questions.arrays.CircularArrayRotation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircularArrayRotationTest {
  @Test
  public void circularArrayRotationTest() {
   int[] a = {3, 4, 5};
   int k = 2;
   int[] queries = {1, 2};
   int[] rotatedQueries = CircularArrayRotation.circularArrayRotation(a, k, queries);
   assertEquals(rotatedQueries[0], 5);
   assertEquals(rotatedQueries[1], 3);
  }
}
