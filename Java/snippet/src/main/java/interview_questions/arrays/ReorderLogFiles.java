package interview_questions.arrays;

import java.util.Arrays;

public class ReorderLogFiles {
  /*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.

We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each
log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered
lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should
be put in their original order.

Return the final order of the logs.
 */

  public static String[] reorder(String[] logs) {
    Arrays.sort(logs, (log1, log2) -> {
      String[] split1 = log1.split(" ", 2);
      String[] split2 = log2.split(" ", 2);

      boolean isInt1 = Character.isDigit(split1[1].charAt(0));
      boolean isInt2 = Character.isDigit(split2[1].charAt(0));

      if (!isInt1 && !isInt2) {
        int cmp = split1[1].compareTo(split2[1]);
        if (cmp != 0) {
          return cmp;
        }

        return split1[0].compareTo(split2[0]);
      }

      return isInt1 ? (isInt2 ? 0 : 1) : -1;
    });

    return logs;
  }
}
