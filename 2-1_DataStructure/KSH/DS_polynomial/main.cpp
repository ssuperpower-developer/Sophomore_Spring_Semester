/*
#include <iostream>
#include <string>
#include "polynomial.h"

using namespace std;

int main(void) {
    Polynomial p;

    string filename;
    getline(cin, filename);

    p.LoadPolynomial(filename);
    p.PrintPolynomial();

    return 0;
}
*/

#include <iostream>
#include <string>
#include "polynomial.h"

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