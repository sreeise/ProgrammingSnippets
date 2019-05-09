package interview_questions.arrays;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class FrequencyQueries {
  /*
    This is a really broken hacker rank question. The main method can be modified to pass
    the test cases. This is done below in the method labeled modifiedMainMethod()

    You are given queries. Each query is of the form two integers described below:
    1- x: Insert x in your data structure.
    2- y: Delete one occurence of y from your data structure, if present.
    3- z: Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

    Complete the freqQuery function. It must return an array of integers where each element is a 1
    if there is at least one element value with the queried number of occurrences in the current array,
    or 0 if there is not.

     */

  // Complete the freqQuery function below.
  public static List<Integer> freqQuery(BufferedReader bufferedReader, int q) throws IOException {
    HashMap<Integer, Integer> valueKeyMap = new HashMap<>();
    HashMap<Integer, Set<Integer>> keyValueMap = new HashMap<>();
    ArrayList<Integer> results = new ArrayList<>();

    for (int i = 0; i < q; i++) {
      String[] query = bufferedReader.readLine().split(" ");
      int operation = Integer.parseInt(query[0]);
      int number = Integer.parseInt(query[1]);

      int oldCount = valueKeyMap.getOrDefault(number, 0);
      int newCount;

      if (operation == 1) {
        newCount = oldCount + 1;
        valueKeyMap.put(number, newCount);

        if (keyValueMap.containsKey(oldCount)) {
          keyValueMap.get(oldCount).remove(number);
        }
        keyValueMap.putIfAbsent(newCount, new HashSet<>());
        keyValueMap.get(newCount).add(number);
        continue;
      }

      if (operation == 2) {
        newCount = (oldCount > 1) ? oldCount - 1 : 0;
        valueKeyMap.put(number, newCount);

        if (keyValueMap.containsKey(oldCount)) {
          keyValueMap.get(oldCount).remove(number);
        }

        keyValueMap.putIfAbsent(newCount, new HashSet<>());
        keyValueMap.get(newCount).add(number);
        continue;
      }

      if (operation == 3) {
        if (number > q) results.add(0);
        else {
          if (number == 0 || keyValueMap.getOrDefault(number, Collections.emptySet()).size() > 0) {
            results.add(1);
          } else {
            results.add(0);
          }
        }
      }
    }

    return results;
  }

  public static void modifiedMainMethodMethod(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

      int q = Integer.parseInt(bufferedReader.readLine().trim());

      List<Integer> ans = freqQuery(bufferedReader, q);

      try (BufferedWriter bufferedWriter =
          new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

        bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");
      }
    }
  }
}
