package interview_questions.arrays;

import java.util.HashMap;
import java.util.List;

public class MigratoryBirds {
  /*
  You have been asked to help study the population of birds migrating across the continent.
  Each type of bird you are interested in will be identified by an integer value. Each time a
  particular kind of bird is spotted, its id number will be added to your array of sightings.
  You would like to be able to find out which type of bird is most common given a list of sightings.
  Your task is to print the type number of that bird and if two or more types of birds are equally
  common, choose the type with the smallest ID number.

  For example, assume your bird sightings are of types arr = [1, 1, 2, 2, 3]. There are two each of types
  1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.
   */

  public static int migratoryBirds(List<Integer> arr) {
    HashMap<Integer, Integer> common = new HashMap<>();
    int highestCount = 0;
    int lowestNum = 0;
    for (int i = 0; i < arr.size(); i++) {
      int j = arr.get(i);
      if (common.containsKey(j)) {
        common.put(j, common.get(j) + 1);
      } else {
        common.put(j, 1);
      }

      if (i == 0) {
        highestCount = common.get(j);
        lowestNum = j;
      } else {
        int current = common.get(j);
        if (current > highestCount) {
          highestCount = current;
          lowestNum = j;
        } else if (current == highestCount && j < lowestNum) {
          lowestNum = j;
        }
      }
    }

    return lowestNum;
  }
}
