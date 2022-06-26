public class Oval implements Shape {
  private int width, height;

  Oval(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public void draw() {
    System.out.println("--- 다시 그립니다. "
        + this.width + "x" + this.height + "에 내접하는 타원입니다.");
  }

  @Override
  public double getArea() {
    return 4 * PI * (width / 2) * (height / 2);
  }
}
