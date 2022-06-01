cmake_minimum_required(VERSION 3.22)

project(Graph) 

add_executable(Graph main.cpp graph.h graph.cpp)

target_compile_features(Graph PUBLIC cxx_std_17)