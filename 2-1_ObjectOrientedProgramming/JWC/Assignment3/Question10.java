import java.util.Random;

public class Question10 {
  public static void main(String[] args) {
    int[] ary = new int[16];
    int[] temp = new int[6];
    Random rn = new Random();

    for (int i = 0; i < 16; ++i) {
      ary[i] = rn.nextInt(10) + 1;
    }

    for (int i = 0; i < 6; ++i) {
      temp[i] = rn.nextInt(16);

      for (int j = 0; j < i; ++j) {
        if (temp[i] == temp[j]) {
          --i;
          break;
        }
      }
    }

    for (int i = 0; i < 6; ++i) {
      ary[temp[i]] = 0;
    }

    for (int i = 0; i < 16; ++i) {
      if (i % 4 == 0) {
        System.out.println(" ");
      }
      System.out.print(ary[i] + " ");
    }
  }
}
