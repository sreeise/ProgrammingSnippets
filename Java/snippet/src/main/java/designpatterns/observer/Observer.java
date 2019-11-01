package designpatterns.observer;

public interface Observer {
  public void update();

  public void setMessage(AbstractMessage message);
}
