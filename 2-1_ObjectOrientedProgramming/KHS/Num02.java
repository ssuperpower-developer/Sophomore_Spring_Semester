import java.util.Scanner;
public class Num02 {
    public static void main(String[] args) {
        //10의 자리==1의 자리
        Scanner scanner=new Scanner(System.in);
        System.out.println("2자리수 정수 입력(10~99)>>");
        int number= scanner.nextInt();
        int ten=number/10;
        int one=number%10;
        if (ten==one) System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");


    }
}
