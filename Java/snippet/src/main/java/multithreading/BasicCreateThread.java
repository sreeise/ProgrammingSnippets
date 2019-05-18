package multithreading;

public class BasicCreateThread {
  private BasicCreateThread() {
  }

  /*
  When a program calls start() a new thread is created and the code inside
  the run() method is executed in a new thread.

  Calling run() directly would not create any new threads and instead run
  in the main thread.

  The start() method on a thread can only be called once. An attempt to
  call start() more then once will throw an IllegalStateException.
   */
  public static synchronized void CreateThread() {
    Thread thread =
          new Thread() {
            public void run() {
              printStatement();
            }
          };

    // In Java, the start() method must be called to create a new thread, whereas
    // the run() method will run the on the main thread.
    thread.start();
    System.out.println("After Thread Start() called.");
  }

  private static synchronized void printStatement() {
    System.out.println("Printed in New Thread");
  }
}
