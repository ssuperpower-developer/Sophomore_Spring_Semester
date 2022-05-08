import java.util.Scanner;

public class Question4 {
  public static void main(String[] args) {
    System.out.print("Write One Letter >> ");
    Scanner sc = new Scanner(System.in);

    char temp = sc.next().charAt(0);

    for (char i = temp; i >= 'a'; --i) {
      for (char j = 'a'; j <= i; ++j) {
        System.out.print(j);
      }
      System.out.println("");
    }

    sc.close();
  }
}
