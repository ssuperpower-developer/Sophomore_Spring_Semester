#include <stdio.h>
#include <iostream>
using namespace std;

int devide(const int *a, const int *b, int *ptr_q, int *ptr_r);
int main(){
    int num1, num2;
    int q = 0, r = 0;
    cout << "two int ";
    cin >> num1 >> num2;
    if(num2 == 0){
        cout << "00000" << endl;
        return main();
    }
    devide(&num1, &num2, &q, &r);
    cout << num1 << "/" << num2 << "=" << q << "," << num1 << "%" << num2 << "=" << r << endl;
    return 0;
}

int devide(const int *a, const int *b, int *ptr_q, int *ptr_r){
    *ptr_q = *a / *b;
    *ptr_r = *a % *b;
    return 0;
}