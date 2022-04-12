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

pair<int, int> Polynomial::search(int idx, vector<pair<int, int>> v) {
  pair<int, int> temp;

  for (int i = 0; i < v.size(); ++i) {
    if (v[i].first == idx) {
      temp.first = v[i].first;
      temp.second = v[i].second;
      return temp;
    }
  }

  temp.first = 0;
  temp.second = 0;
  return temp;
}

void Polynomial::add(Polynomial a, Polynomial b) {
  vector<pair<int, int>> v1;
  vector<pair<int, int>> v2;

  if (a.returnHighDegree() > b.returnHighDegree()) {
    v1 = a.returnVector();
    v2 = b.returnVector();
  } else {
    v1 = b.returnVector();
    v2 = a.returnVector();
  }

  int HighDegree = v1[0].first;

  pair<int, int> p1, p2, temp;

  for (int i = HighDegree; i >= 0; --i) {
    p1 = search(i, v1);
    p2 = search(i, v2);

    if (p1.first == p2.first) {
      temp.first = p1.first;
      temp.second = p1.second + p2.second;
    } else {
      if (p1.first == 0) {
        temp.first = p2.first;
        temp.second = p2.second;
      } else if (p2.first == 0) {
        temp.first = p1.first;
        temp.second = p1.second;
      } else {
        //
      }
    }

    v.push_back(temp);
  }

  return;
}
