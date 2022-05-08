import java.util.Scanner;

public class Question2 {
  public static void main(String[] args) {
    int num = 0, a, b;
    Scanner scanner = new Scanner(System.in);
    System.out.print("2자리수 정수 입력(10~99) >> ");
    num = scanner.nextInt();

    a = num / 10;
    b = num % 10;

    if (a == b)
      System.out.println("Yes! 십의 자리와 일의 자리 숫자가 같습니다.");
    else
      System.out.println("No! 십의 자리와 일의 자리 숫자가 다릅니다.");

    scanner.close();
  }
}
