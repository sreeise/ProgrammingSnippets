package interview_questions.strings;

public class StringTokens {
  /*
  Given a string, S, matching the regular expression [A-Za-z !,?._'@]+, split the string into
  tokens. We define a token to be one or more consecutive English alphabetic letters. Then,
  print the number of tokens, followed by each token on a new line.
   */

  public static void stringTokens(String s) {
    if (s.length() == 0) {
      System.out.println(0);
    } else {
      // Strip out non-word characters and replace with whitespace, trim leading/trailing whitespace
      s = s.replaceAll("[^\\p{Alpha}]+", " ").trim();

      if (s.isEmpty()) {
        System.out.println(0);
      } else {
        String[] strings = s.split("\\p{Space}+");
        System.out.println(strings.length);

        for (String str : strings) {
          System.out.println(str);
        }
      }
    }
  }
}
