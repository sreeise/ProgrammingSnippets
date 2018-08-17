package tests;

import files.FileRead;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_Reader {
  
  // Given a path to a text file, this method demonstrates
  // how method Reader.listOfFile would work, which reads
  // in a file with each line in a new array.
  public static void printList(String filePath) throws IOException {
    FileRead fileRead = new FileRead();

    List<String[]> list = fileRead.listOfFile(filePath);
    for (String[] array : list) {
      System.out.println(Arrays.toString(array));
    }
  }
}
