#include "rectangle.h"
#include <iostream>

using namespace std;

int Rectangle::area() { return width * height; }

int Rectangle::perimeter() { return 2 * width + 2 * height; }
