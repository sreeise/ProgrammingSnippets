package collections;

// This class is used to represent examples in
// other classes in this package

public class GenWild<T> {
  private T[] array;

  public GenWild(T[] array) {
    this.array = array;
  }

  void add(T b) {
    array[array.length - 1] = b;
  }
}
