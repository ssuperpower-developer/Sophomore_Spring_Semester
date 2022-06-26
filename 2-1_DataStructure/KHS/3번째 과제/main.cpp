#include <iostream>
class Number;
template<class T>
class Chain;

template<class T>
class ChainNode {// 노드만을 다루는 곳
    friend class Chain<T>;
    friend class Number;

private:
    T data;
    ChainNode<T> *link;
public:
    ChainNode() {
        data = 0;
        link = nullptr;
    }
    ChainNode(T input){
        data=input;
        link= nullptr;
    }

};

///////////////////////////////////////////////////////밑이 체인, 위 체인노드
template<class T>
class Chain {//실질적으로 연결리스트를 다루는 곳
public:
    Chain() {
        ChainNode<T> HeadNode;
        ChainNode<T> TailNode;
        HeadNode.link=&TailNode;
    };
    class ChainIterator{
    public:
        ChainIterator(ChainNode<T>* startNode=0){
            current=startNode;
        }
        T& operator*()const{
            return current->data;
        }
        T* operator->()const{
            return &current->data;
        };

        ChainIterator& operator++(){
            current=current->link;return *this;
        };
        ChainIterator& operator++(int){
            ChainIterator old=*this;
            current=current->link;
            return old;
        };
        bool operator!=(const ChainIterator right)const{
            return current!=right.current;
        };
        bool operator==(const ChainIterator right)const{
            return current==right.current;
        }
    private:ChainNode<T> *current;
    };

    /*void AddNode(T input) {
        ChainNode<T> NewNode;
        NewNode.data = input;
        TempNodeptr=HeadNode.link;
        if (HeadNode.link== nullptr) {
            HeadNode.link = &NewNode;
            std::cout << "o" << std::endl;
        }
        else {
            std::cout << "AddNode의 while문 전" << std::endl;
            while (TempNodeptr->link != nullptr) {
                TempNodeptr++;
            }
            TempNodeptr->link=&NewNode;
            std::cout << "AddNode의 while문 후" << std::endl;
        }
        IndexChecker++;
    }*/
    void AddNode(const T& e){
        if(HeadNode.link!= nullptr){
            LastNodeptr->link=new ChainNode<T>(e);
            LastNodeptr=LastNodeptr->link;
        }else{
            HeadNode.link=new ChainNode<T>(e);
            LastNodeptr=HeadNode.link;
            LastNodeptr->link=&TailNode;
        }
    }

    void PrintNode() {
        if (HeadNode.link == nullptr) { printf("이 연결리스트는 비어있습니다."); }
        else {
            TempNodeptr=HeadNode.link;
            do{
                std::cout<<TempNodeptr->data<<std::endl;
                TempNodeptr++;
            }while(TempNodeptr->link!= nullptr);
        }
    }

private:
    ChainNode<T> *TempNodeptr;
    ChainNode<T> *LastNodeptr;
    ChainNode<T> HeadNode;
    ChainNode<T> TailNode;
    int IndexChecker = 1;//초기화 요망

};

class Number {
private:
    int num;
public:
    Number(int n = 0) : num(n) {}

    Number &operator=(const Number &ref) {
        num = ref.num;
        return *this;
    }

    operator int() {
        return num;
    }

    void ShowNumber() {
        std::cout << num << std::endl;
    }};

    int main() {
        std::cout << "Hello" << std::endl;
        Chain<Number> a;
        ChainNode<Number> b;
        a.AddNode(Number(3));
        a.AddNode(Number(4));
        a.PrintNode();

        return 0;
    }


