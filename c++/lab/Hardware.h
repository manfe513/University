#ifndef LAB_2_HARDWARE_H
#define LAB_2_HARDWARE_H

#include <winsock2.h>
#include <windows.h>
#include "wtypes.h"
#include "iptypes.h"
#include "iphlpapi.h"
#include "dxgi.h"
#include <iphlpapi.h>


#include "iostream"
#include <stdio.h>
#include <stdlib.h>
#include <wbemcli.h>

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

void showScreenSize() {
    int x = 0, y = 0; // screen size
    getScreenSize(x, y);
    cout << "=== SCREEN SIZE ===" << endl;
    cout << "Screen size is: x = " << x << ", y = " << y;
}

void makeBeep() {
    Beep(523,500); // 523 hertz (C5) for 500 milliseconds
}

void showSystemInfo() {
    SYSTEM_INFO siSysInfo;

    GetSystemInfo(&siSysInfo);

    cout << "=== SYSTEM INFO ===" << endl;
    printf("  Number of processors: %u\n", siSysInfo.dwNumberOfProcessors);
    printf("  Page size: %u\n", siSysInfo.dwPageSize);
    printf("  Processor type: %u\n", siSysInfo.dwProcessorType);
    printf("  Minimum application address: %lx\n", siSysInfo.lpMinimumApplicationAddress);
    printf("  Maximum application address: %lx\n", siSysInfo.lpMaximumApplicationAddress);
}

static float bytesToGb(DWORDLONG bytes) {
    return (float) (bytes / (float) 1024 / 1024 / 1024);
}

void showRamInfo() {
    MEMORYSTATUSEX memInfo;
    memInfo.dwLength = sizeof(MEMORYSTATUSEX);
    GlobalMemoryStatusEx(&memInfo);

    cout << "=== RAM INFO ===" << endl;
    printf("  Total virtual memory: %f Gb\n", bytesToGb(memInfo.ullTotalPageFile)); // bytes -> Gigabytes
    printf("  Total physical memory: %f Gb\n", bytesToGb(memInfo.ullTotalPhys));
    printf("  Total physical memory used: %f Gb\n", bytesToGb(memInfo.ullTotalPhys - memInfo.ullAvailPhys));
}

void asd() {

}

#endif //LAB_2_HARDWARE_H
