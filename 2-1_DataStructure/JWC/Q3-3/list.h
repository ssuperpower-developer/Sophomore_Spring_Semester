#ifndef __LIST_H__
#define __LIST_H__

#include <iostream>

using namespace std;

class Node {
private:
  int data;
  Node *next;
  Node *prev;

public:
  Node() {
    int data = 0;
    next = prev = nullptr;
  }
  int getData() { return data; }
  Node *getNext() { return next; }
  Node *getPrev() { return prev; }
  void setData(int data) { this->data = data; }
  void linkBackNode(Node *node) { next = node; }
  void linkFrontNode(Node *node) { prev = node; }
};

class LinkedList {
private:
  Node *head;
  Node *tail;
  int nodeCount;

public:
  LinkedList();
  void Append(int data);
  void Prepend(int data);
  int Length();
  void Print();
  void PrintReverse();
};

#endif