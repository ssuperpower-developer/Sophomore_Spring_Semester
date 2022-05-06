import java.util.Scanner;

public class Luxury02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("2자리수 정수 입력(10~99)>>");
        int num = s.nextInt();
        if(num > 10 && num < 100){
            if(num / 10 == num % 10){
                System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
            }
            else{
                System.out.println("No! 10의 자리와 1의 자리가 같지 않습니다.");
            }
        }
        else{
            System.out.println("2자리 정수를 입력하세요.");
        }
        s.close();
    }
}