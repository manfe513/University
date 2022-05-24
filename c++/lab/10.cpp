#include "10-linked-list.h"
#include <iostream>

using namespace std;

struct Bus {
    int number;
    char* driver;
    int route;

public:
    Bus() {};

    Bus(int _number, char* _driver, int _route) {
        number = _number;
        driver = _driver;
        route = _route;
    }
};

void printList(const char* title, LinkedList<Bus> *list) {
    cout << endl << title << endl;

    Node<Bus> *c = list->start;

    while(c != nullptr) {
        cout << "Bus number = " << c->data.number << ", driver = " << c->data.driver << ", route = " << c->data.route << endl;
        c = c->next;
    }
}

int main() {

    auto *park = new LinkedList<Bus>;
    auto *route = new LinkedList<Bus>;

    park->first(1, *new Bus(1, "driver1", 11));
    park->add(2, *new Bus(2, "driver2", 22));
    park->add(3, *new Bus(3, "driver3", 33));

    printList("=== PARK ===", park);
    printList("=== ROUTE ===", route);

    Node<Bus> *removed2 = park->remove(2);
    route->add(2, removed2->data);

    printList("=== PARK (2 removed) ===", park);
    printList("=== ROUTE (2 added) ===", route);

    Node<Bus>* fromRoute = route->remove(2);
    park->add(2, fromRoute->data);
    printList("=== PARK (2 added back) ===", park);
    printList("=== ROUTE (2 removed) ===", route);



    return 0;
}