package interview_questions.strings;

public class URLify {
  // Write a method to replace all spaces in a string with %20.
  // You may assume that that the string has sufficient space at the
  // end to hold and additional characters.
  public static String replaceWithPercent(String s) {
    return s.replaceAll("\\s", "%20");
  }
}
