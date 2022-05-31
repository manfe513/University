#include "iostream"
#include "Hardware.h"
#include "NetworkInterfaces.h"

using namespace std;

int main() {

    int n;
    while (true) {
        cout << "\nChoose option:" << endl;
        cout << "1. Show screen size" << endl;
        cout << "2. Make Beep" << endl;
        cout << "3. Show system info" << endl;
        cout << "4. Show RAM info" << endl;
        cout << "5. Show network adapters info" << endl;
        cout << "6. Exit" << endl << endl;

        cin >> n;


        switch (n) {
            case 1:
                showScreenSize();
                break;
            case 2:
                makeBeep();
                break;
            case 3:
                showSystemInfo();
                break;
            case 4:
                showRamInfo();
                break;
            case 5:
                showNetworkAdaptersInfo();
                break;
            case 6:
                exit(0);
            default:
                cout << "wrong option, try again..";
                break;
        }

        cout << endl;
    }
}