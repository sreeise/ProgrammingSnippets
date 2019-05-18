package multithreading.extending_threads;

public class ThreadClass extends Thread {
  public int count = 0;

  @Override
  public void run() {
    System.out.println("Thread starting");

    try {
      while (count < 5) {
        Thread.sleep(5);
        System.out.println("In Thread, count is: " + count);
        count ++;
      }
    } catch (InterruptedException e) {
      System.out.println("Thread Interrupted");
    }

    System.out.println("Thread terminated");
  }
}
