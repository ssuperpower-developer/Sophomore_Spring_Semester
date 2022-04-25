import java.util.Scanner;
import java.util.InputMismatchException;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하세요>>");
        try {
            int input = scanner.nextInt();
            if (input % 2 == 0) System.out.println("짝수");
            else if (input % 2 == 1) System.out.println("홀수");
        } catch (InputMismatchException e) {
            System.out.println("수를 입력하지 않아 프로그램을 종료합니다.");
        }
    }
}


