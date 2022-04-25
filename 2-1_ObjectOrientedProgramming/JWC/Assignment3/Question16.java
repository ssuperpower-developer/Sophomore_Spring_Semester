import java.util.Scanner;
import java.util.Random;

public class Question16 {

  static String engine(String user) {
    String[] str = { "가위", "바위", "보" };
    Random rn = new Random();
    int pc = rn.nextInt(3);

    if (user.equals(str[pc])) {
      return (str[pc] + ", 비겼습니다.");
    } else if (user.equals("가위")) {
      if (str[pc].equals("바위"))
        return (str[pc] + ", 사용자가 졌습니다.");
      else if (str[pc].equals("보"))
        return (str[pc] + ", 사용자가 이겼습니다.");
    } else if (user.equals("바위")) {
      if (str[pc].equals("보"))
        return (str[pc] + ", 사용자가 졌습니다.");
      else if (str[pc].equals("가위"))
        return (str[pc] + ", 사용자가 이겼습니다.");
    } else if (user.equals("보")) {
      if (str[pc].equals("가위"))
        return (str[pc] + ", 사용자가 졌습니다.");
      else if (str[pc].equals("바위"))
        return (str[pc] + ", 사용자가 이겼습니다.");
    }

    return "";
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("가위 바위 보! >> ");
      String temp = sc.nextLine();
      if (temp.equals("그만")) {
        System.out.println("게임을 종료합니다...");
        break;
      }
      System.out.println("사용자 = " + temp + ", 컴퓨터 = " + engine(temp));
    }

    sc.close();
  }
}
