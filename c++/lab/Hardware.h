#ifndef LAB_2_HARDWARE_H
#define LAB_2_HARDWARE_H

#include <winsock2.h>
#include <windows.h>
#include "wtypes.h"
#include "iptypes.h"
#include "iphlpapi.h"
#include "dxgi.h"
#include "iostream"



#include <iphlpapi.h>
#include <stdio.h>
#include <stdlib.h>
#pragma comment(lib, "IPHLPAPI.lib")

#define MALLOC(x) HeapAlloc(GetProcessHeap(), 0, (x))
#define FREE(x) HeapFree(GetProcessHeap(), 0, (x))

using namespace std;

void getScreenSize(int& x, int& y)
{
    RECT desktop;
    // Get a handle to the desktop window
    const HWND hDesktop = GetDesktopWindow();
    // Get the size of screen to the variable desktop
    GetWindowRect(hDesktop, &desktop);
    // The top left corner will have coordinates (0,0)
    // and the bottom right corner will have coordinates
    // (horizontal, vertical)
    x = desktop.right;
    y = desktop.bottom;
}

void printScreenSize() {
    int x = 0, y = 0; // screen size
    getScreenSize(x, y);
    cout << "Screen size is: x = " << x << ", y = " << y;
}

void makeBeep() {
    Beep(523,500); // 523 hertz (C5) for 500 milliseconds
}

void showSystemInfo() {
    SYSTEM_INFO siSysInfo;

    // Copy the hardware information to the SYSTEM_INFO structure.

    GetSystemInfo(&siSysInfo);

    // Display the contents of the SYSTEM_INFO structure.

    printf("Hardware information: \n");
    printf("  Number of processors: %u\n",
           siSysInfo.dwNumberOfProcessors);
    printf("  Page size: %u\n", siSysInfo.dwPageSize);
    printf("  Processor type: %u\n", siSysInfo.dwProcessorType);
    printf("  Minimum application address: %lx\n",
           siSysInfo.lpMinimumApplicationAddress);
    printf("  Maximum application address: %lx\n",
           siSysInfo.lpMaximumApplicationAddress);
}

void showNetworkAdapterInfo() {

}


#endif //LAB_2_HARDWARE_H
