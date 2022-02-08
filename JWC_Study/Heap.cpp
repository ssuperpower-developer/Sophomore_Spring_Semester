#include <iostream>

#define SIZE 100

using namespace std;

template <typename T> class Heap {
private:
  T HeapAry[SIZE];
  int size = 0;

public:
  int returnBigIdx(int idx) {
    if (HeapAry[idx] > HeapAry[idx + 1])
      return idx;
    else
      return idx + 1;
  }

  void swap(T *a, T *b) {
    T temp = *a;
    *a = *b;
    *b = temp;
  }

  void push(T data) {
    HeapAry[++size] = data;

    int child = size;
    int parent = size / 2;

    while (child > 1 && HeapAry[parent] < HeapAry[child]) {
      swap(&HeapAry[parent], &HeapAry[child]);
      child = parent;
      parent = child / 2;
    }
  }

  T pop(void) {
    T result = HeapAry[1];

    swap(&HeapAry[1], &HeapAry[size]);
    --size;

    int parent = 1;
    int child = parent * 2;

    if (child + 1 <= size)
      child = returnBigIdx(child);

    while (child <= size && HeapAry[child] > HeapAry[parent]) {
      swap(&HeapAry[child], &HeapAry[parent]);

      parent = child;
      child = child * 2;

      if (child + 1 <= size)
        child = returnBigIdx(child);
    }

    return result;
  }
};

int main(void) {
  Heap<int> H1;

  H1.push(2);
  H1.push(5);
  H1.push(1);
  H1.push(9);

  for (int i = 0; i < 4; ++i) {
    cout << H1.pop() << " ";
  }

  cout << endl;

  Heap<char> H2;
  H2.push('N');
  H2.push('A');
  H2.push('R');
  H2.push('D');

  for (int i = 0; i < 4; ++i) {
    cout << H2.pop() << " ";
  }

  return 0;
}
