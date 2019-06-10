package interview_questions.strings;

// Reference: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_06_String_Compression/QuestionC.java

// The original algorithm in the reference above uses a StringBuffer instead of a StringBuilder
// Since we are not doing any multithreading here it is changed to a StringBuilder to improve
// performance. If multithreading is desired then the StringBuffer can be substituted where a
// StringBuilder is used.
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

      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
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

  // This method assumes that we always want the count regardless
  // if the string does not contain repeated characters or if the
  // new string would not be smaller than the original string.
  public static String compressString(String s) {
    StringBuilder builder = new StringBuilder(s.length() - 1);
    int consecutive = 0;
    for (int i = 0; i < s.length(); i++) {
      consecutive++;

      if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
        builder.append(s.charAt(i)).append(consecutive);
        consecutive = 0;
      }
    }

    builder.trimToSize();
    return builder.toString();
  }
}
