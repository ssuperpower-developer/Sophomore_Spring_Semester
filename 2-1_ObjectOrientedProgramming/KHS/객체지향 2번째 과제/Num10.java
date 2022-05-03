import java.util.Random;
import java.util.Scanner;

public class Num10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int checker = 0;
        int fourbyfour[][] = new int[4][4];
        for (int i = 0; i < 16; i++) {
            int a = random.nextInt(4);
            int b = random.nextInt(4);
            if (fourbyfour[a][b] == 0) {
                fourbyfour[a][b] = random.nextInt(10) + 1;
                checker++;
            } else i--;
            if (checker == 10) break;
        }
        for (int j = 0; j < fourbyfour.length; j++) {
            for (int k = 0; k < fourbyfour[j].length; k++) {
                System.out.print(fourbyfour[j][k] + " ");
            }
            System.out.println(" ");
        }
    }
}
