import java.util.Scanner;

public class Question6 {
  public static boolean isThereNum(int[] ary, int target) {
    int first = 0, end = ary.length - 1, mid;

    while (first <= end) {
      mid = (first + end) / 2;

      if (target == ary[mid])
        return true;
      else if (target < ary[mid])
        end = mid - 1;
      else if (target > ary[mid])
        first = mid + 1;
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("1 ~ 99 사이의 정수를 입력하시오 >> ");
    int num = scanner.nextInt();
    int a, b, cnt = 0;

    int[] ary = { 3, 6, 9 };

    a = num / 10;
    b = num % 10;

    if (isThereNum(ary, a))
      ++cnt;

    if (isThereNum(ary, b))
      ++cnt;

    if (cnt == 2)
      System.out.println("박수짝짝");
    else if (cnt == 1)
      System.out.println("박수짝");

    scanner.close();
  }
}
