import java.util.Scanner;

public class Luxury04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("정수 3개 입력>>");
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int num3 = s.nextInt();
        if((num1 < num2 && num2 < num3) || (num3 < num2 && num2 < num1)){
            System.out.println("중간값은 " + num2);
        }
        if((num2 < num3 && num3 < num1) || (num1 < num3 && num3 < num2)){
            System.out.println("중간값은 " + num3);
        }
        else System.out.println("중간값은 " + num1);
        s.close();
    }
}
