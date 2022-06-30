#include <algorithm>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

class Graph {
private:
  int matrixSize;
  vector<vector<int>> graphContainer;
  vector<bool> visitedVertex;
  vector<int> formerVisitedVertex;
  vector<int> vertexDistance;
  vector<vector<int>> vertexWay;
  vector<vector<int>> visitedVertexRoute;

  int returnShortestDistanceVertex();
  void graphSearch(int startVertex);
  void SettingRoute(int finalVertex, int vertexNumber);
  void SettingRoute(int node);

public:
  Graph() : matrixSize(0) {}
  void LoadMatrix(string &filename);
  int GetSize();
  void PrintMatrix();
  void PrintShortestPathWeight(int s);
  void PrintShortestPath(int s);
};

void Graph::LoadMatrix(string &filename) {
  visitedVertex.clear();
  vertexDistance.clear();
  graphContainer.clear();

  ifstream file;
  file.open(filename);

  int temp;
  vector<int> container;
  file >> this->matrixSize;

  for (int i = 0; i < this->matrixSize; ++i) {
    for (int j = 0; j < this->matrixSize; ++j) {
      file >> temp;
      container.push_back(temp);
    }

    graphContainer.push_back(container);
    container.clear();
  }
}

int Graph::GetSize() { return matrixSize; }

void Graph::PrintMatrix() {
  for (int i = 0; i < this->matrixSize; ++i) {
    for (int j = 0; j < this->matrixSize; ++j) {
      cout << this->graphContainer[i][j] << " ";
    }
    cout << endl;
  }
}

int Graph::returnShortestDistanceVertex() {
  int minimumDistance = 1000;
  int returnVertexNumber;

  for (int vertexNumber = 0; vertexNumber < matrixSize; ++vertexNumber) {
    if (!visitedVertex[vertexNumber] &&
        (vertexDistance[vertexNumber] < minimumDistance)) {
      minimumDistance = vertexDistance[vertexNumber];
      returnVertexNumber = vertexNumber;
    }
  }

  return returnVertexNumber;
}

// Linear Search
// Time Complexity is AWFUL!!
// 0(n^2) Time Complextiy Happen!!
void Graph::graphSearch(int startVertex) {
  visitedVertex.assign(matrixSize, false);
  vertexDistance.resize(matrixSize);
  vertexWay.resize(matrixSize);
  visitedVertexRoute.resize(matrixSize);
  formerVisitedVertex.resize(matrixSize);

  for (int i = 0; i < matrixSize; ++i) {
    vertexDistance[i] = graphContainer[startVertex][i];
  }

  vertexDistance[startVertex] = 0;
  visitedVertex[startVertex] = true;

  // 시작 정점일 때, 이전 정점의 값을 세팅하는 지점
  formerVisitedVertex[startVertex] = -1;

  for (int i = 0; i < matrixSize - 1; ++i) {
    int currentVertexNumber = returnShortestDistanceVertex();
    visitedVertex[currentVertexNumber] = true;

    for (int j = 0; j < matrixSize; ++j) {
      if (!visitedVertex[j]) {
        if (vertexDistance[j] > vertexDistance[currentVertexNumber] +
                                    graphContainer[currentVertexNumber][j]) {
          formerVisitedVertex[j] = currentVertexNumber;

          vertexDistance[j] = vertexDistance[currentVertexNumber] +
                              graphContainer[currentVertexNumber][j];
        }

        /* vertexDistance[j] =
            min(vertexDistance[j], vertexDistance[currentVertexNumber] +
                                       graphContainer[currentVertexNumber][j]);
         */
      }
    }
  }
}

void Graph::PrintShortestPathWeight(int s) {
  graphSearch(s);

  for (int i = 0; i < vertexDistance.size(); ++i) {
    cout << vertexDistance[i] << endl;
  }
}

// Queue로 구현 가능
void Graph::SettingRoute(int finalVertex, int vertexNumber) {
  if (formerVisitedVertex[vertexNumber] == -1) {
    visitedVertexRoute[finalVertex].push_back(vertexNumber);
    return;
  } else {
    SettingRoute(finalVertex, formerVisitedVertex[vertexNumber]);
    visitedVertexRoute[finalVertex].push_back(vertexNumber);
  }
}

void Graph::PrintShortestPath(int s) {
  graphSearch(s);

  // Refactoring Point!!
  // 동일한 인덱스를 전달하는데, 파라미터의 인자를 줄일 수 있는 방법?
  for (int i = 0; i < formerVisitedVertex.size(); ++i) {
    SettingRoute(i, i);
  }

  // Refactoring Point!!
  // 시작정점이 0이 아닌 순간에서 예외가 발생한다. 
  for (int i = 0; i < visitedVertexRoute.size(); ++i) {
    if (visitedVertexRoute[i].size() == 0)
      break;
    for (int j = 0; j < visitedVertexRoute[i].size(); ++j) {
      cout << visitedVertexRoute[i][j] << " ";
    }

    cout << endl;
  }
}

int main(void) {
  Graph g;

  string filename = "input1.txt";
  g.LoadMatrix(filename);

  g.PrintShortestPathWeight(0);
  g.PrintShortestPath(0);

  return 0;
}