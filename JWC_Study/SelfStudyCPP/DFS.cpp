#include <iostream>
#include <stack>
#include <vector>

using namespace std;

// index 0은 사용하지 않음으로 배열을 하나 더 추가
bool visited1[9];
bool visited2[9];
vector<int> graph[9];

void DFS_Recursive(int x) {
  visited1[x] = true;
  cout << x << " ";
  for (int i = 0; i < graph[x].size(); i++) {
    int y = graph[x][i];
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

int main(void) {
  // 무방향 그래프
  // 연결된 노드끼리에서 작용하는 법칙은 더 작은 수에 먼저 간다.
  // Connect 1, 2
  graph[1].push_back(2);
  graph[2].push_back(1);

  // Connect 1, 8
  graph[1].push_back(8);
  graph[8].push_back(1);

  // Connect 1, 3
  graph[1].push_back(3);
  graph[3].push_back(1);

  // Connect 2, 7
  graph[2].push_back(7);
  graph[7].push_back(2);

  // Connect 7, 6
  graph[7].push_back(6);
  graph[6].push_back(7);

  // Connect 3, 4
  graph[3].push_back(4);
  graph[4].push_back(3);

  // Connect 3, 5
  graph[3].push_back(5);
  graph[5].push_back(3);

  // Connect 4, 5
  graph[4].push_back(5);
  graph[5].push_back(4);

  // 위와 같이 연결한 방법으로의 탐색순서 원리가 궁금하다
  cout << "DFS_Recursive" << endl;
  DFS_Recursive(1);
  cout << endl;

  cout << "DFS_Stack" << endl;
  DFS_Stack(1);
  cout << endl;
}
