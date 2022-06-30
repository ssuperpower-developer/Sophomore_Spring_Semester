#include "graph.cpp"
#include "graph.h"
#include <iostream>

using namespace std;

int main(void) {
  Graph g;

  string filename = "input1.txt";
  g.LoadMatrix(filename);
  g.PrintMatrix();

  return 0;
}