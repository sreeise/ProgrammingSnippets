//
// Created by sreeise on 5/16/19.
//

#ifndef C___PAIRSUM_H
#define C___PAIRSUM_H

#include <array>
#include <vector>
#include <unordered_set>

using namespace std;

class PairSum {
public:
    static bool hasPairSum(const vector<int>& data, int sum) {
      unordered_set<int> comp;
      for (int value: data) {
        if (comp.find(value) != comp.end()) {
          return true;
        }
        comp.insert(sum - value);
      }

      return false;
    }
};


#endif //C___PAIRSUM_H
