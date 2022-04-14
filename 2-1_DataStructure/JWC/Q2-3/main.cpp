// 아래와 같이 main함수에서 여러분이 작성한 polynomial.h 파일을 include하여
// 주어진 동작을 실행하게 됩니다.
// *** 주의! 아래의 내용을 변경할 경우 오답처리될 수 있습니다. **
#include "polynomial.h"
#include <iostream>
#include <string>

using namespace std;

int main(void) {
  Polynomial p1, p2, p3;

  string file1, file2;
  getline(cin, file1);

  p1.LoadPolynomial(file1);

  getline(cin, file2);
  p2.LoadPolynomial(file2);

  p3.add(p1, p2);
  p3.PrintPolynomial();

  return 0;
}