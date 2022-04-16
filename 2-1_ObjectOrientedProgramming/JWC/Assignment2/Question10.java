import java.lang.Math;
import java.util.Scanner;

public class Question10 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] ary = new int[6];

    System.out.print("첫 번째 원의 중심과 반지름 입력 >> ");
    for (int i = 0; i < 3; ++i) {
      ary[i] = scanner.nextInt();
    }

    System.out.print("두 번째 원의 중심과 반지름 입력 >> ");
    for (int i = 3; i < 6; ++i) {
      ary[i] = scanner.nextInt();
    }

    // 두 원 사이 거리 구하기
    double temp1 = Math.pow((ary[3] - ary[0]), 2);
    double temp2 = Math.pow((ary[4] - ary[1]), 2);
    double distance = Math.sqrt(temp1 + temp2);

    // 두 반지름의 합이 두 원 사이 거리보다 크면 충돌함.
    if (distance < ary[2] + ary[5])
      System.out.println("두 원은 서로 겹친다.");
    else
      System.out.println("두 원은 서로 겹치지 않는다.");

    scanner.close();
  }
}
