import java.util.Scanner;

public class Question4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] ary = new int[3];

    System.out.print("정수 3개 입력 >> ");
    for (int i = 0; i < 3; ++i) {
      ary[i] = scanner.nextInt();
    }
    // Selection Sort
    int max, temp;
    for (int i = 0; i < 2; ++i) {
      max = i;
      for (int j = i + 1; j < 3; ++j) {
        if (ary[j] < ary[max])
          max = j;
      }
      temp = ary[i];
      ary[i] = ary[max];
      ary[max] = temp;
    }
    System.out.print("중간값은 ");
    System.out.println(ary[1]);
    scanner.close();
  }
}
