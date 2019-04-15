package interview_questions.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueEmail {
  /*
    Every email consists of a local name and a domain name, separated by the @ sign.

  For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

  Besides lowercase letters, these emails may contain '.'s or '+'s.

  If you enqueue periods ('.') between some characters in the local name part of an email address,
  mail sent there will be forwarded to the same address without dots in the local name.
  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
  (Note that this rule does not apply for domain names.)

  If you enqueue a plus ('+') in the local name, everything after the first plus sign will be ignored.
  This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
  (Again, this rule does not apply for domain names.)

  It is possible to use both of these rules at the same time.

  Given a list of emails, we send one email to each address in the list.
  How many different addresses actually receive mails?
     */

  public static int numUniqueEmails(String[] emails) {
    HashSet<String> hashSet = new HashSet<>();

    for (String email : emails) {
      List<Integer> list = find(email, "@");
      int index = list.get(0);
      String sub = email.substring(0, index);
      String domanin = email.substring(index);

      if (sub.contains("+")) {
        List<Integer> list1 = find(sub, "+");
        int plus = list1.get(0);
        String small = sub.substring(0, plus);
        String s = small.replace(".", "");
        hashSet.add(s + domanin);
      } else {
        String s = sub.replace(".", "");
        hashSet.add(s + domanin);
      }
    }

    return hashSet.size();
  }

  public static List<Integer> find(String str, String substr) {
    String pattern = Pattern.quote(substr);
    Matcher m = Pattern.compile(pattern).matcher(str);

    List<Integer> pos = new ArrayList<>();
    while (m.find()) {
      pos.add(m.start());
      return pos;
    }
    return pos;
  }
}
