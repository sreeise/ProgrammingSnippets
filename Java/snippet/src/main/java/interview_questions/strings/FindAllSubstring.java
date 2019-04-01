package interview_questions.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllSubstring {
  /*
  Find all occurrences of a substring within another string.
   */

  public static List<Integer> findAll(String substr, String str) {
    String pattern = Pattern.quote(substr);
    Matcher m = Pattern.compile(pattern).matcher(str);

    List<Integer> pos = new ArrayList<>();
    while (m.find()) {
      pos.add(m.start());
    }
    return pos;
  }
}
