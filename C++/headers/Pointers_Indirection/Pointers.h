//
// Created by sreeise on 7/16/18.
//
#include <iostream>
#include <string>

using namespace std;
#ifndef C_REFERENCE_POINTERS_H
#define C_REFERENCE_POINTERS_H

class Pointers {
public:

  void basicPointerInfo() {
    // Declares the variable count to be a pointer of type int
    // of a pointer to an int.
    int *count;

    // Declare a variable with type int
    int y{5};
    // Declare pointer variable
    int *yPointer{nullptr};

    // Assign address of y to yPointer
    yPointer = &y;
    // or
    count = &y;

    cout << "Pointer *yPointer: Indirection Operator:\nDeclaration: yPointer = &y" << endl;
    cout << *yPointer << endl;
    cout << "\nValue of yPointer: " <<
         yPointer << endl;
    cout << "\nAlso pointer to same variable:\nDeclaration: count = &y" << endl;
    cout << *count << endl;

    cout << "\nValue of count: " <<
         count << endl;

    cout << "\nAddress operator" << endl;
    cout << "Address of y is: " << &y << endl;
  }
};

#endif //C_REFERENCE_POINTERS_H
