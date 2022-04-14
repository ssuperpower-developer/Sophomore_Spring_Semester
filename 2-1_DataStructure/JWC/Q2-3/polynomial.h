#ifndef __POLYNOMIAL_H__
#define __POLYNOMIAL_H__

#include <fstream>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;

class Polynomial {
private:
  int time;
  vector<pair<int, int>> v;
  pair<int, int> search(int idx, vector<pair<int, int>> v);
  vector<pair<int, int>> returnVector() { return v; }
  int returnTime() { return time; }
  int returnHighDegree() { return v[0].first; }

public:
  Polynomial() {}

  void LoadPolynomial(std::string &filename);
  void PrintPolynomial();
  void add(Polynomial a, Polynomial b);
};

#endif
