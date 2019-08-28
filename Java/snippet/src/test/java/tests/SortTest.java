package tests;

import org.junit.Test;
import sort.strcompare.CompareSort;
import sort.strcompare.KeyValueMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class SortTest {
  @Test
  public void testCompareSort() throws FileNotFoundException {
    String path = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("test_str_comparator/input05.txt")).getPath();
    String outPath = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("test_str_comparator/output05.txt")).getPath();
    File file = new File(path);
    Scanner scan = new Scanner(file);
    int n = scan.nextInt();

    KeyValueMap[] keyValueMap = new KeyValueMap[n];
    CompareSort checker = new CompareSort();

    for (int i = 0; i < n; i++) {
      keyValueMap[i] = new KeyValueMap(scan.next(), scan.nextInt());
    }
    scan.close();
    File output = new File(outPath);

    Scanner scanner = new Scanner(output);

    KeyValueMap[] keyValueMap2 = new KeyValueMap[n];

    for (int j = 0; j < n; j++) {
      keyValueMap2[j] = new KeyValueMap(scanner.next(), scanner.nextInt());
    }

    Arrays.sort(keyValueMap, checker);
    scanner.close();

    int count = keyValueMap.length - 1;

    for (int i = 0; i < keyValueMap.length; i++) {
      assertEquals(keyValueMap[i].str, keyValueMap2[count].str);
      if (keyValueMap[i].str.equals(keyValueMap2[count].str)) {
        assertEquals(keyValueMap[i].num, keyValueMap2[count].num);
      }
      count -= 1;
    }
  }
}
