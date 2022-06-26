#ifndef __GRAPH_H__
#define __GRAPH_H__

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

public:
  Graph() : matrixSize(0) {}
  void LoadMatrix(string &filename);
  int GetSize();
  void PrintMatrix();
  void PrintShortestPathWeight(int s);
  void PrintShortestPath(int s);
};

#endif