package interview_questions.strings;

public class URLify {
  // Write a method to replace all spaces in a string with %20.
  // You may assume that that the string has sufficient space at the
  // end to hold and additional characters.

  // Works only if the string does not contain more than one consecutive space.
  public static String replaceWithPercent(String s) {
    return s.replaceAll("\\s", "%20");
  }

  public static String replaceWithPercent2(String s) {
    char[] chars = s.toCharArray();
    int length = findLastCharacter(chars) + 1;
    replaceSpaces(chars, length);
    return new String(chars);
  }

  // Reference: https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_03_URLify/Question.java
  public static int findLastCharacter(char[] str) {
    for (int i = str.length - 1; i >= 0; i--) {
      if (str[i] != ' ') {
        return i;
      }
    }
    return -1;
  }

  public static void replaceSpaces(char[] str, int trueLength) {
    int spaceCount = 0, index, i = 0;
    for (i = 0; i < trueLength; i++) {
      if (str[i] == ' ') {
        spaceCount++;
      }
    }
    index = trueLength + spaceCount * 2;
    if (trueLength < str.length) str[trueLength] = '\0';
    for (i = trueLength - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[index - 1] = '0';
        str[index - 2] = '2';
        str[index - 3] = '%';
        index = index - 3;
      } else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }
}
