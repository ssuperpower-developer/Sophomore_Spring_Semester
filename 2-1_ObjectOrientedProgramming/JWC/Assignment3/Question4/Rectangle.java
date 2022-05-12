public class Rectangle {
  private int x, y, width, height;

  Rectangle() {
  }

  Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public int square() {
    return width * height;
  }

  public void show() {
    System.out.println("(" + x + "," + y + ") 에서 크기가 " + width + "x" +
        height + "인 사각형");
  }

  public boolean contains(Rectangle comparedSquare) {
    if (x < comparedSquare.getX() && y < comparedSquare.getY()) {
      int endX = x + width, endY = y + height;
      int comparedSquareEndX = comparedSquare.getX() + comparedSquare.getWidth();
      int comparedSquareEndY = comparedSquare.getY() + comparedSquare.getHeight();

      if (comparedSquareEndX < endX && comparedSquareEndY < endY)
        return true;
      else
        return false;
    } else {
      return false;
    }
  }
}
