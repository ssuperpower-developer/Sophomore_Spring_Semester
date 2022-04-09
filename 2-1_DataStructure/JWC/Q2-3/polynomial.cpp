#include "polynomial.h"
#include <algorithm>
#include <fstream>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;

void Polynomial::LoadPolynomial(std::string &filename) {
  ifstream file;
  file.open(filename);

  int temp1, temp2;
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
    if (v[i].second == 0)
      continue;
    cout << v[i].second << " " << v[i].first << endl;
  }
}

// Binary Search로 접근했지만 제대로 구현이 잘 안됨
pair<int, int> Polynomial::searchValue(pair<int, int> p1,
                                       vector<pair<int, int>> v2) {
  pair<int, int> temp;

  for (int i = 0; i < v2.size(); ++i) {
    if (v2[i].first == p1.first) {
      temp.second = p1.second + v2[i].second;
      if (temp.second == 0) {
        temp.first = 0;
        temp.second = 0;
        return temp;
      } else {
        temp.first = p1.first;
        return temp;
      }
    }
  }

  return p1;
}

void Polynomial::add(Polynomial a, Polynomial b) {
  vector<pair<int, int>> v1;
  vector<pair<int, int>> v2;

  if (a.returnTime() > b.returnTime()) {
    v1 = a.returnVector();
    v2 = b.returnVector();
  } else {
    v1 = b.returnVector();
    v2 = a.returnVector();
  }

  pair<int, int> temp;
  for (int i = 0; i < v1.size(); ++i) {
    temp = searchValue(v1[i], v2);
    v.push_back(pair<int, int>(temp.first, temp.second));
  }

  return;
}