package functional_interfaces;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MethodReference {
  /*
  Method references treat a method as if it were a lambda

  Three forms of method references:
    1. object::instanceMethod
        Instance method using a reference to a supplied object
    2. Class::staticMethod
        Static method
    3. Class::instanceMethod
        Invoke instance method on a reference to an object supplied by the context
   */
  public static void referenceTypes() {
    Stream.of(3, 2, 32, 3).forEach(x -> System.out.println(x));
    Stream.of(3, 2, 32, 3).forEach(System.out::println);

    Consumer<Integer> printer = System.out::println;
    Stream.of(3, 1, 4, 1, 5, 9).forEach(printer);

    Stream.generate(Math::random).limit(10).forEach(System.out::println);
  }

  // Lambdas can be used for method references
  // List all the files that end with a given file extension that reside
  // with the given path.
  public static void endsWith(String path, String fileExt) {
    File directory = new File(path);
    String[] names = directory.list((dir, name) -> name.endsWith(fileExt));
    System.out.println(Arrays.asList(names));
  }
}
