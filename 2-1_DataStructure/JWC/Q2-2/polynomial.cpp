#include "polynomial.h"
#include <algorithm>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

void Polynomial::LoadPolynomial(std::string &filename) {
  ifstream file;
  file.open(filename);

  int time, temp1, temp2;
  file >> time;

  for (int i = 0; i < time; ++i) {
    file >> temp1;
    file >> temp2;

    v.push_back(pair<int, int>(temp2, temp1));
  }

  sort(v.rbegin(), v.rend());
}

void Polynomial::PrintPolynomial() {
  for (int i = 0; i < v.size(); ++i) {
    cout << v[i].second << " " << v[i].first << endl;
  }
}
