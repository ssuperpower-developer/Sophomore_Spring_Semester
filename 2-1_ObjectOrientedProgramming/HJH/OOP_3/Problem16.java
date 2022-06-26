import java.util.Scanner;

public class Problem16 {
    public static void main(String[] args) {
        String[] str = {"가위","바위","보"};
        Scanner scanner = new Scanner(System.in);
        String computer = null;
        while(true){
            System.out.println("컴퓨터와 가위 바위 보 게임을 시작합니다.");
            System.out.print("가위 바위 보!>>");
            // 사용자
            String input = scanner.next();
            if(input.equals("그만")){
                System.out.println("게임을 종료합니다.");
                break;
            }
            // 컴퓨터
            int n = (int)(Math.random()*3+1);
            if(str[n].equals("바위")) computer = "바위";
            else if (str[n].equals("가위")) computer = "가위";
            else if (str[n].equals("보")) computer = "보";

            System.out.printf("사용자 = %s, 컴퓨터 = %s, ",input,computer);
            if(input.equals("가위")){
                if(computer.equals("가위")) System.out.print("비겼습니다.");
                else if(computer.equals("바위")) System.out.print("사용자가 졌습니다.");
                else if(computer.equals("보")) System.out.print("사용자가 이겼습니다.");
            }

            else if(input.equals("바위")){
                if(computer.equals("가위")) System.out.print("사용자가 이겼습니다.");
                else if(computer.equals("바위")) System.out.print("비겼습니다.");
                else if(computer.equals("보")) System.out.print("사용자가 졌습니다.");
            }

            else if(input.equals("보")){
                if(computer.equals("가위")) System.out.print("사용자가 졌습니다.");
                else if(computer.equals("바위")) System.out.print("사용자가 이겼습니다.");
                else if(computer.equals("보")) System.out.print("비겼습니다.");
            }
            System.out.println();
        }
    }
}
