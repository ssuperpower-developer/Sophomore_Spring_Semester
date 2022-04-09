/*
#include<iostream>
#include<string>
#include "polynomial.h"
#include<fstream>

using namespace std;
int x = 0;

void Polynomial::LoadPolynomial(string& filename) {
	ifstream readFile;
	readFile.open(filename);
	int n = sizeof(readFile);
	value = new int[n];
	int a;
	if (readFile.is_open()) {
		for (x = 0;; x++) {
			if (readFile.eof()) break;
			else {
				readFile >> a;
				value[x] = a;
			}
		}
		int temp1 = 0, temp2 = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 2; j < x - i; j = j + 2) {
				if (value[j] < value[j + 2]) {
					swap(value[j], value[j + 2]);
					swap(value[j - 1], value[j + 1]);
				}
			}
		}
	}
	count = x;
	readFile.close();
	delete[] value;
}

void swap(int& a, int& b) {
	int temp1 = a;
	a = b;
	b = temp1;
}

void Polynomial::PrintPolynomial() {
	for (int i = 2; i < count + 1; i = i + 2) {
		if (value[i] > 99) {
			cout << "최대 99의 차수를 갖는 다항식만 저장할 수 있습니다.";
		}
	}
	for (int i = 1; i < count; i++) {
		cout << value[i] << " " << value[++i] << endl;
	}
}

void Polynomial::add(Polynomial a, Polynomial b) {
	count = 2;
	for (int i = 2; i < a.count + 2; i = i + 2) {
		for (int j = 2; j < b.count + 2; j = j + 2) {
			if (a.value[i] == b.value[j]) {
				if (a.value[i - 1] + b.value[j - 1] != 0) {
					value[count - 1] = a.value[i - 1] + b.value[j - 1];
					value[count] = a.value[i];
					count = count + 2;
				}
			}
		}
	}
	count = count - 2;
}
*/

#include<iostream>
#include<string>
#include "polynomial.h"
#include<fstream>

using namespace std;

void Polynomial::LoadPolynomial(string& filename) {
	ifstream readFile;
	readFile.open(filename);
	int n = sizeof(readFile);
	value = new int[n];
	int a;
	if (readFile.is_open()) {
		for (x;; x++) {
			if (readFile.eof()) break;
			else {
				readFile >> a;
				value[x] = a;
			}
		}
		int temp1 = 0, temp2 = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 2; j < x - i; j = j + 2) {
				if (value[j] < value[j + 2]) {
					swap(value[j], value[j + 2]);
					swap(value[j - 1], value[j + 1]);
				}
			}
		}
	}
	readFile.close();
	delete[] value;
}

void swap(int& a, int& b) {
	int temp1 = a;
	a = b;
	b = temp1;
}

void Polynomial::PrintPolynomial() {
	for (int i = 2; i < x / 2; i = i + 2) {
		if (value[x] > 99) {
			cout << "최대 99의 차수를 갖는 다항식만 저장할 수 있습니다.";
		}
	}
	for (int i = 1; i < x; i++) {
		cout << value[i] << " " << value[++i] << endl;
	}
}

void Polynomial::add(Polynomial a, Polynomial b) {
	count = 2;
	for (int i = 2; i < a.count + 1; i = i + 2) {
		for (int j = 2; j < b.count + 1; j = j + 2) {
			if (a.value[i] == b.value[j]) {
				if (a.value[i - 1] + b.value[j - 1] != 0) {
					value[count - 1] = a.value[i - 1] + b.value[j - 1];
					value[count] = a.value[i];
					count = count + 2;
				}
			}
		}
	}
	x = count - 2;
}