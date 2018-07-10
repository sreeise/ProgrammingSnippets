#include <iostream>
#include <array>
#include <iomanip>
#include "headers/Account.h"

// Using std without the std:: every time:
using namespace std;
// The method name is not intentional at all...
void stdTest() {
    cout << "No std's here" << endl;
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
// To process the elements of a two-dimensional array, we use a nested loop in which the outer
// loop iterates through the rows and the inner loop iterates through the columns of a given row.
void printArray(const array<array<int, columns>, rows>& a) {
    // auto keyword, which tells the compiler to infer (determine) a variable’s data type
    // based on the variable’s initializer value
    for (auto const& row: a) {
        for (auto const& element: row) {
            cout << element << ' ';
        }
        cout << endl;
    }
}

// The address operator (&) is a unary operator that obtains the memory address of its operand.
int y{5}; // Declare variable y
int* yPtr{nullptr}; // Declare pointer variable yPtr.



// Because C++ requires that we define methods before we use them we can define
// the function here but provide it's implementation later.
void implementLater();

int main() {
    std::cout << "Programming-Reference!" << std::endl;
    stdTest();
    readInput();
    string accountName;
    cin >> accountName;
    // Class usage see headers/Account.h
    Account account{accountName};
    string name = account.getName();
    cout << name << endl;

    // Arrays
    array<int, 12> c;

    // Notes on size_t
    // It is a type able to represent the size of any object in bytes: size_t is the
    // type returned by the sizeof operator and is widely used in the standard library
    // to represent sizes and counts.

    for (size_t i{0}; i< c.size(); ++i) {
        c[i] = 0;
    }

    for (size_t j{0}; j < c.size(); ++j) {
        cout << setw(7) << j << setw(10) << c[j] << endl;
    }


    implementLater();

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
    return 0;
}

// Conversion errors are prevented by the normal casting or alos defined as Demotion:
// Demotion (narrowing) The conversion of a value from a “higher” type to a “lower” type according
// to a programming language’s precedence of data types. Demotion may cause loss of information.



void implementLater() {
    cout << "implemented later" << endl;
}
