#include <string>
#include "Account.h"

using namespace std;

//
// Created by sreeise on 7/16/18.
//

#ifndef C_REFERENCE_CHECKING_H
#define C_REFERENCE_CHECKING_H

class Checking : public Account {
public:
  explicit Checking(std::string accountName, double amount) : Account(accountName) {
    setAmount(amount);
  }

  void setAmount(double amount) {
    this->amount = amount;
  }

  double getAmount() {
    return this->amount;
  }

private:
  double amount;
};

#endif //C_REFERENCE_CHECKING_H
