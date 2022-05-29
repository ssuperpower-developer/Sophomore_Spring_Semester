#include "graph.h"
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

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

  for (int vertexNumber = 0; vertexNumber < this->matrixSize; ++vertexNumber) {
    if (!this->visitedVertex[vertexNumber] &&
        (this->vertexDistance[vertexNumber] < minimumDistance)) {
      minimumDistance = this->vertexDistance[vertexNumber];
      returnVertexNumber = vertexNumber;
    }
  }

  return returnVertexNumber;
}

// Linear Search
// Time Complexity is AWFUL!!
// 0(n^2) Time Complextiy Happen!!
void Graph::graphSearch(int startVertex) {
  this->visitedVertex.assign(this->matrixSize, false);
  this->vertexDistance.resize(this->matrixSize);
  this->vertexWay.resize(this->matrixSize);
  this->visitedVertexRoute.resize(this->matrixSize);
  this->formerVisitedVertex.resize(this->matrixSize);

  for (int i = 0; i < this->matrixSize; ++i) {
    this->vertexDistance[i] = graphContainer[startVertex][i];
  }
  vertexDistance[startVertex] = 0;
  visitedVertex[startVertex] = true;
  formerVisitedVertex[startVertex] = -1;

  for (int i = 0; i < this->matrixSize - 1; ++i) {
    int currentVertexNumber = returnShortestDistanceVertex();
    // cout << "currentVertexNumber : " << currentVertexNumber << endl;
    this->visitedVertex[currentVertexNumber] = true;

    for (int j = 0; j < this->matrixSize; ++j) {
      if (!this->visitedVertex[j]) {
        if (this->vertexDistance[j] >
            this->vertexDistance[currentVertexNumber] +
                this->graphContainer[currentVertexNumber][j]) {
          formerVisitedVertex[j] = currentVertexNumber;

          this->vertexDistance[j] =
              this->vertexDistance[currentVertexNumber] +
              this->graphContainer[currentVertexNumber][j];
        }
      }
    }
  }
}

void Graph::PrintShortestPathWeight(int s) {
  this->graphSearch(s);

  for (int i = 0; i < this->vertexDistance.size(); ++i) {
    cout << this->vertexDistance[i] << endl;
  }
}

void Graph::SettingRoute(int finalVertex, int vertexNumber) {
  if (this->formerVisitedVertex[vertexNumber] == -1) {
    this->visitedVertexRoute[finalVertex].push_back(vertexNumber);
    return;
  } else {
    SettingRoute(finalVertex, formerVisitedVertex[vertexNumber]);
    this->visitedVertexRoute[finalVertex].push_back(vertexNumber);
  }
}

void Graph::PrintShortestPath(int s) {
  this->graphSearch(s);

  for (int i = 0; i < formerVisitedVertex.size(); ++i) {
    this->SettingRoute(i, i);
    // cout << formerVisitedVertex[i] << endl;
  }

  for (int i = 1; i < this->visitedVertexRoute.size(); ++i) {
    for (int j = 0; j < this->visitedVertexRoute[i].size(); ++j) {
      cout << visitedVertexRoute[i][j] << " ";
    }

    cout << endl;
  }
}
