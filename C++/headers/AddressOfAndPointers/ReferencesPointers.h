#include <iostream>
#include <string>

using namespace std;
#ifndef C_REFERENCESPOINTERS_H
#define C_REFERENCESPOINTERS_H

/*
 References/Address Of and Pointers in C++
 Also see http://www.cplusplus.com/doc/tutorial/pointers/

 In an expression, prefix unary * means “contents of” and prefix unary & means “address of.”

 Note that the spaces and general location of pointers and references does not
 generally matter. For instance:

    int* pointer;

 is the exact same as

    int *pointer;


 References/Address Of

 The address of a variable can be obtained by preceding the name of a variable with an
 ampersand sign (&), known as address-of operator:

 val = &my_int;


 Pointers

 Note it is always better to check for nullptr:
    if (val == nullptr) {}
 - This assumes understanding of the stack and heap.

 Pointer Initialization
    When pointers are initialized, what is initialized is the address they point to
    (i.e., a_ptr), never the value being pointed (i.e., *a_ptr)

    An initialized pointer such as:

        int my_int = 10;
        int* pointer_to_my_int = &my_int;

        cout << pointer_to_my_int << endl; // Memory Address - the address being pointed to.
        cout << *pointer_to_my_int << endl; // Value of my_int

 Incrementing and Decrementing a Pointer:
    *p++   // same as *(p++): increment pointer, and dereference unincremented address
    *++p   // same as *(++p): increment pointer, and dereference incremented address
    ++*p   // same as ++(*p): dereference pointer, and increment the value it points to
    (*p)++ // dereference pointer, and post-increment the value it points to
 */

class ReferencesPointers {
public:
    void simple_address_and_pointers() {
      int value = 25; // Integer value of 25
      int *val = &value; // Initialize a pointer to value
      cout << value << "\n"; // => 25
      cout << val << "\n"; // => Address that val points to
      cout << *val; // => 25
    }

    void address_assignment() {
      // Declares the variable count to be a pointer of type int
      // of a pointer to an int.
      int *count;

      // Declare a variable with type int set to 5.
      int y{5};

      // Declare pointer variable. This just a nullptr for now.
      int *yPointer{nullptr};
      // Assign address of y to yPointer
      yPointer = &y;

      cout << "Pointer *yPointer: Indirection Operator:\nDeclaration: yPointer = &y" << endl;
      cout << "\nAddress of Pointer: " << yPointer << endl;
      cout << "Value of Pointer: " << *yPointer << endl;
    }

    void pointerAndAddressOfInfoContinued() {
      // Declares the variable count to be a pointer of type int
      // of a pointer to an int.
      int *count;

      // Declare a variable with type int set to 5.
      int y{5};

      // Declare pointer variable. This just a nullptr for now.
      int *yPointer{nullptr};

      // Assign address of y to yPointer
      yPointer = &y;
      // or
      count = &y;

      cout << "Pointer *yPointer: Indirection Operator:\nDeclaration: yPointer = &y" << endl;

      // The value of y
      cout << *yPointer << endl;

      // The Address that yPointer is pointing to
      cout << "\nAddress that yPointer points to: " <<
           yPointer << endl;

      // Pointer to the same variable
      cout << "\nPointer to same variable:\nDeclaration: count = &y" << endl;

      // The value of y
      cout << *count << endl;

      // The Address that count is pointing to
      cout << "\nAddress of count: " << count << endl;

      // Print the Address of y using the address of operator.
      cout << "\nAddress operator" << endl;
      cout << "Address of y is: " << &y << endl;
    }
};

#endif //C_REFERENCESPOINTERS_H
