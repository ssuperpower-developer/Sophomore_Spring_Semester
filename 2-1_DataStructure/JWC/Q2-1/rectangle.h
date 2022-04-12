#ifndef __RECTANGLE_H__
#define __RECTANGLE_H__

class Rectangle {
private:
  int width;
  int height;

public:
  Rectangle() {
    width = 0;
    height = 0;
  }

  Rectangle(int w, int h) : width(w), height(h) {
    if (w < 0) {
      width = 0;
      height = h;
    }

    if (h < 0) {
      width = w;
      height = 0;
    }

    if (w < 0 && h < 0) {
      width = 0;
      height = 0;
    }
  }

  int area();
  int perimeter();
};

#endif
