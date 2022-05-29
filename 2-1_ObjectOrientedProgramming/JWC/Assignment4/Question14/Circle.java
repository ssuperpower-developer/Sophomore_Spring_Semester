public class Circle implements Shape {
  private int radius;

  Circle(int radius) {
    this.radius = radius;
  }

  @Override
  public void draw() {
    System.out.println("--- 다시 그립니다. 반지름이 " 
    + this.radius + "인 원입니다.");
  }

  @Override
  public double getArea() {
    return PI * this.radius * this.radius;
  }
}