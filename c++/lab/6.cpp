#include <iostream>
#include "6.h"

using namespace std;

int main() {

    Stroka s1("qwert"), s3, s4(s1), s5;

    s3.vvod();
    s3="str3";
    s3.vyvod();

    cout << "Length of s5 = " << s5.dlina() << ", ";
    s5.vyvod();

    if(s1==s5) cout << "s1 == s5";
    else if(s1==s4) cout << "s1 == s4";

    return 0;
}


