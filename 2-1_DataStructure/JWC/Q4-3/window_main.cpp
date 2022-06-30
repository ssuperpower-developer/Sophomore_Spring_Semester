// I don't know why include cpp file
#include "graph.cpp"
#include "graph.h"
#include <iostream>

using namespace std;

int main(void) {
  Graph g;

  string filename = "input1.txt";
  cout << "g.LoadMatrix" << endl;
  g.LoadMatrix(filename);
  cout << endl;

  cout << "g.PrintMatrix" << endl;
  g.PrintMatrix();
  cout << endl;

  cout << "PrintShortestPath" << endl;
  g.PrintShortestPath(0);
  cout << endl;

  cout << "PrintShortestPathWeight" << endl;
  g.PrintShortestPathWeight(0);
  cout << endl;

  return 0;
}