package interview_questions;

public class URLify {
  // Write a method to replace all spaces in a string with %20.
  // You may assume that that the string has sufficient space at the
  // end to hold and additional characters.
  public static String replace_with_percent(String s) {
    return s.replaceAll("\\s", "%20");
  }
}
