#include <cstring>
#include <iostream>
#include "6.h"

using namespace std;

// private
static int dlina(char *s1) {
    int i = 0;
    while (*s1++ != '\0') i++;
    return i;
}

static void copy(char *s1, char *s2) {

    int len = (strlen(s1) > strlen(s2)) ? strlen(s1) : strlen(s2);

    for (int i = 0; i <= len; i++) {
        s1[i] = s2[i];
    }
}

static int compare(char *str1, char *str2) {
    int maxLength = min(dlina(str1), dlina(str2));
    for (int i = 0; i < maxLength; i++) {
        if (str1[i] != str2[i]) return -1;
    }

    return 0;
}

static void concat(char *str1, char *str2) {
    int size1 = dlina(str1);
    char *r = new char[size1 + dlina(str2)];

    int i = 0;
    for (; i < size1; i++)
        r[i] = str1[i];

    int j = 0;
    while (str2[j] != '\0') r[i++] = str2[j++];

    copy(str1, r);
}

//public
Stroka::Stroka(char *s) {
    char *newStr = new char[::dlina(s)];
    str = newStr;
    copy(str, s);
}

Stroka::Stroka(const Stroka &s) {
    char *newStr = new char[::dlina(s.str)];
    str = newStr;
    copy(str, s.str);
}

Stroka &Stroka::operator=(const Stroka &s) {
    char *newStr = new char[::dlina(s.str)];
    str = newStr;
    copy(str, s.str);
    return *this;
}

Stroka &Stroka::operator+(const Stroka &s) {
    concat(str, s.str);
    return *this;
}

int Stroka::operator==(const Stroka &s) {
    return compare(str, (char *) s.str) == 0;
}

int Stroka::dlina() {
    return ::dlina(str);
}

void Stroka::vvod() {
    cout << "Enter str: " << endl;
    cin >> str;
}

void Stroka::vyvod() {
    cout << "str is: " << str << endl;
}

// >> Дополнение для ЛР №8
istream &operator>>(istream &is, Stroka &s) {
    char buff[1024];
    cin >> buff;
    s.str = new char[strlen(buff)];
    copy(s.str, buff);
    return is;
}

ostream &operator<< (ostream &os, Stroka &s) {
    cout << s.str;
    return os;
}