package mathutils;

public class BaseMath {

  /*
  Square Root: The square root of a number is the inverse operation of squaring that number. The
                square of a number is the number times itself.

   Square of n = n^2
   */

  public static int nSquared(int n) {
    return n * n;
  }

  /*
  Check if a number is prime

  Prime number: Whole number greater than 1 whose only factors are 1 and itself.
  Composite number: Numbers that have more than 2 factors.
  Factor: While number that can be divided evenly into another number.


  For every number which divides n evenly, there is a complement b, where
  a * b = n. If a > sqrt(n), then b < sqrt(n) as sqrt(n)^2 = n.
   */
  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }

    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrt; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  /*
Sieve of Eratosthenes: Efficient way to generate a list of primes

Recognizes all non-prime numbers are divisible by a prime number.

1. Cross off all numbers divisible by 2
2. Look for the next prime, the next non-crossed off number, and cross off all numbers
  divisible by it.
 */
  public static void SOEExample() {
    boolean[] primes = sieveOfEratosthenes(4);
    for (int i = 0; i < primes.length; i++) {
      if (primes[i]) {
        System.out.println(i);
      }
    }
  }

  public static boolean[] sieveOfEratosthenes(int max) {
    boolean[] flags = new boolean[max + 1];

    init(flags);
    int prime = 2;

    while (prime <= Math.sqrt(max)) {
      /* Cross off remaining multiples of prime */
      crossOff(flags, prime);

      /* Find next value which is true */
      prime = getNextPrime(flags, prime);
    }

    return flags; //prune(flags, count);
  }

  public static void crossOff(boolean[] flags, int prime) {
    /* Cross off remaining multiples of prime. We can start with
     * (prime*prime), because if we have a k * prime, where k < prime,
     * this value would have already been crossed off in a prior
     * iteration. */
    for (int i = prime * prime; i < flags.length; i += prime) {
      flags[i] = false;
    }
  }

  public static int getNextPrime(boolean[] flags, int prime) {
    int next = prime + 1;
    while (next < flags.length && !flags[next]) {
      next++;
    }
    return next;
  }

  public static void init(boolean[] flags) {
    flags[0] = false;
    flags[1] = false;
    for (int i = 2; i < flags.length; i++) {
      flags[i] = true;
    }
  }

  public static int[] prune(boolean[] flags, int count) {
    int[] primes = new int[count];
    int index = 0;
    for (int i = 0; i < flags.length; i++) {
      if (flags[i]) {
        primes[index] = i;
        index++;
      }
    }
    return primes;
  }
}
