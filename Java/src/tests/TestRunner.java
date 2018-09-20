package tests;

import data.Pair;
import tests.str.TestCompareSort;
import tests.testcontains.TestContains;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;

public class TestRunner {

  public static void RunAll() {

    int passedCount = 0;
    int failedCount = 0;

    try {
      TestContains.runTests();
      int[] totalContains = TestContains.getTotal();

      passedCount += TestContains.getTotalPassed();
      failedCount += TestContains.getTotalFailed();
    } catch (FileNotFoundException e) {
      System.out.println("TESTS FAILED");
      System.out.println("File Not Found Exception for testing class Contains in test class TestContains");
      System.out.println();
      e.printStackTrace();
    }

    try {
      TestCompareSort.runTests();
      passedCount += TestCompareSort.getTotalPassed();
      failedCount += TestCompareSort.getTotalFailed();
    } catch (FileNotFoundException e) {
      System.out.println("TESTS FAILED");
      System.out.println("File Not Found Exception for testing class CompareSort in test class TestCompareSort");
      System.out.println();
      e.printStackTrace();
    }

    System.out.println("\n");

    Test_Unique.testUniqueWords();

    passedCount += Test_Unique.getTotalPassed();
    failedCount += Test_Unique.getTotalFailed();

    System.out.println("\n\n");
    System.out.println("_______________________________");
    System.out.println("FINSIHED TEST RUNS");
    System.out.println("TOTAL PASSED: " + passedCount);
    System.out.println("TOTAL FAILED: " + failedCount);

    if (failedCount == 0) {
      System.out.println("\nOK");
    } else {
      System.out.println("TEST SUITE FAILED");
    }
  }
}
