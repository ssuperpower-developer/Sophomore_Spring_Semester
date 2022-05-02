#include<iostream>
using namespace std;

int Found(int first, int last, int* pvalue, int findValue, int& count);
int main() {
    int intSize, findValue;
    int count = 0;
    cin >> intSize;
    int first = 0;
    int last = intSize;
    int* pvalue = new int[last];
    for (int i = 0; i < last; i++) {
        cin >> pvalue[i];
    }
    cin >> findValue;
    cout << Found(first, last, pvalue, findValue, count) << endl;
    cout << count << endl;
    return 0;

}
int Found(int first, int last, int* pvalue,int findValue, int& count) {
    int mid = (first + last) / 2;
    count++;
    if (pvalue[mid] == findValue) {
        return mid;
    }
    else if (first > last) {
        count--;
        return -1;
    }
    else if (pvalue[mid] > findValue) {
        return Found(first, mid - 1,pvalue, findValue, count);
    }
    else {
        return Found(mid + 1, last, pvalue, findValue, count);
    }
    delete[] pvalue;
}
