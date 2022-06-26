import java.util.InputMismatchException;
import java.util.Scanner;

public class Add {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum = 0;

    System.out.print("입력 횟수 >> ");
    int cnt = sc.nextInt();
    for (int i = 0; i < cnt; ++i) {
      try {
        sum += sc.nextInt();
      } catch (InputMismatchException e) {
        sc.next();
        continue;
      }
    }

    System.out.println(sum);

    sc.close();
  }
}
