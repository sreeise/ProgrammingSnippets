package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileRead {
  /**
   * Returns a list of files in a directory.
   *
   * @param dirPath The path to the directory.
   * @return List of files in directory.
   * @throws IOException If the path given is not a directory or the directory could not be found.
   */
  public File[] listFilesInDir(String dirPath) throws IOException {
    Path path = Paths.get(dirPath);
    File file = path.toFile();
    if (!file.isDirectory()) {
      throw new IOException("Path given must be a directory");
    }
    return file.listFiles();
  }

  /**
   * Reads in text from a file putting each line into a String Array. Returns the List of Arrays. An
   * Array may be empty if there is a blank line written to the file.
   *
   * @param filePath The path to the file to read in.
   * @return List of arrays. Each array has 1 line read from the file.
   * @throws IOException If the file could not be found or other issues with reading in the file.
   */
  public List<String[]> listOfFile(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    ArrayList<String[]> fileList = new ArrayList<>();
    File file = path.toFile();

    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line = bufferedReader.readLine();

    while (line != null) {
      if (!line.isEmpty()) {
        String[] splitLine = {line.trim()};
        fileList.add(splitLine);
      }
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    return fileList;
  }

  /**
   * Read in a file of Integers.
   *
   * @param filePath The path to the file.
   * @return A list of integers from the given file.
   * @throws IOException If the file could not be found or other issues with reading in the file.
   */
  public List<Integer> readInIntegers(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    List<Integer> fileList = new ArrayList<>();
    File file = path.toFile();

    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line = bufferedReader.readLine();
    while (line != null) {
      if (!line.isEmpty()) {
        Integer splitLine = Integer.parseInt(line.trim());
        fileList.add(splitLine);
      }
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    return fileList;
  }

  /**
   * Read in a file of Doubles.
   *
   * @param filePath The path to the file.
   * @return A list of Doubles from the given file.
   * @throws IOException If the file could not be found or other issues with reading in the file.
   */
  public List<Double> readInDoubles(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    List<Double> fileList = new ArrayList<>();
    File file = path.toFile();

    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line = bufferedReader.readLine();
    while (line != null) {
      if (!line.isEmpty()) {
        Double splitLine = Double.parseDouble(line.trim());
        fileList.add(splitLine);
      }
      line = bufferedReader.readLine();
    }
    bufferedReader.close();
    return fileList;
  }
}
