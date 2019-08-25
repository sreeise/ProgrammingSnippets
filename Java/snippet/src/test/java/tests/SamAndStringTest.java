package tests;

import files.FileRead;
import interview_questions.strings.SamAndSubstrings;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class SamAndStringTest {
  @Test
  public void samAndStringTest() throws IOException {
    String path = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("samAndString.txt")).getPath();
    FileRead read = new FileRead();
    String s = read.readInToString(path);
    assertEquals(737811554, SamAndSubstrings.substrings(s));
  }
}
