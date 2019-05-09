#ifndef C___PAIRDIFFERENCE_H
#define C___PAIRDIFFERENCE_H
#include<iostream>
#include<unordered_set>
using namespace std;
#include <bits/stdc++.h>

class PairDifference {
public:
    static int pairs(int k, vector<int> arr) {
      unordered_set<int> s;
      for (int i = 0; i < arr.size(); i++) {
        s.insert(arr[i]);
      }

      int ans = 0;
      for (auto it = s.begin(); it != s.end(); ++it) {
        if (s.find(*it + k) != s.end()) {
          ans++;
        }
      }

      return ans;
    }
};

#endif //C___PAIRDIFFERENCE_H
