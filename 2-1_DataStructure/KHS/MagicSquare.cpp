#include <iostream>



using namespace std;



int main() {

    int arr[50][50]{ 0 }, n, count = 0;

    cin >> n;

    //첫행에 열은 중간

    int x = 0, y = n / 2;

    for (int i = 0; i < n * n; i++) {

        count++;

        //x가 음수로 내려간다면 윗행으로

        if (x < 0)    x += n;

        //열이 우측으로 넘어갔다면 첫열로

        if (y >= n)    y -= n;

        arr[x][y] = count;

        //n의 배수라면 행증가

        if (count % n == 0) {

            x++;

            continue;

        }

        //행감소 열증가

        x--;

        y++;

    }

    for (int i = 0; i < n; i++) {

        for (int j = 0; j < n; j++)

            cout << arr[i][j] << " ";

        cout << endl;

    }

    return 0;

}