import java.util.Scanner;

public class Luxury3_16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = {"가위", "바위", "보"};
        String[] result = {", 사용자가 졌습니다.", ", 비겼습니다.", ", 사용자가 이겼습니다."};
        /// result[0]이면 졌습니다, result[1]이면 비겼습니다, result[2]면 이겼습니다 출력
        int rst;
        String user;
        System.out.println("컴퓨터와 가위바위보 게임을 합니다.");
        while(true) {
            System.out.print("가위 바위 보!>>");
            user = s.nextLine();
            if (user.equals("그만")) {        // 그만이라고 입력하면
                System.out.println("게임을 종료합니다...");
                break;      // 종료
            }
            int n = (int) (Math.random() * 3);  // 0, 1, 2 랜덤 값 생성
            if (str[n].equals("가위")) {      // str[n]이 가위일 경우
                if (user.equals("가위")) rst = 1;     // user가 가위이면 rst는 1
                else if (user.equals("바위")) rst = 2;    // user가 바위이면 rst는 2
                else rst = 0;   //user가 가위, 바위가 아니면 rst는 0
                System.out.println("사용자 = " + user + " , 컴퓨터 = " + str[n] + result[rst]);
            }
            // 밑에도 다 같은 방법
            if (str[n].equals("바위")) {
                if (user.equals("가위")) rst = 0;
                else if (user.equals("바위")) rst = 1;
                else rst = 2;
                System.out.println("사용자 = " + user + " , 컴퓨터 = " + str[n] + result[rst]);
            }
            if (str[n].equals("보")) {
                if (user.equals("가위")) rst = 2;
                else if (user.equals("바위")) rst = 0;
                else rst = 1;
                System.out.println("사용자 = " + user + " , 컴퓨터 = " + str[n] + result[rst]);
            }
        }
        s.close();
    }
}
