package designpatterns.extensibleenum;

import java.util.Arrays;
import java.util.Collection;

// Source code from Effective Java by Joshua Bloch
public class OperationExample {

  public static void example() {
    double x = 10.2;
    double y = 15.0;
    test(Arrays.asList(ExtendedOperation.values()), x, y);
  }

  private static <T extends Enum<T> & Operation> void test(
      Class<T> opEnumType, double x, double y) {
    for (Operation op : opEnumType.getEnumConstants())
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
  }

  private static void test(Collection<? extends Operation> opSet, double x, double y) {
    for (Operation op : opSet) System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
  }
}
