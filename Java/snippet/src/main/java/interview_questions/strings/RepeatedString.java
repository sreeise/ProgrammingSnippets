package interview_questions.strings;


public class RepeatedString {
  public static long repeatedString(String s, long n) {
    if (s.length() == 0) {
      return 0;
    } else if (s.length() == 1) {
      if (s.equals("a")) {
        return n;
      }
      return 0;
    }

    long count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        count += 1;
      }
    }

    long p = n / s.length();
    count = count * p;

    for (int i = 0; i < (n % s.length()); i++) {
      if (s.charAt(i) == 'a') {
        count++;
      }
    }

    return count;
  }
}
