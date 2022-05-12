import java.util.Scanner;

public class Question8 {
  public static boolean inRect(int x, int y) {
    if ((x >= 100 && x <= 200) && (y >= 100 && y <= 200))
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int x1, y1, x2, y2;
    System.out.print("x1, y1을 입력 >> ");
    x1 = scanner.nextInt();
    y1 = scanner.nextInt();
    System.out.print("x2, y2을 입력 >> ");
    x2 = scanner.nextInt();
    y2 = scanner.nextInt();

    if (inRect(x1, y1) || inRect(x2, y2))
      // 사용자가 입력한 사각형이 문제에서
      // 제시된 사각형 안이나 밖으로 포함된다면
      // 충돌하지 않는다고 판정
      if ((inRect(x1, y1) && inRect(x2, y2)))
        System.out.println("두 사각형은 충돌하지 않습니다.");
      else
        System.out.println("두 사각형을 충돌합니다!!");
    else
      System.out.println("두 사각형은 충돌하지 않습니다.");

    scanner.close();
  }
}
