package designpatterns.singleton;

// A Singleton is a class that can have only one
// instance alive at any one time.
public class Singleton {
  private static Singleton instance = null;

  // Don't let anyone instantiate this class.
  // Caller must get the instance of the class through getInstance()
  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }

    return instance;
  }
}
