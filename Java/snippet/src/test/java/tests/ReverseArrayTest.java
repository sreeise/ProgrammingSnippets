package tests;

import interview_questions.arrays.ReverseArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseArrayTest {
  @Test
  public void reverseArrayTest() {
    int[] a = new int[]{1, 4, 3, 2};
    int[] b = ReverseArray.reverse(a);
    assertEquals(b[0], 2);
    assertEquals(b[1], 3);
    assertEquals(b[2], 4);
    assertEquals(b[3], 1);
  }
}
