package data_structures.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/CtCILibrary/CtCILibrary/HashMapList.java
public class HashMapList<T, E> {
  private HashMap<T, ArrayList<E>> map = new HashMap<>();

  /**
   * Insert item into list at key.
   *
   * @param key
   * @param item
   */
  public void put(T key, E item) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
    map.get(key).add(item);
  }

  /**
   * Insert list of items at key.
   *
   * @param key
   * @param items
   */
  public void put(T key, ArrayList<E> items) {
    map.put(key, items);
  }

  /**
   * Get list of items at key.
   *
   * @param key
   * @return The ArrayList of items in the hash map list that
   * matches the given key.
   */
  public ArrayList<E> get(T key) {
    return map.get(key);
  }

  /**
   * Check if hashmaplist contains key.
   *
   * @param key
   * @return True if hte list contains the key.
   */
  public boolean containsKey(T key) {
    return map.containsKey(key);
  }

  /**
   * Check if list at key contains value.
   *
   * @param key
   * @param value
   * @return True if the list contains the key value pair else false.
   */
  public boolean containsKeyValue(T key, E value) {
    ArrayList<E> list = get(key);
    if (list == null) return false;
    return list.contains(value);
  }

  /**
   * Get the list of keys.
   *
   * @return List of keys in the hash map list.
   */
  public Set<T> keySet() {
    return map.keySet();
  }

  @Override
  public String toString() {
    return map.toString();
  }
}
