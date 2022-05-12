import java.util.Scanner;
import java.util.Random;

public class Question8 {
  public static void main(String[] args) {
    System.out.print("정수 몇 개 >> ");
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();
    int temp = sc.nextInt();
    int[] ary = new int[temp];

    for (int i = 0; i < temp; ++i) {
      ary[i] = rn.nextInt(100) + 1;

      for (int j = 0; j < i; ++j) {
        if (ary[i] == ary[j]) {
          --i;
          break;
        }
      }
    }

    for (int i = 0; i < temp; ++i) {
      System.out.print(ary[i] + " ");
      if ((i + 1) % 10 == 0)
        System.out.println("");
    }

    sc.close();
  }
}
