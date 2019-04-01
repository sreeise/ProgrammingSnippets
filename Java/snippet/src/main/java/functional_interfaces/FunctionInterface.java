package functional_interfaces;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionInterface {
  public static void wordListLength(List<String> words) {
    List<Integer> lengths =
        words.stream()
            .map(
                new Function<String, Integer>() {
                  @Override
                  public Integer apply(String s) {
                    return s.length();
                  }
                })
            .collect(Collectors.toList());

    System.out.println(lengths);
  }

  public static void wordListLengthLambda(List<String> words) {
    List<Integer> lengths = words.stream().map(s -> s.length()).collect(Collectors.toList());

    System.out.println(lengths);
  }

  public static void wordListLengthClassInstance(List<String> words) {
    List<Integer> lengths = words.stream().map(String::length).collect(Collectors.toList());
    System.out.println(lengths);
  }
}
