import java.util.Scanner;

public class Luxury3_04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("소문자 알파벳 하나를 입력하시오>>");    // 값 입력
        String a = s.nextLine();    // a에 저장
        char c = a.charAt(0);
        // Scanner의 경우 char를 입력받지 못하므로 String으로 입력받은 후 charAt을 통해 char 값을 받는다.
        for(int i = c; i > 'a' - 1; i--){   // c에서 점점 줄어들어 a까지
            for(char j = 'a'; j < i + 1; j++){  // a부터 i까지
                System.out.print(j);
            }
            System.out.println();
        }
        s.close();
    }
}
