package tests;

import interview_questions.TwoSum;
import org.junit.Test;
import static org.junit.Assert.*;

public class TwoSumTest {
  int[] testCase = new int[]{1, 4, 8, 23, 20, 3, 2, 10, 5, 25};

  @Test
  public void testBruteForce() {
    assertArrayEquals(TwoSum.twoSumSolution1(testCase, 30), new int[]{4, 7});
    assertArrayEquals(TwoSum.twoSumSolution1(testCase, 5), new int[]{0, 1});
  }

  @Test
  public void testSolution2() {
    assertArrayEquals(TwoSum.twoSumSolution2(testCase, 30), new int[]{4, 7});
    assertArrayEquals(TwoSum.twoSumSolution2(testCase, 5), new int[]{0, 1});

  }

  @Test
  public void testSolution3() {
    assertArrayEquals(TwoSum.twoSumSolution3(testCase, 30), new int[]{4, 7});
    assertArrayEquals(TwoSum.twoSumSolution3(testCase, 5), new int[]{0, 1});
  }
}
