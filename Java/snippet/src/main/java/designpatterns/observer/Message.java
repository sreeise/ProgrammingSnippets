package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Message implements AbstractMessage {
  private final Object MUTEX = new Object();
  private List<Observer> observers;
  private String message;
  private boolean changed;

  public Message() {
    this.observers = new ArrayList<>();
  }

  @Override
  public void register(Observer observer) {
    if (observer == null) {
      throw new NullPointerException("Observer is null");
    }

    synchronized (MUTEX) {
      if (!observers.contains(observer)) {
        observers.add(observer);
      }
    }
  }

  @Override
  public void unregister(Observer observer) {
    synchronized (MUTEX) {
      observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers() {
    List<Observer> observers1 = null;

    synchronized (MUTEX) {
      if (!changed) {
        return;
      }

      observers1 = new ArrayList<>(this.observers);
      this.changed = false;
    }

    for (Observer observer : observers1) {
      observer.update();
    }
  }

  @Override
  public Object getUpdate(Observer observer) {
    return this.message;
  }

  public void postMessage(String message) {
    System.out.println("Message Posted: " + message);
    this.message = message;
    this.changed = true;
    this.notifyObservers();
  }
}
