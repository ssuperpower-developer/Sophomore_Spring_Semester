#include "list.h"
#include <iostream>
using namespace std;

int listSize = 0;
Node* tail = NULL;

void LinkedList::Append(int data) {
	Node* newNode = new Node();
	newNode->data = data;
	newNode->next = NULL;
	if (head == NULL) head = newNode;
	else tail->next = newNode;
	tail = newNode;
	listSize++;
}

void LinkedList::Prepend(int data) {
	Node* newNode = new Node();
	newNode->data = data;
	if (head == NULL) head = newNode;
	else {
		newNode->next = head;
		head = newNode;
	}
	listSize++;
}

int LinkedList::Length() {
	return listSize;
}

void LinkedList::Print() {
	if (head == NULL) cout << "°ª ¾øÀ½" << endl;
	else {
		cout << head -> data << " ";
		while (head -> next != NULL) {
			head = head->next;
			cout << head -> data << " ";
		}
	}
	cout << endl;
}