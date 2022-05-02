import java.util.Scanner;

public class Luxury3_06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] unit = {50000, 10000, 1000, 100, 10, 1};  // unit 배열에 값 초기화
        System.out.print("금액을 입력하시오>>");
        int value = s.nextInt();
        int[] share = new int[6];   // value 값을 unit으로 나눈 몫을 저장해주는 배열
        for(int i = 0; i < unit.length; i++){   // unit의 크기 만큼 반복문 실행
            share[i] = value / unit[i]; // share 배열에 몫 초기화
            value = value % unit[i];    // value 값은 unit으로 나눈 나머지로 초기화
            System.out.println(unit[i] + "원 짜리 : " + share[i] + "개");
        }
        s.close();
    }
}
