package tests;

import files.FileRead;
import interview_questions.arrays.RunningMedian;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class RunningMedianTest {
  @Test
  public void testRunningMedian() {
    // Test case and answer.
    int[] testCase = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    double[] answer = new double[]{1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5};
    // Results from test case.
    double[] medians = RunningMedian.runningMedian(testCase);
    // The known answer array length should be the same as the results.
    assertEquals(answer.length, medians.length);
    for (int i = 0; i < medians.length; i++) {
      assertEquals(0, Double.compare(answer[i], medians[i]));
    }
  }

  @Test
  public void testLargeArrayRunningMedian() throws IOException {
    // Read in the test case and answer.
    FileRead fileRead = new FileRead();
    File[] files = fileRead.listFilesInDir("./test_files/test_running_median");
    // Sort the array so we get the test case file at index 0 and the answers file at
    // index 1.
    Arrays.sort(files);
    File input = files[0];
    File output = files[1];
    List<Integer> intList = fileRead.readInIntegers(input.toString());
    List<Double> doubleList = fileRead.readInDoubles(output.toString());

    // Test case and answer.
    int[] testCase = intList.stream().mapToInt(i -> i).toArray();
    double[] answer = doubleList.stream().mapToDouble(i -> i).toArray();
    // Results from test case.
    double[] medians = RunningMedian.runningMedian(testCase);
    // The known answer array length should be the same as the results.
    assertEquals(answer.length, medians.length);
    for (int i = 0; i < medians.length; i++) {
      assertEquals(0, Double.compare(answer[i], medians[i]));
    }
  }
}
