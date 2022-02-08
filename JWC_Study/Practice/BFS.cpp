#include <iostream>
#include <vector>
// 벡터 컨테이너는 그래프를 하나 만들기 위함
#include <queue>
// 실질적으로 BFS에서 사용하는 것

using namespace std;

int number = 9;
bool visit[9] = {false};
vector<int> graph[10];

void BFS(int start) {
  queue<int> q;
  q.push(start);
  visit[start] = true;

  while (!q.empty()) {
    int x = q.front();
    q.pop();

    cout << x << " ";

    for (int i = 0; i < graph[x].size(); ++i) {
      int y = graph[x][i];
      if (!visit[y]) {
        q.push(y);
        visit[y] = true;
      }
    }
  }
}

int main(void) {
  // 반대도 연결을 해주어야 하는 이유
  // 반대의 상황도 고려를 해야 한다.
  // 그래서 방문했던 것을 확인하는 것이고.
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

  BFS(1);

  return 0;
}
