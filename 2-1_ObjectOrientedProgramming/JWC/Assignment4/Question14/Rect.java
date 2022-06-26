public class Rect implements Shape {
  private int width, height;

  Rect(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public void draw() {
    System.out.println("--- 다시 그립니다. "
        + this.width + "x" + this.height + "에 사각형 입니다.");
  }

  @Override
  public double getArea() {
    return width * height;
  }
}