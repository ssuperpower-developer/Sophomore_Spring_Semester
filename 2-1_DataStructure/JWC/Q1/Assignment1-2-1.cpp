#include <iostream>
#include <vector>

#define SIZE 16

using namespace std;

void PermutationWithRepetition(char *n, char *r, int size, int step) {
  if (step == size) {
    for (int i = 0; i < size; ++i) {
      cout << r[i];
    }
    cout << endl;

    return;
  }

  for (int i = 0; i < 2; ++i) {
    r[step] = n[i];
    PermutationWithRepetition(n, r, size, step + 1);
  }
}

int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  char n[2] = {'a', 'b'};
  int size;
  cin >> size;
  char r[SIZE];

  PermutationWithRepetition(n, r, size, 0);

  return 0;
}
