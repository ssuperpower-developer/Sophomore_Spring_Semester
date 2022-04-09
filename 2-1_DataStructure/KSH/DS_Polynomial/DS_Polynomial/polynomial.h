#pragma once
#include<iostream>
#include<string>
using namespace std;

class Polynomial
{
private:
	int n = 0;
	int* value;
	int x = 0;
	int count = 0;
	string str;
public:
	void LoadPolynomial(string& filename);
	void PrintPolynomial();
	void add(Polynomial a, Polynomial b);
};

