#include <conio.h>
#include <cstdio>
#include <cstdlib>
#include <dos.h>
#include <iostream>

using namespace std;

//наследование
// вирт функции

class A {
public:
    int numA = 0;
    A() {};
    A(int _numA) {
        numA = _numA;
    };
    virtual void func1() {
        cout << ">> A: func1" << endl;
    }
};

class B: public A {
public:
    char chB = '0';
    B() : A(){};
    B(char _chB) : A() {
        chB = _chB;
    };
    void func1() {
        cout << ">> B: func1" << endl;
    }
};

class C: public B{
public:
    char *str;
    C() : B() {};
    C(char *_str) : B() {
        str = _str;
    }
    void func1() {
        cout << ">> C: func1" << endl;
    }
};


int main()
{
    A a(10);
    B b('a');
    C c("some text");

    // Вызов будет передан в класс-наследник
    A *ptr1 = &b;
    cout << "=== A *ptr1 = &b; ptr1->func1() ===" << endl;
    ptr1->func1();

    B *ptr2 = &c;
    cout << "\n=== B *ptr2 = &c; ptr2->func1() ===" << endl;
    ptr2->func1();


    // Отключение механизма виртуальных функций
    cout << "\n=== ptr1->A::func1() ===" << endl;
    ptr1->A::func1();

    cout << "\n=== ptr2->B::func1() ===" << endl;
    ptr2->B::func1();

    return 0;
}







