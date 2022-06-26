import java.util.Scanner;
import java.util.Random;

public class Num16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String rcp[] = {"가위", "바위", "보"};
        int i = 0;
        while (true) {
            System.out.println("컴퓨터와 가위바위보 게임을 합니다.");
            System.out.println("가위바위보!");
            String userChoose = scanner.next();
            if (userChoose.equals("그만")) {
                System.out.println("게임 종료");
                break;
            }
            for (; i < rcp.length; i++) {
                if (userChoose.equals(rcp[i])) break;
            }
            int comChoose = random.nextInt(3);
            System.out.println("사용자->" + userChoose + " 컴퓨터->"+rcp[comChoose]);
            if(i-comChoose==2){
                System.out.println("사용자가 졌습니다");
            }
            else if (i-comChoose==1) {
                System.out.println("사용자가 이겼습니다");
            }
            else if (i-comChoose==0) {
                System.out.println("사용자가 비겼습니다");
            }
            else if (i-comChoose==-1) {
                System.out.println("사용자가 졌습니다");
            }
            else if (i-comChoose==-2) {
                System.out.println("사용자가 이겼습니다");
            }
            i=0;//초기화
            System.out.println(" ");
        }
    }
}

