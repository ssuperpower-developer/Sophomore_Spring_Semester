import java.util.Scanner;

public class Question12B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int p1, p2;
    String engine;

    System.out.print("연산 >> ");
    p1 = scanner.nextInt();
    engine = scanner.next();
    p2 = scanner.nextInt();

    switch (engine) {
      case "+":
        System.out.printf("%d + %d = %d", p1, p2, p1 + p2);
        break;
      case "-":
        System.out.printf("%d - %d = %d", p1, p2, p1 - p2);
        break;
      case "*":
        System.out.printf("%d * %d = %d", p1, p2, p1 * p2);
        break;
      case "/":
        if (p2 == 0)
          System.out.println("0으로 나눌 수 없습니다");
        else
          System.out.printf("%d / %d = %d", p1, p2, p1 / p2);

        break;
    }

    scanner.close();
  }
}
