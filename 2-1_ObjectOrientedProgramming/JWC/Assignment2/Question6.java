import java.util.Scanner;

public class Question6 {
  public static void main(String[] args) {
    int[] unit = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };

    System.out.print("금액을 입력하시오 >> ");
    Scanner sc = new Scanner(System.in);
    int temp = sc.nextInt();
    int[] cnt = new int[8];

    for (int i = 0; i < 8; ++i) {
      cnt[i] = temp / unit[i];
      temp -= unit[i] * cnt[i];
    }

    for (int i = 0; i < 8; ++i) {
      if (cnt[i] == 0)
        continue;
      System.out.println(unit[i] + "원 짜리 : " + cnt[i] + "개");
    }

    sc.close();
  }
}
