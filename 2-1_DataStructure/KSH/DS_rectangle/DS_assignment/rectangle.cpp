#include "rectangle.h"

Rectangle::Rectangle() {
	width = 0;
	height = 0;
}
Rectangle::Rectangle(int w, int h) :width(w), height(h) {
	if (width < 0) {
		width = 0;	
	}
	else {
		width = width;
	}
	if (height < 0) {
		height = 0;
	}
	else {
		height = height;
	}
}

int Rectangle::area() {
	return width * height;
}

int Rectangle::perimeter() {
	return (width + height) * 2;
}