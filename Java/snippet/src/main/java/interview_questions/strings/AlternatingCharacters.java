package interview_questions.strings;

public class AlternatingCharacters {
  /*
  You are given a string containing characters A and B only. Your task is to change it into a
  string such that there are no matching adjacent characters. To do this, you are allowed to
  delete zero or more characters in the string.

  Your task is to find the minimum number of required deletions.

  For example, given the string s = AABAAB, remove an A at positions 0 and 3 to make
  s = ABAB in 2 deletions.
   */
  public static int alternatingCharacters(String s) {
    String[] s1 = s.split("");
    int count = 0;
    for (int i = 1; i < s1.length; i++) {
      if (s1[i].equals(s1[i - 1])) {
        count += 1;
      }
    }

    return count;
  }
}
