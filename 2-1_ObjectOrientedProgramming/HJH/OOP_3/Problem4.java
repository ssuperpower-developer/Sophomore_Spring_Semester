import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("소문자 알파벳 하나를 입력하시오>>");
        String input;
        input = scanner.next();
        char c = input.charAt(0);
        // 문자열의 첫번째 문자 읽음
        int temp=(int)c;
        for(int i=97;i<=(int)c;i++){
            for(int j=97;j<=temp;j++){
                System.out.printf("%c",j);
            }
            System.out.println();
            --temp;
        }



    }
}
