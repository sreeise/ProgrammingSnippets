package tests;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static interview_questions.arrays.ArrayManipulation.arrayManipulation;
import static org.junit.Assert.assertEquals;

public class ArrayManipulationTest {
  @Test
  public void testArrayManipulation() {
      int[][] q = new int[3][];
      q[0] = new int[]{1, 5, 3};
      q[1] = new int[]{4, 8, 7};
      q[2] = new int[]{6, 9, 1};

      assertEquals(arrayManipulation(10, q), 10);
  }

  private static int fillArray = 0;
  private static int[][] queries;

  @Test
  public void testArrayManipulationLargeArray() throws FileNotFoundException {
    File file = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("arrayManipulation.txt")).getFile());
    Scanner scanner = new Scanner(file);
    int index = 0;

    while (scanner.hasNextLine()) {
      String[] line = scanner.nextLine().split(" ");
      if (index == 0) {
        fillArray = Integer.parseInt(line[0]);
        queries = new int[Integer.parseInt(line[1])][];
      } else {
        queries[index -1] = new int[] { Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]) };
      }

      index++;
    }

    long n = arrayManipulation(fillArray, queries);
    assertEquals(n, 7515267971L);
  }
}
