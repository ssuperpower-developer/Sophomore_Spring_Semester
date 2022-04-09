#pragma once
class Rectangle
{
private:
	int width;
	int height;

public:
	Rectangle();
	Rectangle(int width, int hight);
	int area();
	int perimeter();
};

