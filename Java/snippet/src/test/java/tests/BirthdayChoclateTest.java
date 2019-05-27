package tests;

import interview_questions.arrays.BirthdayChoclate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BirthdayChoclateTest {
  @Test
  public void testAsArray() {
    int[] testCase = {2, 2, 1, 3, 2};
    assertEquals(2, BirthdayChoclate.birthday(testCase, 4, 2));
    int[] testCase2 = {3, 5, 4, 1, 2, 5, 3, 4, 3, 2, 1, 1, 2, 4, 2, 3, 4, 5, 3, 1, 2, 5, 4, 5, 4, 1, 1, 5, 3, 1, 4, 5, 2, 3, 2, 5, 2, 5, 2, 2, 1, 5, 3, 2, 5, 1, 2, 4, 3, 1, 5, 1, 3, 3, 5};
    assertEquals(10, BirthdayChoclate.birthday(testCase2, 18, 6));
  }

  @Test
  public void testAsList() {
    List<Integer> testCase = new ArrayList<>(Arrays.asList(2, 2, 1, 3, 2));
    assertEquals(2, BirthdayChoclate.birthday(testCase, 4, 2));
    List<Integer> testCase2 = new ArrayList<>(Arrays.asList(3, 5, 4, 1, 2, 5, 3, 4, 3, 2, 1, 1, 2, 4, 2, 3, 4, 5, 3, 1, 2, 5, 4, 5, 4, 1, 1, 5, 3, 1, 4, 5, 2, 3, 2, 5, 2, 5, 2, 2, 1, 5, 3, 2, 5, 1, 2, 4, 3, 1, 5, 1, 3, 3, 5));
    assertEquals(10, BirthdayChoclate.birthday(testCase2, 18, 6));
  }
}
