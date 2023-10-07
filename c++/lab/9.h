#ifndef LAB_2_9_H
#define LAB_2_9_H

#include <cstdio>

template <class T>
class Tstack
{
protected:
    int numItem;
    T *item;
public:
    Tstack(size_t size = 10)
    {
        numItem = 0;
        item = new T[size];
    }
    ~Tstack()
    {
        delete[] item;
    }
    void push(T t);
    T pop();
    T peek();
    bool isEmpty() {
        return numItem<=0;
    }
};

template <class T>
void Tstack <T>::push(T t)
{
    item[numItem++] = t;
}

template <class T>
T Tstack <T>::pop()
{
    return item[--numItem];
}

template <class T>
T Tstack <T>::peek()
{
    return item[numItem-1];
}

#endif //LAB_2_9_H
