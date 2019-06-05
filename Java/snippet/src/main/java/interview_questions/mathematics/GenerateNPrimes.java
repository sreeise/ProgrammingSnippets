package interview_questions.mathematics;

import java.util.ArrayList;
import java.util.List;

public class GenerateNPrimes {
  /*
  Generate N number of primes.

  A prime number is a natural number greater than 1 that cannot be formed
  by multiplying two smaller natural numbers.
   */

  public static List<Integer> generatePrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    primes.add(2);
    int nextPrime = 3;

    while (primes.size() < n) {
      boolean prime = true;

      for (int i = 0; primes.get(i) < Math.sqrt(nextPrime); i++) {
        if (nextPrime % primes.get(i) == 0) {
          prime = false;
          break;
        }
      }

      if (prime) {
        primes.add(nextPrime);
      }
      nextPrime += 2;
    }

    return primes;
  }
}
