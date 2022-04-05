#include<iostream>
using std::cout;
using std::cin;
using std::endl;
void divide(const int,const int,int*,int*);

int main(){
    int num1,num2;
    int q,r;
    cin>>num1>>num2;
    try{  
        divide(num1,num2,&q,&r);
        cout<<num1<<'/'<<num2<<'='<<q<<',';
        cout<<num1<<'%'<<num2<<'='<<r<<endl;
    }
    catch(int ek){
        cout<<"0으로 나눌 수 없습니다."<<endl;
    }
    return 0;
}

void divide(const int num1,const int num2,int *q,int *r){
    if(num2==0)
        throw 0;
    *q=num1/num2;
    *r=num1%num2;
    return;
}
