#include "list.h"
#include <iostream>

using namespace std;

LinkedList::LinkedList() {
  nodeCount = 0;
  Node *node = new Node;

  head = node;
  tail = node;
}

void LinkedList::Append(int data) {
  Node *newBackNode = new Node;
  newBackNode->setData(data);

  newBackNode->linkFrontNode(tail);
  tail->linkBackNode(newBackNode);

  tail = newBackNode;

  ++nodeCount;
}

void LinkedList::Prepend(int data) {
  Node *newFrontNode = new Node;
  newFrontNode->setData(data);

  if (head->getNext() == nullptr) {
    newFrontNode->linkFrontNode(tail);
    tail->linkBackNode(newFrontNode);
    tail = newFrontNode;
  } else {
    Node *firstNode = head->getNext();
    newFrontNode->linkBackNode(firstNode);
    firstNode->linkFrontNode(newFrontNode);

    head->linkBackNode(newFrontNode);
    newFrontNode->linkFrontNode(head);
  }

  ++nodeCount;
}

int LinkedList::Length() { return nodeCount; }

void LinkedList::Print() {
  Node *node = head->getNext();
  while (node != nullptr) {
    cout << node->getData() << " ";
    node = node->getNext();
  }
  cout << endl;
}

void LinkedList::PrintReverse() {
  Node *node = tail;
  while (node != head) {
    cout << node->getData() << " ";
    node = node->getPrev();
  }
  cout << endl;
}
