package functional_interfaces;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateInterface {
  public String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {
    return Arrays.stream(names)
          .filter(condition)
          .collect(Collectors.joining(", "));
  }


  public static String getWordsWithLength(int length, String... words) {
    return Arrays.stream(words)
          .filter(s -> s.length() == length)
          .collect(Collectors.joining(", "));
  }
}
