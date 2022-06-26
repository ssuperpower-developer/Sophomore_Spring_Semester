#pragma once
#include<iostream>
#include<vector>
using namespace std;

class Graph {
private:
	int matrixSize;
	vector<vector<int>> matrix;
	vector<int> matrix2;
	//vector<int> dist;
	//vector<bool> s;
	int dist[1000];
	bool s[1000];
	int x = 0;

public:
	int GetSize();
	int shortDist(int n);
	void LoadMatrix(std::string& filename);
	void SetShortestPathWeight(const int n, const int v);
	void PrintMatrix();
	void PrintShortestPathWeight(int s);
};