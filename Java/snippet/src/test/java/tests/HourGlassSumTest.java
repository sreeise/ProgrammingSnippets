package tests;

import interview_questions.arrays.HourGlass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HourGlassSumTest {
  @Test
  public void hourGlassSum() {
    int[][] a =
          new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0},
          };

    int sum = HourGlass.hourglassSum(a);
    assertEquals(sum, 19);
  }
}
