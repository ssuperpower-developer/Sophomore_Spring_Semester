#include <iostream>

#define SIZE 100000

using namespace std;

int cnt = 0;

int BSearch(int *ary, int len, int n) {
  int first = 0, end = len - 1, mid;

  while (first <= end) {
    ++cnt;
    mid = (first + end) / 2;

    if (n == ary[mid]) {
      return mid;
    } else {
      if (n < ary[mid])
        end = mid - 1;
      else if (n > ary[mid])
        first = mid + 1;
    }
  }
  return -1;
}

int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  int len, ary[SIZE], n;

  cin >> len;
  for (int i = 0; i < len; ++i)
    cin >> ary[i];
  cin >> n;

  cout << BSearch(ary, len, n) << endl;
  cout << cnt << endl;

  return 0;
}
