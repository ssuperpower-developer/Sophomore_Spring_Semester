// 아래와 같이 main함수에서 여러분이 작성한 list.h 파일을 include하여
// 주어진 동작을 실행하게 됩니다.
// *** 주의! 아래의 내용을 변경할 경우 오답처리될 수 있습니다. **
#include "list.h"
#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main(void) {
  LinkedList list;

  list.Append(1);
  list.Append(2);
  list.Append(3);
  list.Append(4);
  list.Append(5);

  list.Prepend(20);
  list.Prepend(30);
  list.Prepend(40);
  list.Prepend(50);

  list.Print();
  cout << endl;
  list.PrintReverse();
  cout << endl;
  cout << list.Length() << endl;

  return 0;
}