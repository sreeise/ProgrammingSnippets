package tests.testcomparesort;

import sort.strcompare.CompareSort;
import sort.strcompare.KeyValueMap;
import tests.AbstractTest;
import tests.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TestCompareSort extends AbstractTest {

  public static String[] testFiles = {"test_files/test_str_comparator/input05.txt"};
  public static String[] outFiles = {"test_files/test_str_comparator/output05.txt"};
  private static int equal = 0;
  private static int notEqual = 0;

  public static final void test(String[] args, String[] args2) throws FileNotFoundException {
    setTotalPassed(0);
    setTotalFailed(0);

    for (int testIndex = 0; testIndex < testFiles.length; testIndex++) {
      System.out.println("_______________________________");
      System.out.println("\nTESTING STRING AND INTEGER MATCHES FOR CLASS CompareSort\n");
      File file = new File(args[testIndex]);

      Scanner scan = new Scanner(file);
      int n = scan.nextInt();

      KeyValueMap[] keyValueMap = new KeyValueMap[n];
      CompareSort checker = new CompareSort();

      for (int i = 0; i < n; i++) {
        keyValueMap[i] = new KeyValueMap(scan.next(), scan.nextInt());
      }
      scan.close();
      File output = new File(args2[testIndex]);

      Scanner scanner = new Scanner(output);


      KeyValueMap[] keyValueMap2 = new KeyValueMap[n];

      for (int j = 0; j < n; j++) {
        keyValueMap2[j] = new KeyValueMap(scanner.next(), scanner.nextInt());
      }

      Arrays.sort(keyValueMap, checker);
      scanner.close();

      int count = keyValueMap.length - 1;

      for (int i = 0; i < keyValueMap.length; i++) {

        if (keyValueMap[i].str.equals(keyValueMap2[count].str)) {
          if (keyValueMap[i].num == keyValueMap2[count].num) {
            equal += 1;
          } else {
            notEqual += 1;
          }
        }
        count -= 1;
      }

      if (equal == n) {
        setTotalPassed(getTotalPassed() + 1);
      } else {
        setTotalFailed(getTotalFailed() + 1);
      }



      if (getTotalPassed() == outFiles.length && outFiles.length == testFiles.length) {
        System.out.println("\nPASS");
        System.out.println("TESTED: " + testFiles[testIndex]);

        System.out.println("\nTOTAL PASSED: " + getTotalPassed());
        System.out.println("TOTAL FAILED: " + getTotalFailed());
      } else {
        System.out.println("\nFAILED");
        System.out.println("TESTED: " + testFiles[testIndex]);

        System.out.println("\nTOTAL PASSED: " + getTotalPassed());
        System.out.println("TOTAL FAILED: " + getTotalFailed());
      }

    }

  }

  public static void runTests() throws FileNotFoundException {
      String test_files[] = FileUtils.getPathsArray(testFiles);
      String out_files[] = FileUtils.getPathsArray(outFiles);
      test(test_files, out_files);
  }


}
