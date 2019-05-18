import multithreading.extending_threads.ThreadClass;
import sockets.EchoClient;

public class JavaReference {
  public static void main(String[] args) {
    EchoClient echoClient = new EchoClient("localhost", 3005);
    echoClient.openConnection();
  }
}
