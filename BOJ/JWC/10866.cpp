#include <deque>
#include <iostream>

using namespace std;

deque<int> dq;

int main(void) {
  int N, temp;
  string s;
  cin >> N;

  for (int i = 0; i < N; ++i) {
    cin >> s;

    if (s == "push_back") {
      cin >> temp;
      dq.push_back(temp);
    } else if (s == "push_front") {
      cin >> temp;
      dq.push_front(temp);
    } else if (s == "pop_front") {
      if (dq.empty()) {
        cout << -1 << endl;
        continue;
      }
      cout << dq.front() << endl;
      dq.pop_front();
    } else if (s == "pop_back") {
      if (dq.empty()) {
        cout << -1 << endl;
        continue;
      }
      cout << dq.back() << endl;
      dq.pop_back();
    } else if (s == "size") {
      cout << dq.size() << endl;
    } else if (s == "empty") {
      cout << dq.empty() << endl;
    } else if (s == "front") {
      if (dq.empty()) {
        cout << -1 << endl;
        continue;
      }
      cout << dq.front() << endl;
    } else if (s == "back") {
      if (dq.empty()) {
        cout << -1 << endl;
        continue;
      }
      cout << dq.back() << endl;
    }
  }

  return 0;
}
