package interview_questions.threads.dining_philosophers;

// From Cracking the Coding Interview by Gayle Laakmann McDowell
// https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2015.%20Threads%20and%20Locks/Q15_03_Dining_Philosophers/QuestionB

/*
In the famous dining philosophers problem, a bunch of philosophers are sitting around a circular
table with one chopstick between each of them. A philosopher needs both chopsticks to eat, and
always picks up the left chopstick before the right one. A deadlock could potentially occur
if all the philosophers reached for the left chopstick at the same time. Using threads and locks,
implement a simulation of the dining philosophers problem that prevents deadlocks.
*/

public class Philosopher extends Thread {
  private final int maxPause = 100;
  private int bites = 10;

  private Chopstick lower;
  private Chopstick higher;
  private int index;

  public Philosopher(int i, Chopstick left, Chopstick right) {
    index = i;
    if (left.getNumber() < right.getNumber()) {
      this.lower = left;
      this.higher = right;
    } else {
      this.lower = right;
      this.higher = left;
    }
  }

  private static int randomInt(int n) {
    return (int) (Math.random() * n);
  }

  private static int randomIntInRange(int min, int max) {
    return randomInt(max + 1 - min) + min;
  }

  public void eat() {
    System.out.println("Philosopher " + index + ": start eating");
    pickUp();
    chew();
    putDown();
    System.out.println("Philosopher " + index + ": done eating");
  }

  public void pickUp() {
    pause();
    lower.pickUp();
    pause();
    higher.pickUp();
    pause();
  }

  public void chew() {
    System.out.println("Philosopher " + index + ": eating");
    pause();
  }

  public void pause() {
    try {
      int pause = randomIntInRange(0, maxPause);
      Thread.sleep(pause);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void putDown() {
    higher.putDown();
    lower.putDown();
  }

  public void run() {
    for (int i = 0; i < bites; i++) {
      eat();
    }
  }
}
