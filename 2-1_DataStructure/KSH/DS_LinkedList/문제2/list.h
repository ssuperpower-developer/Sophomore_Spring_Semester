#pragma once
#include <iostream>

class Node {
private:
public:
	int data;
	Node* next;
	Node() {
		this->data = 0;
		this->next = NULL;
	}
};

class LinkedList {
public:
	LinkedList() {
		head = NULL;
	}
	Node* head = NULL;
	void Append(int data);
	void Prepend(int data);
	int Length();
	void Print();
};