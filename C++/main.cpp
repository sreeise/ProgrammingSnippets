/*
 * License: MIT
 * See LICENSE
 *
 * This is the main C++ file and includes the main method
 *
 * @author: sreeise
 */

#include <iostream>
#include <array>
#include <iomanip>
#include "headers/BasicClass/Account.h"
#include "headers/BasicClass/Savings.h"
#include "headers/BasicClass/Checking.h"
#include "headers/Vectors/BasicVector/BasicVector.h"
#include "headers/AddressOfAndPointers/ReferencesPointers.h"
#include "headers/NameSpaces/Accounts.h"
#include "headers/Templates/BasicTemplate.h"
#include "headers/InterviewQuestions/PairDifference.h"

// Using std without the std:: every time:
using namespace std;
using namespace account_types;

// The method name is not intentional at all...
void stdTest() {
  cout << "No std's here" << endl;

  // Using ful std name
  std::cout << "Using std::cout here" << endl;
}

// While << sends data to the output stream, >> sends the data provided.
void readInput() {
  cout << "enter a string" << endl;
  string input;
  cin >> input;
  cout << input << endl;
}

const size_t rows{2};
const size_t columns{3};

// Declare a method that is implemented later.
// Because C++ requires that we define methods before we use them we can define
// the function here but provide it's implementation later.
void implementLater();

void runImplementLater() {
  cout << "\n Calling method implementLater() which is implemented after main method:" << endl;
  implementLater();
}

// Arrays
// This method is shown in arrayUsage()
// To process the elements of a two-dimensional array, we use a nested loop in which the outer
// loop iterates through the rows and the inner loop iterates through the columns of a given row.
void printArray(const array<array<int, columns>, rows> &a) {
  // auto keyword, which tells the compiler to infer (determine) a variable’s data type
  // based on the variable’s initializer value
  for (auto const &row: a) {
    for (auto const &element: row) {
      cout << element << ' ';
    }
    cout << endl;
  }
}

// Arrays
void arrayUsage() {
  array<int, 12> c{};

  // Notes on size_t
  // It is a type able to represent the size of any object in bytes: size_t is the
  // type returned by the sizeof operator and is widely used in the standard library
  // to represent sizes and counts.

  for (size_t i{0}; i < c.size(); ++i) {
    c[i] = 0;
  }

  for (size_t j{0}; j < c.size(); ++j) {
    cout << setw(7) << j << setw(10) << c[j] << endl;
  }

  cout << "\nDeclaring and looping through arrays" << endl;
  // Other arrays;
  array<int, 5> n{32, 27, 64, 18, 95};
  cout << "Element" << setw(10) << "value" << endl;

  for (size_t i{0}; i < n.size(); ++i) {
    cout << setw(7) << i << setw(10) << n[i] << endl;
  }

  // Multidimensional arrays
  array<array<int, columns>, rows> array1{1, 2, 3, 4, 5, 6};
  array<array<int, columns>, rows> array2{1, 2, 3, 4, 5};

  printArray(array1);
  printArray(array2);
}

// Class Account
// See headers/BasicClass/Account.h
void createAccount() {
  // Declare a String to hold the account name
  string accountName;

  // Ask for account name
  cout << "Enter Account Name" << endl;
  cin >> accountName;

  // Create Account with accountName
  Account account{accountName};

  // Get and print the account name
  string name = account.getName();
  cout << name << endl;
}

void accountNameSpace() {
  CheckingAccount checkingAccount{"Checking", 100.00};
  cout << "Checking Account Name: " << checkingAccount.getAccountName() << endl;
  cout << "Checking Account Balance: " << checkingAccount.getBalance() << endl;
}

// Vectors
void vectorUsage() {
  // Vectors
  cout << "\nBasic vector:" << endl;
  std::vector<int> basicVector = {1, 2, 5, 2, 3};
  BasicVector vector1{basicVector};
  vector1.outputVector();
  vector1.printVectorSize();

  cout << "\nChange Vector in class:" << endl;
  std::vector<int> basicVector1 = {2, 3};
  vector1.setBasicVector(basicVector1);

  vector1.outputVector();
  vector1.printVectorSize();

  cout << "\nCopy basic vector and print" << endl;
  std::vector<int> basicCopy(10);
  vector1.copyBasicVector(basicCopy);
  for (int item : basicCopy) {
    cout << item << " ";
  }
}

void templateUsage() {
  Vector<string> vs(17);

  // Print the length of the vector
  cout << vs.size() << endl;

  Vector<int> vs2(5);

  // Set the value at index 0 in Vector to 3
  vs2.setValue(0, 3);

  // Print the value at index 0 in Vector
  cout << vs2.operator[](0) << endl;
}

// Up Casting and Down casting
// Down casting or demotion: Conversion errors are prevented by the normal casting or also defined as Demotion:
// Demotion (narrowing) The conversion of a value from a “higher” type to a “lower” type according
// to a programming language’s precedence of data types. Demotion may cause loss of information.
// Down casting allows determining type at runtime and acting as that object.
void upCastingAndDownCasting() {
  Account *account;
  Savings savings{"savings", 3000.00};
  Checking checking{"checking", 2000.00};

  // implicit casting
  account = &savings;

  cout << "Savings and Checking Account Names:" << endl;

  // We can access only variables/methods declared
  // using getAmount here would fail
  cout << account->getName() << endl;

  // Same thing here
  account = &checking;
  cout << account->getName() << endl;

  // Down casting
  cout << "Downcast account to checking and print amount:" << endl;
  Checking *checking1 = (Checking *) (account);
  cout << "Object checking1 after downcast. Amount: " << checking1->getAmount() << endl;

  // or
  cout << "Or using auto with down cast:" << endl;
  auto *checking2 = (Checking *) (account);
  cout << "Object checking2 after downcast with keyword auto. Amount: " << checking2->getAmount() << endl;
}

// Pointer and Address Of
void pointersAndAddressOf() {
  cout << "\n\nPointers" << endl;
  ReferencesPointers referencesPointers;

  cout << "Simple Address Of and Pointers" << endl;
  referencesPointers.simple_address_and_pointers();

  cout << "\nAddress Of and Pointers Continued" << endl;
  referencesPointers.pointerAndAddressOfInfoContinued();
}

// Enums
enum class Color {
    red,
    blue,
    green
};

void enumUsage() {
  Color col = Color::red;
}

// Main method
int main() {
  cout << "Programming-Reference!" << endl;

  // Basic Hello World!
  cout << "Hello World!" << endl;
  return 0;
}

void implementLater() {
  cout << "implemented later" << endl;
}
