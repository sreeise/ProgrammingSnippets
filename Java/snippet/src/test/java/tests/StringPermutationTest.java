package tests;

import interview_questions.strings.StringPermutation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringPermutationTest {
  @Test
  public void testPermutation() {
    String s = "ABC";
    List<String> answers = new ArrayList<>(Arrays.asList("ABC", "ACB", "BAC", "BCA", "CBA", "CAB"));
    List<String> testCase = StringPermutation.permutations(s);
    assertEquals(answers.size(), testCase.size());
    assertTrue(answers.containsAll(testCase));
  }
}
