#pragma once
#include<iostream>
#include<vector>
using namespace std;

class Graph {
private:
	int matrixSize;
	vector<vector<int>> matrix;
	vector<int> matrix2;
	vector<int> dist;
	vector<int> s;
	vector<vector<int>> length;
	int x = 0;

public:
	int GetSize();
	int shortDist(int n);
	void LoadMatrix(std::string& filename);
	void SetShortestPathWeight(const int n, const int v);
	void PrintMatrix();
	void PrintShortestPathWeight(int s);
};