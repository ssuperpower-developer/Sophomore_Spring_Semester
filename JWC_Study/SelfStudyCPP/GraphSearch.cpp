#include <iostream>
#include <queue>
#include <stack>
#include <vector>

#define SIZE 10

using namespace std;

vector<int> graph[SIZE];
bool visited1[SIZE] = {false};
bool visited2[SIZE] = {false};
bool visited3[SIZE] = {false};

void DFS_Recursive(int current) {
  visited1[current] = true;
  cout << current << " ";

  for (int i = 0; i < graph[current].size(); ++i) {
    int y = graph[current][i];
    if (!visited1[y])
      DFS_Recursive(y);
  }
}

void DFS_Stack(int start) {
  stack<int> s;

  visited2[start] = true;
  s.push(start);

  while (!s.empty()) {
    int x = s.top();
    // 스택에서 값을 빼지 못하면, 한 번 탐색했던 것에서 빠져나올 수가 없음
    s.pop();
    cout << x << " ";

    for (int i = 0; i < graph[x].size(); ++i) {
      int y = graph[x][i];

      if (!visited2[y]) {
        visited2[y] = true;
        s.push(y);
      }
    }
  }
}

void BFS(int start) {
  queue<int> q;

  q.push(start);
  visited3[start] = true;

  while (!q.empty()) {
    int x = q.front();
    q.pop();

    cout << x << " ";

    for (int i = 0; i < graph[x].size(); ++i) {
      int y = graph[x][i];
      if (!visited3[y]) {
        visited3[y] = true;
        q.push(y);
      }
    }
  }
}

int main(void) {
  // Connect 1, 2
  graph[1].push_back(2);
  graph[2].push_back(1);

  // Connect 1, 3
  graph[1].push_back(3);
  graph[3].push_back(1);

  // Connect 1, 4
  graph[1].push_back(4);
  graph[4].push_back(1);

  // Connect 2, 5
  graph[2].push_back(5);
  graph[5].push_back(2);

  // Connect 2, 6
  graph[2].push_back(6);
  graph[6].push_back(2);

  // Connect 5, 7
  graph[5].push_back(7);
  graph[7].push_back(5);

  cout << "DFS_Recursive" << endl;
  DFS_Recursive(4);
  cout << endl;

  cout << "DFS_Stack" << endl;
  DFS_Stack(1);
  cout << endl;

  cout << "BFS" << endl;
  BFS(4);
  cout << endl;

  return 0;
}
