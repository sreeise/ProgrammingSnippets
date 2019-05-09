#include <string>
#include "Account.h"

using namespace std;
#ifndef C_REFERENCE_SAVINGS_H
#define C_REFERENCE_SAVINGS_H

class Savings : public Account {
public:
  explicit Savings(std::string accountName, double amount) : Account(accountName) {
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

#endif //C_REFERENCE_SAVINGS_H
