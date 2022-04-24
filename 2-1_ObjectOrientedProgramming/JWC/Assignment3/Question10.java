import java.util.Random;

public class Question10 {
  public static void main(String[] args) {
    int[] temp1 = new int[16];
    int[] temp2 = new int[6];
    int[][] ary = new int[4][4];
    Random rn = new Random();

    for (int i = 0; i < 16; ++i) {
      temp1[i] = rn.nextInt(10) + 1;
    }

    for (int i = 0; i < 6; ++i) {
      temp2[i] = rn.nextInt(16);

      for (int j = 0; j < i; ++j) {
        if (temp2[i] == temp2[j]) {
          --i;
          break;
        }
      }
    }

    for (int i = 0; i < 6; ++i) {
      temp1[temp2[i]] = 0;
    }

    int idx = 0;
    for (int i = 0; i < 4; ++i) {
      for (int j = 0; j < 4; ++j) {
        ary[i][j] = temp1[idx++];
      }
    }

    for (int i = 0; i < 4; ++i) {

      for (int j = 0; j < 4; ++j) {
        System.out.print(ary[i][j] + " ");
      }
      System.out.println("");
    }
  }
}
