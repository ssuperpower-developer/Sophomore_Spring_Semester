#include <iostream>

using namespace std;

int Combination(int n, int r) {
  if (r == 0 || n == r)
    return 1;
  else
    return Combination(n - 1, r - 1) + Combination(n - 1, r);
}

int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  int n, r;
  cin >> n >> r;

  cout << Combination(n, r) << endl;

  return 0;
}
