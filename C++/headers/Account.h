//
// Created by sreeise on 7/9/18.
//
#include <string>
using namespace std;
#ifndef C_REFERENCE_ACCOUNT_H
#define C_REFERENCE_ACCOUNT_H
class Account {
public:
    // Class account constructor.
    // the line:
    // : name{accountName}
    // is a member initializer list. Each member initializer consists of a data member’s
    // variable name followed by parentheses containing the member’s initial value. In this example
    // The keyword 'explicit' is used to avoid implicit conversion. If there is only one parameter
    // in a constructor, and 'explicit' is not used, the compiler can do implicit conversion
    // which may cause issues with type coercion.
    explicit Account(std::string accountName) : name{accountName} {}

    // member function that sets the account name in the object
    void setName(std::string accountName) {
        name = accountName;
    }
    // The getName method is declared const because in the process of returning the name
    // the function should not modify the Account object on which it’s called.
    std::string getName() const {
        return name;
    }

    // Access specifier 'private'. Our private methods/variables only available
    // if we allow through the public interface of class Account.
    // By default, everything in a class is private, unless you specify otherwise.
private:
    std::string name;
};
#endif //C_REFERENCE_ACCOUNT_H
