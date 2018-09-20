package tests.testcontains;

import data.hashmaps.Contains;
import tests.AbstractTest;
import tests.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestContains extends AbstractTest {
  private static final String[] textFiles = {
        "test_files/testcontains/input00.txt", "test_files/testcontains/input10.txt",
        "test_files/testcontains/input13.txt", "test_files/testcontains/input20.txt"
  };

  private static final boolean[] answers = {
        true, false, true, false
  };

  private static void test(String[] args) throws FileNotFoundException {
    System.out.println("_______________________________");
    System.out.println("TWO ARRAY CONTAINS TEST. CLASS Contains");
    setTotalPassed(0);
    setTotalFailed(0);

    for (int testIndex = 0; testIndex < args.length; testIndex++) {

      File file = new File(args[testIndex]);

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

      if (c == answers[testIndex]) {
        System.out.println("PASS");
        System.out.println("Tested: " + textFiles[testIndex]);
        setTotalPassed(getTotalPassed() + 1);
      } else {
        System.out.println("FAILED");
        System.out.println("Tested: " + textFiles[testIndex]);
        setTotalFailed(getTotalFailed() + 1);
      }
      System.out.println();

      scanner.close();
    }

    System.out.println("TOTAL PASSED: " + getTotalPassed());
    System.out.println("TOTAL FAILED: " + getTotalFailed());
  }

  public static void runTests() throws FileNotFoundException {
    String testFiles[] = FileUtils.getPathsArray(textFiles);
    test(testFiles);
  }

  public static int[] getTotal() {
    return total();
  }
}
