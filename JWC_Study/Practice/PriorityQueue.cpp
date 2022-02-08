#include <iostream>
#include <queue>

using namespace std;

int main(void) {
  queue<int> q;
  q.push(1);
  q.push(9);
  q.push(5);

  cout << "Queue" << endl;
  while (!q.empty()) {
    cout << q.front() << " ";
    q.pop();
  }
  cout << endl;

  // Ascending
  priority_queue<int> pq1;
  pq1.push(1);
  pq1.push(9);
  pq1.push(5);

  while (!pq1.empty()) {
    cout << pq1.top() << " ";
    pq1.pop();
  }

  cout << "\n";

  // Descending
  priority_queue<int, vector<int>, greater<int>> pq2;
  pq2.push(1);
  pq2.push(9);
  pq2.push(5);

  while (!pq2.empty()) {
    cout << pq2.top() << " ";
    pq2.pop();
  }

  cout << "\n";

  return 0;
}
