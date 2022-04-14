#ifndef __POLYNOMIAL_H__
#define __POLYNOMIAL_H__

#define SIZE 100

#include <iostream>
#include <utility>
#include <vector>

using namespace std;

class Polynomial {
private:
  vector<pair<int, int>> v;

public:
  Polynomial() {}

  void LoadPolynomial(std::string &filename);
  void PrintPolynomial();
};

#endif
