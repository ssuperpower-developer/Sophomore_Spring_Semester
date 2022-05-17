#include "list.h"
#include <iostream>
using namespace std;

int listSize = 0;

void LinkedList::Append(int data) {
	Node* newNode = new Node();
	newNode->data = data;
	if (head == NULL) {
		head = newNode;
		tail = newNode;
	}
	else {
		tail->next = newNode;
		newNode->prev = tail;
		tail = newNode;
	}
	listSize++;
}

void LinkedList::Prepend(int data) {
	Node* newNode = new Node();
	newNode->data = data;
	if (head == NULL) {
		head = newNode;
		tail = newNode;
	}
	else {
		newNode->next = head;
		head->prev = newNode;
		head = newNode;
	}
	listSize++;
}

int LinkedList::Length() {
	return listSize;
}

void LinkedList::Print() {
	if (head == NULL) cout << "값 없음" << endl;
	else {
		cout << head -> data << " ";
		while (head -> next != NULL) {
			head = head->next;
			cout << head -> data << " ";
		}
	}
	cout << endl;
}

void LinkedList::PrintReverse() {
	if (head == NULL) cout << "값 없음" << endl;
	else {
		cout << tail->data << " ";
		while (tail->prev != NULL) {
			tail = tail->prev;
			cout << tail->data << " ";
		}
	}
	cout << endl;
}