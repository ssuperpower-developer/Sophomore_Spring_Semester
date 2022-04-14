// 아래와 같이 main함수에서 여러분이 작성한 rectangle.h 파일을 include하여
// 주어진 동작을 실행하게 됩니다.
// *** 주의! 아래의 내용을 변경할 경우 오답처리될 수 있습니다. **
#include "rectangle.h"
#include <iostream>
#include <string>

using namespace std;

int main(void) {
  int w, h;
  cin >> w >> h;

  Rectangle r(w, h);

  cout << r.area() << endl;
  cout << r.perimeter() << endl;

  return 0;
}
