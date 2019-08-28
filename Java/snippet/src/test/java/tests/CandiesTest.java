package tests;

import files.FileRead;
import interview_questions.greedy.Candies;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class CandiesTest {
  @Test
  public void candiesTest() throws IOException {
    String path = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("candyRatings.txt")).getPath();
    FileRead fileRead = new FileRead();
    List<Integer> list = fileRead.readInIntegerLines(path);
    int ans = list.remove(0);
    int size = list.remove(0);
    int[] arr = new int[list.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = list.get(i);
    }
    assertEquals(ans, Candies.candies(size, arr));
  }
}
