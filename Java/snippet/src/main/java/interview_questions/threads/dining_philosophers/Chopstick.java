package interview_questions.threads.dining_philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// From Cracking the Coding Interview by Gayle Laakmann McDowell
// https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2015.%20Threads%20and%20Locks/Q15_03_Dining_Philosophers/QuestionB

/*
In the famous dining philosophers problem, a bunch of philosophers are sitting around a circular
table with one chopstick between each of them. A philosopher needs both chopsticks to eat, and
always picks up the left chopstick before the right one. A deadlock could potentially occur
if all the philosophers reached for the left chopstick at the same time. Using threads and locks,
implement a simulation of the dining philosophers problem that prevents deadlocks.
*/

public class Chopstick {
  private Lock lock;
  private int number;

  public Chopstick(int n) {
    lock = new ReentrantLock();
    this.number = n;
  }

  public void pickUp() {
    lock.lock();
  }

  public void putDown() {
    lock.unlock();
  }

  public int getNumber() {
    return number;
  }
}
