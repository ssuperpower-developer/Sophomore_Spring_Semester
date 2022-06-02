#include<iostream>
using namespace::std;
class tree;
class Pair;

class Pair{
friend class tree;
private:
    int personNum;
    int score;
    Pair* rightPtr;
    Pair* leftPtr;
public:
    Pair(int personNum,int score=0):personNum(personNum),score(score){
        rightPtr = NULL;
        leftPtr = NULL;
    }
    Pair& operator=(const Pair &ref){
        this->personNum = ref.personNum;
        this->score = ref.score;
    }
};

class tree{
private:
    Pair* headRoot;
    Pair* tempPtr;
    int ForGet;
    int ForGetTemp;

    Pair* currentParrentNode;
    Pair* currentNode;
    Pair* smallNodeInDelete;
    int haveSubTreeForDelete;
    int ForDelete;
    int tempRightOrLeft;
    
    int tempRL;
    Pair* parentNode;

public:
    tree(){
        headRoot = NULL;
        tempPtr = NULL;
    }
    ~tree(){}
    void insert(int personNum,int score);
    void inorder();
    void inorder(Pair *);
    void get(int);
    void get(Pair*);
    Pair* Finddelete(int);
    void deleteMethod(int);
    Pair* FindSmall(Pair*);
};

void tree::insert(int personNum,int score){
    Pair* temp = new Pair(personNum,score);
        if(headRoot == NULL){
            headRoot = temp;
            tempPtr = headRoot;
        }
       else{
             while(true){ 
                if(tempPtr->personNum > temp->personNum){
                    if(tempPtr->leftPtr == NULL){
                        tempPtr->leftPtr = temp;
                        break;
                    }
                    else{
                        tempPtr = tempPtr->leftPtr;
                   }
                }
               else{
                   if(tempPtr->rightPtr == NULL){
                       tempPtr->rightPtr = temp;
                       break;
                    }
                    else{
                        tempPtr = tempPtr->rightPtr;
                    }
               }
            }
            tempPtr = headRoot;
        }
}

void tree::inorder(){
    inorder(headRoot);
}

void tree::inorder(Pair* tempPtr){
    if(tempPtr){
        inorder(tempPtr->leftPtr);
        cout<<"학번 : "<<tempPtr->personNum<<" 점수 : "<<tempPtr->score<<endl;
        inorder(tempPtr->rightPtr);
    }
    
}
void tree::get(int personNum){
    ForGet = personNum;
    ForGetTemp = 1;
    get(headRoot);
    if(ForGetTemp) cout<<"해당 노드가 없습니다."<<endl;
}

void tree::get(Pair* tempPtr){
    if(tempPtr){
        get(tempPtr->leftPtr);
        if(tempPtr->personNum == ForGet){
            cout<<"해당 노드가 있습니다. ";
            cout<<"학번 : "<<tempPtr->personNum<<" 점수 : "<<tempPtr->score<<endl;
            ForGetTemp = 0;
        }
        get(tempPtr->rightPtr);
    }
}   

void tree::deleteMethod(int personNum){
    Pair* parrentNode = Finddelete(personNum);
    if(haveSubTreeForDelete == 0){
        if(tempRightOrLeft == 0){
            parrentNode->leftPtr = NULL;
            delete parentNode->leftPtr;
        }
        else if(tempRightOrLeft == 1){
            parrentNode->rightPtr = NULL;
            delete parentNode->rightPtr;
        }
    }
    else if(haveSubTreeForDelete == 1){
        if(tempRightOrLeft == 0){
            parrentNode->leftPtr->personNum = smallNodeInDelete->personNum;
            parrentNode->leftPtr->score = smallNodeInDelete->score;
            parentNode->leftPtr = NULL;
            delete parentNode->leftPtr;
        }
        else if(tempRightOrLeft == 1){
            parrentNode->rightPtr->personNum = smallNodeInDelete->personNum;
            parrentNode->rightPtr->score = smallNodeInDelete->score;
            parentNode->rightPtr = NULL;
            delete parentNode->rightPtr;
        }
    }
    else if(haveSubTreeForDelete == 2){
        if(tempRightOrLeft==0){
            if(tempRL == 0){
                parentNode->leftPtr = NULL;
                delete parentNode->leftPtr;
                parrentNode->leftPtr->personNum = smallNodeInDelete->personNum;
                parrentNode->leftPtr->personNum = smallNodeInDelete->score;
            }
            else if(tempRL == 1){
                parentNode->rightPtr = NULL;
                delete parentNode->rightPtr;
                parrentNode->leftPtr->personNum = smallNodeInDelete->personNum;
                parrentNode->leftPtr->personNum = smallNodeInDelete->score;
            }
        }
        else{
            if(tempRL == 0){
                parentNode->leftPtr = NULL;
                delete parentNode->leftPtr;
                parrentNode->rightPtr->personNum = smallNodeInDelete->personNum;
                parrentNode->rightPtr->score = smallNodeInDelete->score;
            }
            else if(tempRL == 1){
                parentNode->rightPtr = NULL;
                delete parentNode->rightPtr;
                parrentNode->rightPtr->personNum = smallNodeInDelete->personNum;
                parrentNode->rightPtr->score = smallNodeInDelete->score;
            }
        }

    }

}

Pair* tree::Finddelete(int personNum){
    currentParrentNode = headRoot;
    currentNode = headRoot;
    while(currentNode){
        if(currentNode->personNum == personNum){
            if(currentNode->rightPtr == NULL && currentNode->leftPtr == NULL){
                haveSubTreeForDelete = 0;
                delete currentNode;
            }
            else if(currentNode->rightPtr != NULL && currentNode->leftPtr == NULL){
                haveSubTreeForDelete = 1;
                smallNodeInDelete = currentNode->rightPtr;
                parentNode = currentNode;
            }
            else if(currentNode->rightPtr == NULL && currentNode->leftPtr != NULL){
                haveSubTreeForDelete = 1;
                smallNodeInDelete = currentNode->leftPtr;
                parentNode = currentNode;
            }
            else if(currentNode->leftPtr != NULL && currentNode->rightPtr != NULL){
                haveSubTreeForDelete = 2;
                smallNodeInDelete = FindSmall(currentNode->rightPtr);
            }
            return currentParrentNode;
        }
        currentParrentNode = currentNode;
        if(personNum < currentNode->personNum){
            currentNode = currentNode->leftPtr;
            tempRightOrLeft = 0;    // left
        }
        else{
            currentNode = currentNode->rightPtr;
            tempRightOrLeft = 1;    //right
        }
    }
}
Pair* tree::FindSmall(Pair* currentNode){
    while(true){
        if(currentNode->leftPtr != NULL && currentNode->rightPtr != NULL){
            parentNode = currentNode;
            currentNode = currentNode->leftPtr;
            tempRL = 0;
        }
        else if (currentNode->leftPtr != NULL && currentNode->rightPtr == NULL){
            parentNode = currentNode;
            currentNode = currentNode->leftPtr;
        }
        else if(currentNode->leftPtr == NULL && currentNode->rightPtr != NULL){
            parentNode = currentNode;
            currentNode = currentNode->rightPtr;
        }
        else if(currentNode->leftPtr == NULL && currentNode->rightPtr == NULL){
            break;
        }
    }
    return currentNode;
}

int main(void){
    tree* myTree = new tree();
    myTree->insert(20220033,90);
    myTree->insert(20220050,73);
    myTree->insert(20220043,99);
    myTree->insert(20220011,82);
    myTree->insert(20220024,78);
    myTree->insert(20220046,96);
    myTree->insert(20220001,72);
    myTree->insert(20220008,88);
    myTree->insert(20220056,93);
    myTree->insert(20220053,82);
    myTree->insert(20220059,100);
    myTree->insert(20220036,77);

    myTree->inorder();
    cout<<endl;

    myTree->deleteMethod(20220050);
    myTree->inorder();
    cout<<endl;

    myTree->deleteMethod(20220008);
    myTree->inorder();
    cout<<endl;

    myTree->deleteMethod(20220056);
    myTree->inorder();
    cout<<endl;

    myTree->get(20220056);
    myTree->get(20220043);
    return 0;
}

