package functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
  public static void StringConsumer() {
    List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    strings.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });

    // as lambda
    strings.forEach(s -> System.out.println(s));
  }
}
