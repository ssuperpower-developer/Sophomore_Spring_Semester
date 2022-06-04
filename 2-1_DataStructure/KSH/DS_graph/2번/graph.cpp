#include<iostream>
#include<vector>
#include "graph.h"
#include<cstring>
#include<fstream>
using namespace std;

void Graph::LoadMatrix(std::string& filename) {
	ifstream readFile;
	readFile.open(filename);
	int a;
	if (readFile.is_open()) {
		while (!readFile.eof()) {
			readFile >> this->matrixSize;
			for (int i = 0; i < matrixSize; i++) {
				for (int j = 0; j < matrixSize; j++) {
					readFile >> a;
					matrix2.push_back(a);
				}
				matrix.push_back(matrix2);
				matrix2.clear();
			}
		}
	}
	readFile.close();
}

void Graph::PrintMatrix() {
	for (int i = 0; i < matrixSize; i++) {
		for (int j = 0; j < matrixSize; j++) {
			cout << matrix[i][j] << " ";
		}
		cout << endl;
	}
}

void Graph::SetShortestPathWeight(const int n, const int v) {
	//s.assign(n, false);
	for (int i = 0; i < n; i++) {
		s[i] = false;
		dist[i] = matrix[v][i];
		//dist.push_back(matrix[v][i]);
	}

	s[v] = true;
	dist[v] = 0;
	for (int i = 0; i < n - 2; i++) {
		int u = shortDist(n);
		if (u == -1) break;
		s[u] = true;
		for (int w = 0; w < n; w++) {
			if (!s[w] && dist[u] + matrix[u][w] < dist[w])
				dist[w] = dist[u] + matrix[u][w];
		}
	}
}

void Graph::PrintShortestPathWeight(int s) {
	SetShortestPathWeight(matrixSize, s);
	for(int i = 0; i < matrixSize; i++)
		cout << dist[i] << endl;
}

int Graph::GetSize() {
	return this->matrixSize;
}

int Graph::shortDist(int n) {
	int minIndex = -1;
	int minDist = 999;
	for (int i = 0; i < n; i++) {
		if (!s[i] && minDist > dist[i]) {
			minIndex = i;
			minDist = dist[i];
		}
	}
	return minIndex;
}




/*
int Graph::Choose(int n, int v) {
	vector<int> distMatrix;
	for (int w = 0; w < n; w++) {
		if (!s[w] && matrix[v][w] < 999) {
			distMatrix.push_back(dist[w]);
		}
	}
	return min_element()
	for (int i = 0; i < distMatrix.size() - 1; i++) {
		for (int j = i + 1; j < distMatrix.size(); j++) {
			if (distMatrix[i] > distMatrix[j]) {
				swap(distMatrix[i], distMatrix[j]);
			}
		}
	}
	return distMatrix[0];
}
*/