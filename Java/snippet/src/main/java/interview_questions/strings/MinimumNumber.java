package interview_questions.strings;

public class MinimumNumber {
  /*
  Louise joined a social networking site to stay in touch with her friends. The signup page required her
  to input a name and a password. However, the password must be strong. The website considers a password
  to be strong if it satisfies the following criteria:

  Its length is at least 6.
  It contains at least one digit.
  It contains at least one lowercase English character.
  It contains at least one uppercase English character.
  It contains at least one special character. The special characters are: !@#$%^&*()-+
   */
  public static int minimumNumber(String password) {
    int n = password.length();
    int minimum = 0;
    if (!password.matches(".*[\\d]+.*")) {
      minimum++;
    }

    if (!password.matches(".*[a-z]+.*")) {
      minimum++;
    }

    if (!password.matches(".*[A-Z]+.*")) {
      minimum++;
    }

    if (!password.contains("-") && !password.matches(".*[!@#$%^&*()+]+.*")) {
      minimum++;
    }

    if (n < 6 && Math.abs(6 - n) > minimum) {
      return Math.abs(6 - n);
    }

    return minimum;
  }
}
