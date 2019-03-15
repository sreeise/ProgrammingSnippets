package data_structures.hashsets;

import java.util.Arrays;
import java.util.HashSet;

// Shows example of how to use HashSet in preventing duplicates in Strings
public class Unique {

  // Don't let anyone instantiate this class.
  private Unique() {}

  // HashSet: Maps only unique values therefore any value
  // that is not unique will not be added in the string a second time.

  // Stores only unique characters and prevents
  // from storing an empty space. We are only interested in
  // characters.
  // It if is a set of characters such as "word" it will split the string
  // into [w, o, r, d] only adding unique characters, so
  // if we had "word d", the array would still be [w, o, r, d], or some
  // variation in order with those exact characters.
  public static String uniqueCharacters(String getUnique) {
    String[] characters = getUnique.split("");

    HashSet<String> hashSet = new HashSet<>();

    for (String character : characters) {
      if (!character.equals(" ")) {
        hashSet.add(character);
      }
    }

    return hashSet.toString();
  }

  // Same as above except returns HashSet
  public static HashSet<String> uniqueCharactersHashSet(String getUnique) {
    String[] characters = getUnique.split("");

    HashSet<String> hashSet = new HashSet<>();

    for (String character : characters) {
      if (!character.equals(" ")) {
        hashSet.add(character);
      }
    }

    return hashSet;
  }

  // Stores only unique sets of characters. Can be words, one character, or
  // random sets of characters. The string gets separated by spaces.
  // Using HashSet, which does not allow duplicates, the method
  // separates each set of characters or a single character and
  // attempts to add it to the HashSet. The HashSet will either
  // add each set, or will prevent from adding it if there is already
  // the same String in the HashSet.
  public static String uniqueWords(String getUnique) {
    String[] words = getUnique.split(" ");
    return new HashSet<>(Arrays.asList(words)).toString();
  }

  // Same as above but returns the HashSet instead of String
  public static HashSet<String> uniqueWordsHashSet(String getUnique) {
    String[] words = getUnique.split(" ");
    return new HashSet<>(Arrays.asList(words));
  }
}
