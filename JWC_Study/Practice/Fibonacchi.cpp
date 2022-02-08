#include <iostream>

using namespace std;

int dp[100] = {0};

int Fibo(int n) {
  if (n == 0)
    return dp[0] = 0;
  else if (n == 1)
    return dp[1] = 1;
  else if (dp[n])
    return dp[n];

  return dp[n] = Fibo(n - 1) + Fibo(n - 2);
}

int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  int n;
  cin >> n;

  cout << Fibo(n) << endl;

  return 0;
}
