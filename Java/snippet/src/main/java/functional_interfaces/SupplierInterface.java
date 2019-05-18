package functional_interfaces;

import java.util.function.DoubleSupplier;
import java.util.logging.Logger;

/*
Supplier Interface Methods
  1. IntSupplier: int getAsInt()
  2. DoubleSupplier: double getAsDouble()
  3. LongSupplier: long getAsLong()
  4. BooleanSupplier: boolean getAsBoolean()
 */

public class SupplierInterface {
  public static void supplier() {
    Logger logger = Logger.getLogger("...");

    DoubleSupplier randomSupplier =
          new DoubleSupplier() {
            @Override
            public double getAsDouble() {
              return Math.random();
            }
          };

    // OR
    // randomSupplier = () -> Math.random();
    // OR
    // randomSupplier = Math::random;

    logger.info(String.valueOf(randomSupplier.getAsDouble()));
  }
}
