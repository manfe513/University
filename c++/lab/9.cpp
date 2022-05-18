#include <iostream>
#include "9.h"

const int SIZE = 3;

int main() {

    int nums[] = {3,5,1};
    int sorted[] = {0,0,0};
    int ptr2=0;

    Tstack <int> stack(SIZE);

    for(int i=0; i<SIZE; i++) {
        if(nums[i]<sorted[ptr2] || sorted[ptr2] == 0)
    }
    stack.push(1);
    stack.push(5);
    stack.push(3);

    return 0;
}
