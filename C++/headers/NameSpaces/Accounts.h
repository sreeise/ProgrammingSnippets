#include "BasicClass/Account.h"

using namespace std;

#ifndef C_NAMESPACEUSAGE_H
#define C_NAMESPACEUSAGE_H

namespace account_types {
    class SavingsAccount : public Account {
    public:
        explicit SavingsAccount(std::string accountName, double amount) : Account(accountName) {
          setBalance(amount);
        }

        void setBalance(double amount) {
          this->balance = amount;
        }

        double getBalance() {
          return this->balance;
        }

    private:
        double balance;
    };

    class CheckingAccount : public Account {
    public:
        explicit CheckingAccount(std::string accountName, double amount) : Account(accountName) {
          setAccountName(std::move(accountName));
          setBalance(amount);
        }

        void setAccountName(string accountName) {
          this->accountName = accountName;
        }

        string getAccountName() {
          return this->accountName;
        }

        void setBalance(double amount) {
          this->balance = amount;
        }

        double getBalance() {
          return this->balance;
        }

    private:
        string accountName;
        double balance{};
    };
}


#endif //C_NAMESPACEUSAGE_H
