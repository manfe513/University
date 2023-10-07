#include <iostream>
#include "9.h"

using namespace std;

const int SIZE = 3;
const int DELETED = 0;

void printArr(int a[], int SIZE) {

    for(int i=0; i<SIZE; i++) {
        cout << a[i] << " ";
    }

    cout << endl;
}

int getMin(int n[], int SIZE) {
    int min=n[0];
    int i=1;

    while(i<SIZE) {
        if(n[i] != DELETED && n[i]<min) min=n[i];
        i++;
    }

    return min;
}

int main() {

    int n1[] = {3,5,1};
    int n2[] = {0,0,0};
    int p1=0, p2=0;

    cout << "=== Before sorting ===" << endl;
    printArr(n1, SIZE);
    printArr(n2, SIZE);

    Tstack <int> s(SIZE);

    while(p2<SIZE) {
        int min = getMin(n1, SIZE);

        while(n1[p1]>min) {

            if(!s.isEmpty())
                if(s.peek()<min)
                    n2[p2++]=s.pop();

            if  (n1[p1] != DELETED) s.push(n1[p1++]);
            else p1++;
        }

        n2[p2++] = n1[p1];
        n1[p1] = DELETED;
        p1=0;

        while(!s.isEmpty()) n1[p1++]=s.pop();
        p1=0;
    }

    cout << "\n=== After sorting ===" << endl;
    printArr(n1, SIZE);
    printArr(n2, SIZE);

    return 0;
}
