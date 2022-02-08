#include <iostream>
#include <vector>

using namespace std;

vector<int> v;

int main(void) {
  v.push_back(4);
  v.push_back(1);
  v.push_back(3);
  v.push_back(2);

  sort(v.begin(), v.end());

  for (int i = 0; i < v.size(); ++i) {
    cout << v[i] << " ";
  }

  return 0;
}
