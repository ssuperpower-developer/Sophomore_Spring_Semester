
#include <iostream>
#include <stack>
#include <tuple>

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
//    ~Node(){delete this;};

    Node(int classnum, int grade) {
        data = pair(classnum, grade);
    }

    pair data;
    Node *leftlink = nullptr;
    Node *rightlink = nullptr;
};

class List {
private:
    Node *Head = nullptr;//루트 노드 아마 const여야하지 않을까 한번 루트는 영원한 루트
    Node *Temp = nullptr;
public:
    List() {
    }

    void insert(int a, int b) {
        Node *temp = Head;
        if (temp == nullptr) {
            Head = new Node(a, b);
        } else {
            Temp = new Node(a, b);
            while (1) {
                if (Temp->data.classnum > temp->data.classnum) {
                    if (temp->rightlink == nullptr) {
                        temp->rightlink = Temp;
                        break;
                    } else {
                        temp = temp->rightlink;
                    }
                } else if (Temp->data.classnum < temp->data.classnum) {
                    if (temp->leftlink == nullptr) {
                        temp->leftlink = Temp;
                        break;
                    } else {
                        temp = temp->leftlink;
                    }
                }
            }
        }
    }

    std::tuple<Node *, Node *> Get(int key) {
        Node *temp = Head;
        Node *follower = Head;
        while (1) {
            if (temp == nullptr) {
                std::cout << "탐색한 노드는 없습니다" << std::endl;
                break;
            }
            if (temp->data.classnum > key) {
                follower = temp;
                temp = temp->leftlink;
            } else if (temp->data.classnum < key) {
                follower = temp;
                temp = temp->rightlink;
            } else {
                std::cout << "탐색한 노드는 " << "(" << temp->data.classnum << "," << temp->data.grade << ")" << std::endl;
                return std::tuple<Node *, Node *>(temp, follower);
            }
        }
        return std::tuple<Node *, Node *>(nullptr, nullptr);
    }


    void Delete(int key) {
        std::tuple<Node *, Node *>(result) = Get(key);//temp, follower, Get 함수 접근
        Node *tempNode = std::get<0>(result);
        Node *followingNode = std::get<1>(result);
        Node *projectNode;
        Node *parentprojectNode;
        std::cout << "삭제를 목표하는 노드 " << "(" << tempNode->data.classnum << "," << tempNode->data.grade << ")"
                  << std::endl;
        std::cout << "그 노드의 부모 노드" << "(" << followingNode->data.classnum << "," << followingNode->data.grade << ")"
                  << std::endl;

        if (tempNode->rightlink == nullptr && tempNode->leftlink == nullptr) {//자식이 없는 경우의 삭제
            if ((tempNode->data.classnum) > (followingNode->data.classnum)) {
                followingNode->rightlink = nullptr;
                delete tempNode;
            } else {
                followingNode->leftlink = nullptr;
            }
        } else if (tempNode->rightlink == nullptr && tempNode->leftlink != nullptr) {//삭제할 노드의 우는 비고, 좌는 안빔
            if (followingNode->data.classnum > tempNode->rightlink->data.classnum) {
                followingNode->leftlink = tempNode->rightlink;
            } else {
                followingNode->leftlink = tempNode->leftlink;
            }
            delete tempNode;
        } else if (tempNode->rightlink != nullptr && tempNode->leftlink == nullptr) {//삭제할 노드의 우는 차고, 좌는 빔
            if (followingNode->data.classnum > tempNode->rightlink->data.classnum) {
                followingNode->rightlink = tempNode->leftlink;
            } else {
                followingNode->rightlink = tempNode->rightlink;
            }
            delete tempNode;
        } else {//삭제할 노드가 자식이 2명
            std::tuple<Node *, Node *>(findresult) = findrightMin(tempNode);
            projectNode = std::get<0>(findresult);
            parentprojectNode = std::get<1>(findresult);
            std::cout << "삭제 될 노드를 대체할 우측 트리에서의 가장 작은 노드는 " << "(" << projectNode->data.classnum << ","
                      << projectNode->data.grade << ")" << std::endl;
            std::cout << "삭제 될 노드를 대체할 노드의 부모 노드 " << "(" << parentprojectNode->data.classnum << ","
                      << parentprojectNode->data.grade << ")" << std::endl;
            tempNode->data.classnum = projectNode->data.classnum;//목표하는 노드 초기화 진행
            tempNode->data.grade = projectNode->data.grade;
            if (parentprojectNode->leftlink == projectNode) {
                parentprojectNode->leftlink = nullptr;
                delete projectNode;
            }
            else {
                parentprojectNode->rightlink = nullptr;
                delete projectNode;
            }
        }
    }

    std::tuple<Node *, Node *> findrightMin(Node *currentNode) {
        currentNode = currentNode->rightlink;
        Node *followingNode = currentNode;
        while (currentNode != nullptr) {
            if (currentNode->leftlink != nullptr) { currentNode = currentNode->leftlink; }
            if (currentNode->leftlink == nullptr)break;
            followingNode = followingNode->leftlink;
        }
        return std::tuple<Node *, Node *>(currentNode, followingNode);//currentNode 목표하는 노드, followingNode 목표하는 노드의 부모
    }


    void inorder() {
        inorder(Head);
    }

    void inorder(Node *currentNode) {
        if (currentNode) {
            inorder(currentNode->leftlink);
            std::cout << "(학번: " << currentNode->data.classnum << ", 점수: "
                      << currentNode->data.grade << ")" << std::endl;
            inorder(currentNode->rightlink);
        }
    }
};

int main() {
    List a;//1
    a.insert(20220033, 90);
    a.insert(20220050, 73);
    a.insert(20220043, 99);
    a.insert(20220011, 82);
    a.insert(20220024, 78);
    a.insert(20220046, 96);
    a.insert(20220001, 72);
    a.insert(20220008, 88);
    a.insert(20220036, 77);
    a.insert(20220056, 93);
    a.insert(20220053, 82);
    a.insert(20220059, 100);//1번
    a.inorder();            //2번
    a.Delete(20220050);       //3번
    a.inorder();            //4번
    a.Delete(20220008);        //5번
    a.inorder();            //6번
    a.Delete(20220056);       //7번
    a.inorder();            //8번
    a.Get(20220056);          //9번
    a.Get(20220043);          //10번
    return 0;
}
