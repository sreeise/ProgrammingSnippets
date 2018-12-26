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
   * Reads in text from a file putting each line into a String Array. Returns
   * the List of Arrays. An Array may be empty if there is a blank
   * line written to the file.
   *
   * @param filePath The path to the file to read in.
   * @return List of arrays. Each array has 1 line read from the file.
   * @throws IOException, FileNotFoundException.
   */
  public List<String[]> listOfFile(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    ArrayList<String[]> fileList = new ArrayList<>();
    File file = path.toFile();

    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line = bufferedReader.readLine();

    while (line != null) {
      String[] splitLine = {line};
      fileList.add(splitLine);
      line = bufferedReader.readLine();
    }

    return fileList;
  }
}
