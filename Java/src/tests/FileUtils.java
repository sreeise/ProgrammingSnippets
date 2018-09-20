package tests;

import java.io.File;

public class FileUtils {

  public static String getAbsolutePath() {
    return new File("").getAbsolutePath();
  }

  public static String[] getPathsArray(String[] textFiles) {
    String[] paths = new String[textFiles.length];
    String absolutePath = FileUtils.getAbsolutePath();

    for (int i = 0; i < textFiles.length; i++) {
      String resource = absolutePath.concat("/").concat(textFiles[i]);
      paths[i] = resource;
    }

    return paths;
  }
}
