/*
 * Vector, queue, stack등등 다양한 자료구조에서 포문을 사용하여
 * 조금 비선호하는 것 같다.
 * 통상 empty() 함수를 사용하여 출력하는 것 같지만
 * 아래에서 발생하는 오류와 같이 함수를 언제 사용하느냐에 따라서 값이 달라진다.
 * */

#include <bits/stdc++.h>

using namespace std;

vector<int> v;
queue<int> q;
priority_queue<int> pq;

void pqinit(void) {
  pq.push(3);
  pq.push(67);
  pq.push(87);
  pq.push(9);
}

void qinit(void) {
  q.push(3);
  q.push(67);
  q.push(87);
  q.push(9);
}

void vinit(void) {
  v.push_back(3);
  v.push_back(98);
  v.push_back(51);
  v.push_back(9);
}

int main(void) {
  cout << "Vector Test" << endl;
  vinit();
  int size = v.size();
  for (int i = 0; i < size; ++i) {
    cout << v[i] << " ";
  }
  cout << endl;
  for (int i = 0; i < v.size(); ++i) {
    cout << v[i] << " ";
  }
  cout << endl;

  cout << "Queue Test" << endl;
  qinit();
  size = q.size();
  for (int i = 0; i < size; ++i) {
    cout << q.front() << " ";
    q.pop();
  }
  cout << endl;

  qinit();
  // 포문에서 저렇게 q.size() 함수를 사용하면 예상하는 대로 출력이 되지 않음
  for (int i = 0; i < q.size(); ++i) {
    cout << q.front() << " ";
    q.pop();
  }

  cout << endl;

  cout << "Priority Queue Test" << endl;
  pqinit();
  size = pq.size();
  for (int i = 0; i < size; ++i) {
    cout << pq.top() << " ";
    pq.pop();
  }
  cout << endl;

  pqinit();
  for (int i = 0; i < pq.size(); ++i) {
    cout << pq.top() << " ";
    pq.pop();
  }
  cout << endl;

  return 0;
}
