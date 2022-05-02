import java.util.Scanner;

public class Luxury06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("1~ 99 사이의 정수를 입력하시오>>");
        int num = s.nextInt();
        int tensPlace = num / 10;
        int onesPlace = num % 10;
        System.out.print("박수");
        if(tensPlace == 3 || tensPlace == 6 || tensPlace == 9) System.out.print("짝");
        if(onesPlace == 3 || onesPlace == 6 || onesPlace == 9) System.out.print("짝");
        s.close();
    }
}
