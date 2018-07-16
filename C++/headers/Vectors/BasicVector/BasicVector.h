//
// Created by sreeise on 7/16/18.
//
#include <iostream>
#include <iomanip>
#include <vector>
#include <stdexcept>

using namespace std;
#ifndef C_REFERENCE_BASICVECTOR_H
#define C_REFERENCE_BASICVECTOR_H

class BasicVector {
public:

  vector<int> &basicVector;

  BasicVector(vector<int> &basicVector) : basicVector{basicVector} {}

  void setBasicVector(vector<int> &output) {
    BasicVector::basicVector = output;
  }

  vector<int> &getBasicVector() {
    return basicVector;
  }

  void outputVector() {
    for (int item : basicVector) {
      cout << item << " ";
    }
  }

  void inputVector(vector<int> &items) {
    for (int &item : items) {
      cin >> item;
    }
  }

  void copyBasicVector(vector<int> &copy) {
    copy = basicVector;
  }

  void printVectorSize() {
    cout << "\nBasic vector size: " << basicVector.size() << "\n" << endl;
  }
};

#endif //C_REFERENCE_BASICVECTOR_H
