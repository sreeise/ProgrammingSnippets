package tests;

import data_structures.hashmaps.Contains;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class ContainsTest {
  private static final String[] testFiles = {
    "test_files/testcontains/input00.txt", "test_files/testcontains/input10.txt",
    "test_files/testcontains/input13.txt", "test_files/testcontains/input20.txt"
  };

  private static final boolean[] answers = {true, false, true, false};

  @Test
  public void testContains() throws FileNotFoundException {
    for (int testIndex = 0; testIndex < testFiles.length; testIndex++) {

      File file = new File(testFiles[testIndex]);

      Scanner scanner = new Scanner(file);
      String[] mn = scanner.nextLine().split(" ");

      int m = Integer.parseInt(mn[0]);
      int n = Integer.parseInt(mn[1]);

      String[] magazine = new String[m];

      String[] magazineItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < m; i++) {
        String magazineItem = magazineItems[i];
        magazine[i] = magazineItem;
      }

      String[] note = new String[n];

      String[] noteItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        String noteItem = noteItems[i];
        note[i] = noteItem;
      }

      boolean c = Contains.containsAll(note, magazine);
      Logger logger = Logger.getLogger("TestContains");
      logger.info("ContainsAll: " + c);
      assertEquals(c, answers[testIndex]);

      scanner.close();
    }
  }
}
