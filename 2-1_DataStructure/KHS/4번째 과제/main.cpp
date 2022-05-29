
#include <iostream>
#include <stack>

class List;

class pair;

class Node;


class pair {
public:
    pair(int classnum, int grade) {
        this->classnum = classnum;
        this->grade = grade;
    }

    pair() {}

    int grade = 0;
    int classnum = 0;
};

class Node {
    friend List;

private:
    Node() {}

    Node(int classnum, int grade) {
        data = pair(classnum, grade);
    }

    pair data;
    int num;
    Node *leftlink = nullptr;
    Node *rightlink = nullptr;

    ~Node();
};

class List {
private:
    Node *Head = nullptr;//루트 노드 아마 const여야하지 않을까 한번 루트는 영원한 루트
    Node *Temp;
    Node *Cmp;
    int checker;
public:
    List() {
    }

    void Add(int a, int b) {
        Node *temp = Head;
        if (temp == nullptr) {
            checker++;
            Head = new Node(a, b);
            Head->num = 0;
        } else {
            Temp = new Node(a, b);
            while (1) {
                if (Temp->data.classnum > temp->data.classnum) {
                    if (temp->rightlink == nullptr) {
                        temp->rightlink = Temp;
                        break;
                    }
                    else {
                        temp = temp->rightlink;
                    }
                } else if (Temp->data.classnum < temp->data.classnum) {
                    if (temp->leftlink == nullptr) {
                        temp->leftlink = Temp;
                        break;
                    }
                    else {
                        temp = temp->leftlink;
                    }
                }
            }
            Temp->num = checker;
            checker++;
        }
    }

    Node *Get(int key) {
        Node *temp = Head;
//        while (1) {
//            if (Temp->data.classnum > temp->data.classnum) {
//                if (temp->rightlink == nullptr){temp->rightlink = Temp;break;}
//                else {
//                    temp = temp->rightlink;
//                }
//            } else if (Temp->data.classnum < temp->data.classnum) {
//                if (temp->leftlink == nullptr){temp->leftlink = Temp;break;}
//                else {
//                    temp = temp->leftlink;
//                }
//            }
//        }
        while (1) {
            if (temp->data.classnum > key) {
                temp = temp->leftlink;
            } else if (temp->data.classnum < key) {
                temp = temp->rightlink;
            } else if (temp->leftlink == nullptr && temp->rightlink == nullptr) {//애매하네
                std::cout << "key가" << key << "에 해당하는 노드는 없습니다." << std::endl;
            } else {
                std::cout << "탐색한 노드는 " << "(" << temp->data.classnum << "," << temp->data.grade << ")" << std::endl;
                return temp;
            }
        }
    }

    void Delete() {

    }

    void inorder() {
        inorder(Head);
    }

    void inorder(Node *currentNode) {
        if (currentNode) {
            inorder(currentNode->leftlink);
            std::cout << currentNode->num << "번쨰 노드 " << "(" << currentNode->data.classnum << ","
                      << currentNode->data.grade << ")" << std::endl;
            inorder(currentNode->rightlink);
        }
    }
};

int main() {
    List a;//1
    a.Add(33, 90);
    a.Add(50, 73);
    a.Add(43, 99);
    a.Add(11, 82);
    a.Add(24, 78);
    a.Add(46, 96);
    a.Add(1, 72);
    a.Add(8, 88);
    a.Add(36, 77);
    a.Add(56, 93);
    a.Add(53, 82);
    a.Add(59, 100);
    a.inorder();
    a.Get(56);
    a.Get(43);
    return 0;
}


//    void inorder()//중위 순회 LVR
//    {
//        std::cout << "(" << Temp->data.classnum << "," << Temp->data.grade << ")" << std::endl;
//        std::stack<Node*> st;
//        Node *currentNode=Head;
//        while(1){
//            while(currentNode){
//                st.push(currentNode);
//                currentNode=currentNode->leftlink;
//            }
//            if (st.empty()) { return; }
//            currentNode=st.top();
//            st.pop();
//            std::cout << "(" << currentNode->data.classnum << "," << currentNode->data.grade << ")" << std::endl;
//            currentNode=currentNode->rightlink;
//        }
//
//
//    }