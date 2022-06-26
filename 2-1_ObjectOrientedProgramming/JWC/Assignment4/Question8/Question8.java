public class Question8 {
  public static void main(String[] args) {
    PositivePoint p = new PositivePoint();
    p.move(10, 10);
    System.out.println(p.toString() + "입니다.");

    p.move(-5, 5);
    System.out.println(p.toString() + "입니다.");

    PositivePoint p2 = new PositivePoint(-10, -10);
    System.out.println(p2.toString() + "입니다.");
  }
}