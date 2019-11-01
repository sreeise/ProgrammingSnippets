package designpatterns.observer;

public class MessageSubscriber implements Observer {
  public String name;
  public AbstractMessage message;

  public MessageSubscriber(String name) {
    this.name = name;
  }

  @Override
  public void update() {
    String messageUpdate = (String) this.message.getUpdate(this);

    if (messageUpdate == null) {
      System.out.println(name + " - No new message");
    } else {
      System.out.println(name + " - Consuming message: " + messageUpdate);
    }
  }

  @Override
  public void setMessage(AbstractMessage message) {
    this.message = message;
  }
}
