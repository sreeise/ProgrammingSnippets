package collections;

import java.util.Collection;
import java.util.List;

public class GenericsAndWildcards {
  /*
  Notes

  More info on generics can be found at https://docs.oracle.com/javase/tutorial/extra/generics/index.html

  Lower bound wildcards: ? super T
  Upper bound wildcards: ? extends T
  Wildcard capture: Such as ? in List<?> where the type of ? is inferred by the compiler

  T in generics stands for the type that the Class object is representing
   */

  /**
   * Add objects of any type from a collection to an array through the use of generic types. This
   * could not be done if the array were specified as an Object, only as a generic.
   *
   * @param array      Array of any type
   * @param collection Collection of any type
   * @param <T>        Type for the array and collection
   */
  static <T> void toArray(T[] array, Collection<T> collection) {
    for (T each : array) {
      collection.add(each);
    }
  }

  /**
   * For demonstrative purposes only. Array out of bounds errors could be thrown here. This will
   * work for arrays that have room for the element or a dynamically resizable array.
   *
   * <p>Lower bounded wildcard using keyword super. Adds the last element in the collection to the
   * array in class GenWild
   *
   * @param coll    Collection of any type
   * @param genWild Wild card of any t ype
   * @param <T>     Type
   * @return Last element in the collection
   */
  public static <T> T getMethod(Collection<T> coll, GenWild<? super T> genWild) {
    T element = null;
    for (T t : coll) {
      element = t;
      genWild.add(element);
    }
    return element;
  }

  /**
   * Print objects in a collection. Because we use the wildcard: ?, we are able to print any
   * collection regardless of type.
   *
   * @param c A collection of any type
   */
  public void print(Collection<?> c) {
    for (Object e : c) {
      System.out.println(e);
    }
  }

  /**
   * General example from oracle tutorials on how to enqueue an integer that can be from any
   * supertype: Object, Number, or Integer.
   *
   * @param list A List using the lower bound wildcard super.
   */
  public void addToList(List<? super Integer> list) {
    for (int i = 0; i < 11; i++) {
      list.add(i);
    }
  }
}
