#include <iostream>

using namespace std;

#ifndef C_BASICTEMPLATE_H
#define C_BASICTEMPLATE_H

/*
 Source code from: The C++ Programming Language by Bjarne Stroustrup
 */

template<typename T>
class Vector {
private:
    T* elem;  // elem points to an array of sz elements of type T
    int sz;
public:
    Vector(int s);                   // constructor: establish invariant, acquire resources
    ~Vector() { delete[] elem; }     // destructor: release resources

    //... copy and move operations ...

    T& operator[](int i);
    const T& operator[](int i) const;

    int size() const { return sz; }
    void setValue(int index, T t);

    T* begin(Vector<T>& x);
    T* end(Vector<T>& x);

    // Vector of Strings
    void write(const Vector<string>& vs) {
      for (int i = 0; i!=vs.size(); ++i)
        cout << vs[i] << '\n';
    }
};

template<typename T>
Vector<T>::Vector(int s) {
  if (s<0) throw out_of_range{"Vector::operator[]"};
  elem = new T[s];
  sz = s;
}

template<typename T>
T &Vector<T>::operator[](int i) {
  if (i<0 || size()<=i)
    throw out_of_range{"Vector::operator[]"};
  return elem[i];
}

template<typename T>
const T& Vector<T>::operator[](int i) const {
  if (i<0 || size()<=i)
    throw out_of_range{"Vector::operator[]"};
  return elem[i];
}

template<typename T>
T *Vector<T>::begin(Vector<T> &x) {
  return x.size() ? &x[0]: nullptr;
}

template<typename T>
T *Vector<T>::end(Vector<T> &x) {
  return begin()+x.size();
}

template<typename T>
void Vector<T>::setValue(int index, T t) {
  elem[index] = t;
}

#endif //C_BASICTEMPLATE_H
