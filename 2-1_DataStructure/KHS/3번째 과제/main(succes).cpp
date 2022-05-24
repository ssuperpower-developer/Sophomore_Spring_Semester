#include <iostream>
class List;
class Node{
    friend List;
public:
    int data=0;
    Node* link= nullptr;
    Node(){}
    Node(int a){
        this->data=a;
        this->link= nullptr;
    }
};

class List{
private:
    Node *Head;//진짜 시작
    Node *Last;
    Node *Temp;
    Node *Tail;//진짜 마지막
    Node *Follower;
public:
    List(){
        Head=new Node();
        Tail=new Node();
        Head->link=Tail;
        Last=Temp=Head;
    }
    void Add(int input){
        if(Head== nullptr)   {
            Temp=new Node(input);
            Head->link=Temp;
            Last=Temp;
        }else{
            Last->link=new Node(input);
            Last=Last->link;
            Last->link=Tail;
        }
    }
    void Show(){
        int i=1;
        Temp=Head->link;
        while(1){
            if(Temp->link== nullptr){break;}
            std::cout<<i<<"번째 노드 "<<Temp->data<<std::endl;
            Temp=Temp->link;
            i++;
        }
    }
    Node *Front(){
        std::cout<<"가장 맨앞의 노드의 값은 "<<Head->link->data<<std::endl;
        return Head->link;
    }
    void FrontAdd(int input){
        Node* NewNodeptr=new Node(input);
        NewNodeptr->link=Head->link;
        Head->link=NewNodeptr;
    }
    void BackAdd(int input){
        Node* NewNodeptr=new Node(input);
        Last->link=NewNodeptr;
        Last=NewNodeptr;
        Last->link=Tail;
    }
    void FrontDel(){
        Node * temp=Head->link->link;
        delete Head->link;
        Head->link=temp;
    }
    Node *Back(){
        std::cout<<"가장 맨 뒤의 노드의 값은 "<<Last->data<<std::endl;
        return Last;
    }
    Node* Get(int find){
        int i=1;
        Temp=Head->link;
        while(Temp->link!= nullptr){
            if(find==Temp->data){std::cout<<i<<"번째 노드 "<<Temp->data<<std::endl;break;}
            Temp=Temp->link;
            i++;
        }
        return Temp;
    }
};
int main(){
    List a;//1
    for(int i=1;i<10;i++){
        a.Add(i);
    }
    a.Show();
    a.FrontAdd(0);//3
    a.Show();;
    a.BackAdd(10);//5
    a.Show();//6
    a.Front();//7
    a.Back();//8
    a.Get(2);//9
    a.FrontDel();//10
    a.Show();//11
    a.FrontDel();//12
    a.Show();
    return 0;
}
