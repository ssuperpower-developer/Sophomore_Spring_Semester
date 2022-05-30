#pragma once
#include<iostream>
#include<vector>
using namespace std;

class Graph {
private:
	int matrixSize;
	vector<int> matrix;
	int x = 0;
public:
	void LoadMatrix(std::string& filename);
	void PrintMatrix();
};