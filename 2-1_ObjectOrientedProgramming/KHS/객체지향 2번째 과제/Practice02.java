import java.util.Scanner;
import java.util.InputMismatchException;

public class Practice02 {
    public static void main(String[] args) {
        char[] day = {'일', '월', '화', '수', '목', '금', '토'};
        try {
            System.out.println("정수를 입력 >>");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            int index = input % 7;
            System.out.println(day[input]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("프로그램을 종료합니다");
        } catch (InputMismatchException e) {
            System.out.println();
        }


    }
}

