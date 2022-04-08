// 1주차

// 1 번

// #include<iostream>
// using namespace std;

// int main(){
//     cout << "Hello World!" << endl;
//     return 0;
// }

// ===========================================
// 2번

// #include<iostream>
// using namespace std;

// void swap(int &a, int &b);

// int Main(void){
//     int a = 1;
//     int b = 2;
//     swap(a, b);
//     cout << a << " " << b << endl;
//     return 0;
// }

// void swap(int &a, int &b){
//     int temp = a;
//     a = b;
//     b = temp;
// }

// ===========================================
// 3-1번

// #include<iostream>
// using namespace std;

// int GCD(int a, int b);

// int Main(){
//     int a, b;
//     cout << "2개의 자연수를 입력하시오." << endl;
//     cin >> a >> b;
//     cout << "2개의 자연수에 대한 최대 공약수 = " << GCD(a, b) << endl;
//     return 0;
// }

// int GCD(int a, int b){
//     if(a % b == 0)
//         return b;
//     else
//         return GCD(b, a % b);
// }

// ===========================================
// 3-2번

// #include<iostream>
// using namespace std;

// void Hanoi(int n, char from, char by, char to){
//     if(n == 1)
//     cout << from << "=>" << to << endl;
//     else{
//         Hanoi(n - 1, from, to, by);
//         cout << from << "=>" << to << endl;
//         Hanoi(n - 1, by, from, to);
//     }
// }

// ===========================================
// 3-3번

// #include<iostream>
// using namespace std;

// int Fibo(int n){
//     if(n <= 1)
//     return n;
//     else
//     return Fibo(n-1) + Fibo(n-2);
// }