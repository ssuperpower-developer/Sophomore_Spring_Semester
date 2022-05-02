#include <iostream>
#include <vector>

using namespace std;

void PermutationWithRepetition(char *n, vector<char> r, unsigned int step) {
  if (step == r.size()) {
    for (unsigned int i = 0; i < r.size(); ++i) {
      cout << r[i];
    }
    cout << endl;

    return;
  }

  for (int i = 0; i < 2; ++i) {
    r[step] = n[i];
    PermutationWithRepetition(n, r, step + 1);
  }
}

int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  // Permutation with Repetition Algorithm
  char n[2] = {'a', 'b'};
  int size;
  cin >> size;
  vector<char> r(size);

  PermutationWithRepetition(n, r, 0);

  return 0;
}
