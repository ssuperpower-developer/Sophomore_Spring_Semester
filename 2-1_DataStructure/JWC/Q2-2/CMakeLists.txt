cmake_minimum_required(VERSION 3.22)
project(Polynomial)

add_executable(Polynomial polynomial.cpp polynomial.h main.cpp)
target_compile_features(Polynomial PUBLIC cxx_std_17)

