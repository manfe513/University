cmake_minimum_required(VERSION 3.21)
project(lab_2)

set(CMAKE_CXX_STANDARD 14)

add_executable(lab_2 2.cpp 5.cpp 6-stroka.cpp)
add_executable(lab_3 3.cpp)
add_executable(lab_4 4.cpp)
add_executable(lab_5 5.cpp)
add_executable(lab_6 6.cpp 6-stroka.cpp 6.h)
add_executable(lab_7 7.cpp)
add_executable(lab_8 8.cpp)
add_executable(lab_9 9.cpp 9.h)
add_executable(lab_10 10.cpp 10-linked-list.h)
add_executable(CourseProj CourseProj.cpp Hardware.h NetworkInterfaces.h)

target_link_libraries(CourseProj iphlpapi)
