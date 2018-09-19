package tests;

import tests.testcontains.TestContains;

import java.io.FileNotFoundException;

public class TestRunner {

  public static void RunAll() {

    try {
      TestContains.runTests();
      TestContains.getTotal();
    } catch (FileNotFoundException e) {
      System.out.println("TESTS FAILED");
      System.out.println("File Not Found Exception for testing class Contains in test class TestContains");
      System.out.println();
      e.printStackTrace();
    }

    System.out.println("\n");

    Test_Unique.testUniqueWords();
  }
}
