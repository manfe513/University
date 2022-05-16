#include <string.h>
#include <iostream>

using namespace std;

int dlina1(char *str) {
    int i= 0;
    while(*str++ != '\0') i++;
    return i;
}

int dlina2(char *str) {
    int i = 0, size = 0;
    while (str[i++] != '\0') size++;
    return size;
}

int dlina3(char *p) {

    char *q = p;

    while (*q++ != '\0');

    return q - p -1;
}

void copy(char *str1, char *str2) {
    strcpy(str1, str2);
}

void compare(char *str1, char *str2) {
    strcmp(str1, str2);
}

void concat(char *str1, char *str2) {
    strcat(str1, str2);
}

void process(char str1[], char str2[]) {
    cout << "str1 = " << str1 << ", str2 = " << str2 << endl;

    cout << "dlina1: str1 = " << dlina1(str1) << ", str2 = " << dlina1(str2) << endl;
    cout << "dlina2: str1 = " << dlina2(str1) << ", str2 = " << dlina2(str2) << endl;
    cout << "dlina3: str1 = " << dlina3(str1) << ", str2 = " << dlina3(str2) << endl;

    copy(str1, str2);
    cout << "after copying: str1 = " << str1 << ", str2 = " << str2 << endl;

    compare(str1, str2);
    cout << "after compare: str1 = " << str1 << ", str2 = " << str2 << endl;

    concat(str1, str2);
    cout << "after concat: str1 = " << str1 << ", str2 = " << str2 << endl;

    cout << endl;
}

void initial() {
    char str1[] = "qwerty", str2[] = "1234567890";
    process(str1, str2);
}

void malloc() {
    cout << "=== 3. malloc ===" << endl;

    char *str1, *str2;

    str1 = (char *) malloc(100);
    str2 = (char *) malloc(100);

    process(str1, str2);

    free(str1);
    free(str2);
}

void calloc() {
    cout << "=== 4. calloc ===" << endl;

    char *str1, *str2;

    str1 = (char *) calloc(100, sizeof(char));
    str2 = (char *) calloc(100, sizeof(char));

    process(str1, str2);

    free(str1);
    free(str2);
}

void stringArr() {
    cout << "=== 5. Array of strings ===" << endl;

    char *strs[] = {"123", "456", "789"};

    for (char *s: strs) {
        cout << "dlina1: s = " << dlina1(s) << endl;
        cout << "dlina2: s = " << dlina2(s) << endl;
        cout << "dlina3: s = " << dlina3(s) << endl;
    }

    copy(strs[0], strs[1]);
    cout << "after copying: strs[0] = " << strs[0] << ", strs[1] = " << strs[1] << endl;

    compare(strs[0], strs[1]);
    cout << "after compare: strs[0] = " << strs[0] << ", strs[1] = " << strs[1] << endl;

    concat(strs[0], strs[1]);
    cout << "after concat: strs[0] = " << strs[0] << ", strs[1] = " << strs[1] << endl;
}

int main() {

    // 1. initial
//    initial();

    // 3. malloc
    malloc();

    // 4. calloc
    calloc();

    // 5. string array
    stringArr();

    return 0;
}

