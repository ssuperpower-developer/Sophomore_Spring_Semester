import java.util.Scanner;

public class Question14 {
  public static void main(String[] args) {
    String[] course = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드" };
    int[] score = { 95, 88, 76, 62, 55 };

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("과목 이름 >> ");
      String temp = sc.nextLine();

      if (temp.equals("그만")) {
        break;
      }

      boolean status = true;

      for (int i = 0; i < 5; ++i) {
        if (temp.equals(course[i])) {
          System.out.println(course[i] + "의 점수는 " + score[i]);
          status = true;
          break;
        } else {
          status = false;
        }
      }

      if (status == false) {
        System.out.println("없는 과목입니다.");
      } else {
        continue;
      }

    }

    sc.close();
  }
}
