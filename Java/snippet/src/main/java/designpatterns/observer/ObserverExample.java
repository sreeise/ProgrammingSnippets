package designpatterns.observer;

public class ObserverExample {
  public static void observerExample() {
    Message message = new Message();

    Observer observer = new MessageSubscriber("Observer 0");
    Observer observer1 = new MessageSubscriber("Observer 1");

    message.register(observer);
    message.register(observer1);

    observer.setMessage(message);
    observer1.setMessage(message);

    observer.update();

    // Both observers receive the message.
    message.postMessage("New Message");

    // Unregister the first observer
    message.unregister(observer);

    // Only the second observer, observer1, gets
    // the the message.
    message.postMessage("New Message 2");
  }
}
