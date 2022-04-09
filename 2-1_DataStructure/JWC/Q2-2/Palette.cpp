#include <fstream>
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

int main(void) {
  Polynomial p;

  string filename;
  getline(cin, filename);

  p.LoadPolynomial(filename);
  p.PrintPolynomial();

  return 0;
}
