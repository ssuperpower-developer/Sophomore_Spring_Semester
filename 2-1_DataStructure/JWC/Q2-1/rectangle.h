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

  Rectangle(int w, int h) {
    if (w < 0) {
      width = 0;
      height = h;
    } else if (h < 0) {
      width = w;
      height = 0;
    } else if (w < 0 && h < 0) {
      width = 0;
      height = 0;
    } else {
      width = w;
      height = h;
    }
  }

  int area();

  int perimeter();
};

#endif
