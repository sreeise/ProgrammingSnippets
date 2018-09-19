package tests;

public class AbstractTest {

  private static Integer totalPassed = 0;
  private static Integer totalFailed = 0;

  protected static void setTotalPassed(int passed) {
    totalPassed = passed;
  }

  protected static void setTotalFailed(int failed) {
    totalPassed = failed;
  }

  protected static Integer getTotalPassed() {
    return totalPassed;
  }

  protected static Integer getTotalFailed() {
    return totalFailed;
  }

  protected static int[] total() {
    return new int[]{getTotalPassed(), getTotalFailed()};
  }
}
