package designpatterns.singleton;

/*
Singleton instance that uses the double checked locking pattern.

Does not work before Java 5. After Java 5 the volatile variable is guaranteed.
*/
public class DoubleLockingSingleton {
  private static volatile DoubleLockingSingleton _instance;

  // Don't let anyone instantiate this class.
  // Caller must get the instance of the class through getInstance()
  private DoubleLockingSingleton() {
  }

  /*
  Checks that the _instance is null twice.
   */
  public static DoubleLockingSingleton getInstance() {
    if (_instance == null) {
      synchronized (DoubleLockingSingleton.class) {
        if (_instance == null) {
          _instance = new DoubleLockingSingleton();
        }
      }
    }
    return _instance;
  }
}
