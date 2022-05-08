#include<cstdlib>
#include<iostream>
#include <ctime>

using namespace std;


class Bizcard{
    private :
        char* name;
        char* address;
        long office_phone;
        long mobile_phone;
    public :
        Bizcard(){
          char tempName[13] ="NoElement";
          char tempAddress[13] ="NoElement";
          this->name = new char[strlen(tempName)+1];
          this->address = new char[strlen(tempAddress)+1];
          strcpy(this->name,tempName);
          strcpy(this->address,tempAddress);
          this->office_phone = 0;
          this->mobile_phone = 0;
          
        }
        // 생성자
        Bizcard(const char* name,const char* address,long office_phone,long mobile_phone) :office_phone(office_phone),mobile_phone(mobile_phone){
          // const 를 붙여야 ,  conversion from string literal to 'char *' is deprecated
            this->name = new char[strlen(name+1)];
            this->address = new char[strlen(address+1)];
            strcpy(this->name,name);
            strcpy(this->address,address);
        }
        // ShowInfo 함수
        const void ShowInfo(){
            cout<<"name:"<<name<<endl;
            cout<<"address:"<<address<<endl;
            cout<<"office_phone:"<<office_phone<<endl;
            cout<<"mobile_phone:"<<mobile_phone<<endl;
        }
        // 복사 생성자 (깊은 + 얕은 복사)
        Bizcard(const Bizcard &rhs) :office_phone(rhs.office_phone),mobile_phone(rhs.mobile_phone){
            name = new char[strlen(rhs.name)+1];
            strcpy(name,rhs.name);
            address = new char[strlen(rhs.address)+1];
            strcpy(address,rhs.address);
        }
        // 대입연산자 
        Bizcard& operator=(const Bizcard& ref){
            delete[] name;
            delete[] address;
            name = new char[strlen(ref.name)+1];
            address = new char[strlen(ref.name)+1];
            strcpy(address,ref.address);
            strcpy(name,ref.name);
            office_phone = ref.office_phone;
            mobile_phone = ref.mobile_phone;
            return *this;
        }
        // 소멸자
        ~Bizcard(){
            delete[] name;
            delete[] address;
        } 
      
        friend ostream& operator<<(ostream& out,const Bizcard& tmp){
          out<<tmp;
          return out;
        }
};

template <class T>
class Bag
{
public:
  T *array;
  int capacity; 
  int top;

public:
  Bag (int bagCapacity = 3);
  ~Bag(); 
  
  int Size() const;  
  bool IsEmpty() const; 
  void Element() const;  
  
  void Push(const T&); 
  void Pop();

};

// 생성자, 소멸자 
template <class T>
Bag<T>::Bag (int bagCapacity): capacity ( bagCapacity ) {
  if (capacity < 1) throw "Capacity must be > 0";
  array = new T[capacity];
  top = -1;
}
template <class T>
Bag<T>::~Bag() {
  delete [] array; 
}

// size, isEmpty,Element
template <class T>
int Bag<T>::Size() const{
  return top+1;
}
template <class T>
bool Bag<T>::IsEmpty() const{
  return Size()==0;
}

// !
template <class T>
void Bag<T>::Element() const{
  srand((unsigned int)time(NULL));
  int RandomIndex = top/(rand()%(top+1));
  array[RandomIndex].ShowInfo();

}

// push,pop
template <class T>
void Bag<T>::Push(const T& x) {
  if (capacity ==top+1) 
  {
    capacity *=2;
    T *temp = new T[capacity];
    copy(array,array+top+1,temp);
    delete[] array;
    array = temp;
  }
  array[++top] = x;
}

template <class T>
void Bag<T>::Pop() {
  if (IsEmpty()) throw "Bag is empty, cannot delete";
  srand((unsigned int)time(NULL));
  int deletePos = top/(rand()%(top+1));
  copy(array+deletePos+1,array+top+1,array+deletePos);
  top--;

  // array[top--].~T();
}

int main(void){
  Bag<Bizcard> bag;
  Bizcard biz1("hong","30300",23411022220,11118329341);
  Bizcard biz2("hang","2301",30228283134,29283300278);
  Bizcard biz3("kim","21921",20332904623,19120931850);


  cout<<bag.Size()<<endl;
  cout<<bag.IsEmpty()<<endl;
  bag.Element();  // 빈 bag 상태의 Element는 더 고민해보자
  cout<<'\n';

  bag.Push(biz1);
  bag.Push(biz2);
  bag.Push(biz3);
  cout<<bag.Size()<<endl;
  cout<<bag.IsEmpty()<<endl;
  bag.Element();
  cout<<'\n';

  Bizcard biz4("han","3420",12021092356,23907408234);
  Bizcard biz5("Kim","28182",91243729123,19283312501);
  Bizcard biz6("Park","19221",23112398380,12983211524);
  Bizcard biz7("Kim","32893",12010229377,21092901224);

  bag.Push(biz4);
  bag.Push(biz5);
  bag.Push(biz6);
  bag.Push(biz7);
  cout<<bag.Size()<<endl;
  cout<<bag.IsEmpty()<<endl;
  bag.Element();
  cout<<'\n';

  bag.Pop();
  bag.Pop();
  cout<<bag.Size()<<endl;
  cout<<bag.IsEmpty()<<endl;
  bag.Element();

  return 0;
}
