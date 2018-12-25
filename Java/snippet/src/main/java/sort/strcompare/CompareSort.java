package sort.strcompare;

import java.util.Comparator;

public class CompareSort implements Comparator<KeyValueMap> {
  @Override
  public int compare(KeyValueMap a, KeyValueMap b) {
    if (a.num == b.num) {
      int strCompare = b.str.compareTo(a.str);
      if (strCompare < 0) {
        return -1;
      } else if (strCompare > 0) {
        return 1;
      }

      return 0;
    } else if (a.num > b.num) {
      return 1;
    } else {
      return -1;
    }
  }

  public int compareDesc(KeyValueMap a, KeyValueMap b) {
    if (a.num == b.num) {
      int strCompare = b.str.compareTo(a.str);
      if (strCompare < 0) {
        return 1;
      } else if (strCompare > 0) {
        return -1;
      }

      return 0;
    } else if (a.num > b.num) {
      return -1;
    } else {
      return 1;
    }
  }
}
