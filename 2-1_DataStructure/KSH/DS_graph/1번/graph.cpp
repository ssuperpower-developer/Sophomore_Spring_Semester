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
		for (x;; x++) {
			if (readFile.eof()) break;
			else {
				readFile >> a;
				matrix.push_back(a);
			}
		}
	}
	readFile.close();
}

void Graph::PrintMatrix() {
	for (int i = 1; i < x - 1; i++) {
		cout << matrix[i] << " ";
		if (i % matrix[0] == 0) cout << endl;
	}
}