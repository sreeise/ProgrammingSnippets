package interview_questions.strings;

public class Compression {
  /*
  Implement a method to perform basic string compression using the counts
  of repeated characters. For example the string aabcccccaaa would become a2b1c5a3.

  If the compressed string would not become smaller than the original string, your method
  should return the original string.
   */
  public static String compress(String str) {
    int finalLength = countCompression(str);

    if (finalLength >= str.length()) {
      return str;
    }

    StringBuilder compressed = new StringBuilder(finalLength);
    int consecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      consecutive++;

      if (i + 1 > str.length() - 1) {
        compressed.append(str.charAt(i));
        compressed.append(consecutive);
        return compressed.toString();
      }

      if (str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(consecutive);
        consecutive = 0;
      }
    }

    return compressed.toString();
  }

  private static int countCompression(String str) {
    int compressedLength = 0;
    int consecutive = 0;

    for (int i = 0; i < str.length(); i++) {
      consecutive++;

      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedLength += 1 + String.valueOf(consecutive).length();
        consecutive = 0;
      }
    }
    return compressedLength;
  }
}
