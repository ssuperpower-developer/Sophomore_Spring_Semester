#include<iostream>
#include <algorithm> 
#include <numeric>
#include <vector>
using namespace::std;
template <class T> class Chain;
template <class T> class myInterator;
class Number;
template <class T> class Chain;
template <class T> class ChainNode;


class Number{
private:
    int num;
public:
    Number(int n=0):num(n){
    }
    Number& operator=(const Number& ref){
        num = ref.num;
        return *this;
    }
    Number& operator+(const Number& ref){
        num += ref.num;
        return *this;
    }
    operator int (){    //  형변환 연산자의 오버로딩 
        return num;
    }
    void ShowNumber(){
        cout<<num<<endl;
    }
};

template <class T>
class ChainNode {
friend class Chain<T>;
private:
  T data;
  ChainNode<T> *link;
public:
    ChainNode(T element=0,ChainNode<T>* next=NULL){
        data = element;
        link = next;
    }
    ChainNode& operator=(const ChainNode & ref){
        ChainNode<T> tmp = new ChainNode<T>(ref.data,ref.link);
        this->data= tmp->data;
        this->link = tmp->link;
        return *this;
    }   // 대입연산자 오버로딩 해야해 
};

template <class T>
class Chain {
private:
    ChainNode<T> *first;
    ChainNode<T> *last;
    ChainNode<T> *beforeLast;
public:

class myInterator{
private:
    ChainNode<T> * currentNode;
public:
    myInterator(ChainNode<T>* startNode = NULL){
       currentNode = startNode; 
    }
    T& operator*() const{
        return currentNode->data;
    }
    T* operator->() const{
        return &currentNode->link;
    }
    myInterator& operator++(){
        currentNode = currentNode->link;
        return *this;
    }
    bool operator!=(const myInterator right)const{
        return currentNode != right.currentNode;
    }
    bool operator==(const myInterator right)const{
        return currentNode == right.currentNode;
    }
};
    Chain() {
        first = NULL;   // 공백체인 
        last = NULL;
    };
    ~Chain(){};
    void createAtFront(T data){
        if(first == NULL){
            ChainNode<T> *temp = new ChainNode<T>(data,NULL);
            first = temp;
            last = temp;
        }
        else{
            ChainNode<T> *temp = new ChainNode<T>(data,first);
            first = temp;
        }
    };
    void createAtBack(T data){
        ChainNode<T> *temp = new ChainNode<T>(data,NULL); 
        if(first == NULL){
            first = temp;
            last = temp;
        }
        else{
            last ->link = temp;
            beforeLast = last;
            last = last->link;
        }
    };
    T Front(){
        return first->data;
    };
    T Back(){
        return last->data;
    };
    void Get(int i){
        myInterator begin = myInterator(first);
        for(int k=0;k<i;k++){
            ++begin;
        }
        cout<<*begin<<endl;
        return;
    };
    void deleteAtFront(){
        ChainNode<T> *firstPtr;
        firstPtr = first->link;
        delete first;
        first = firstPtr;
    };
    void deleteAtBack(){
        delete last;
        last = beforeLast;
    };

    void createAtIndexi(int index,int input){
        ChainNode<T> *result = new ChainNode<T>();
        result = first;
        while(index > 0){
            result = result->link;
            index -= 1;
        }
        ChainNode<T> *temp = new ChainNode<T>(input,result->link);
        result->link = temp; 
    };
    void deleteAtIndexi(int index){};
    
    myInterator begin(){return myInterator(first);}
    myInterator end(){return myInterator(last);}

};

int main(void){
    // 테스트 1번
    cout<<"1~9까지 입력"<<endl;
    Number num1(1);
    Number num2(2);
    Number num3(3);
    Number num4(4);
    Number num5(5);
    Number num6(6);
    Number num7(7);
    Number num8(8);
    Number num9(9);
    Chain<Number> mychain; 
    mychain.createAtBack(num1);
    mychain.createAtBack(num2);
    mychain.createAtBack(num3);
    mychain.createAtBack(num4);
    mychain.createAtBack(num5);
    mychain.createAtBack(num6);
    mychain.createAtBack(num7);
    mychain.createAtBack(num8);
    mychain.createAtBack(num9);

    // 테스트 2번
    cout<<"1~9까지 출력"<<endl;    
    Chain<Number>::myInterator begin = mychain.begin();
    Chain<Number>::myInterator last = mychain.end();
    for( ; begin!=last ; ++begin){
        cout<< *begin <<endl;
    }
    cout<< *last<<endl;
    cout<<'\n';

    // 테스트 3번
    cout<<"첫 노드에 0 삽입"<<endl;
    Number num0(0);
    mychain.createAtFront(num0);
	
    // 테스트 4번
    cout<<"0~9까지 출력"<<endl;
    begin = mychain.begin();
    last = mychain.end();
    for( ; begin!=last ; ++begin){
        cout<< *begin <<endl;
    }
    cout<< *last<<endl;
    cout<<'\n';

    // 테스트 5번
    cout<<"마지막 노드에 10 삽입"<<endl;
    Number num10(10);
    mychain.createAtBack(num10);

    // 테스트 6번 
    cout<<"0~10까지 출력"<<endl;
    begin = mychain.begin();
    last = mychain.end();
    for( ; begin!=last ; ++begin){
        cout<< *begin <<endl;
    }
    cout<< *last<<endl;
    cout<<'\n';
    
    // 테스트 7번 
    cout<<"체인의 첫노드 출력"<<endl;
    cout<<mychain.Front()<<endl;

    // 테스트 8번 
    cout<<"체인의 마지막 노드 출력"<<endl;
    cout<<mychain.Back()<<endl;
    cout<<'\n';

    // 테스트 9 번
    cout<<"Get(2)"<<endl;
    mychain.Get(2);
    cout<<'\n';

    // 테스트 10번
    cout<<"체인의 첫노드 삭제"<<endl;
    mychain.deleteAtFront();
    
    // 테스트 11번
    cout<<"체인 출력"<<endl;
    begin = mychain.begin();
    last = mychain.end();
    for( ; begin!=last ; ++begin){
        cout<< *begin <<endl;
    }
    cout<< *last<<endl;
    cout<<'\n';

    // 테스트 12번
    cout<<"체인의 마지막 노드 삭제"<<endl;
    mychain.deleteAtBack(); 

    // 테스트 13번
    cout<<"체인 출력"<<endl;
    begin = mychain.begin();
    last = mychain.end();
    for( ; begin!=last ; ++begin){
        cout<< *begin <<endl;
    }
    cout<< *last<<endl;
    cout<<'\n';

    // 테스트 14번
    cout<<"3과4 노드 사이에 100 삽입"<<endl;
    mychain.createAtIndexi(2,100);

    // 테스트 15번
    cout<<"체인 출력"<<endl;
    begin = mychain.begin();
    last = mychain.end();
    for( ; begin!=last ; ++begin){
        cout<< *begin <<endl;
    }
    cout<< *last<<endl;
    cout<<'\n';

    // 테스트 16번 구현 못함 

    // 테스트 17번
    cout<<"accumulate 알고리즘"<<endl;
    Number sum = accumulate(mychain.begin(),mychain.end(),0);
    cout<<sum<<endl;
    return 0;
}           
