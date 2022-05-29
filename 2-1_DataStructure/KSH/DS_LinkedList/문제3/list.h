#pragma once
#include <iostream>

class Node {
private:
public:
	int data;
	Node* next;
	Node* prev;
	Node() {
		this->data = 0;
		this->next = NULL;
		this->prev = NULL;
	}
};

class LinkedList {
public:
	LinkedList() {
	
	}
	Node* head = NULL;
	Node* tail = NULL;
	void Append(int data);
	void Prepend(int data);
	int Length();
	void Print();
	void PrintReverse();
};