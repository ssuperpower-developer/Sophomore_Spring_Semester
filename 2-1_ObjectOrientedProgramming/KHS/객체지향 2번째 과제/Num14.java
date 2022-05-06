import java.util.Scanner;

public class Num14 {
    public static void main(String[] args) {
        String course[] = {"Java", "C++", "HTML", "컴퓨터구조", "안드로이드"};
        int score[] = {95, 88, 76, 62, 55};
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            System.out.print("과목 이름:");
            String input = scanner.next();
            if (input.equals("그만")) break;
            for (; i < course.length; i++) {
                if (input.equals(course[i])) break;
            }
            try {
                System.out.println(input + "의 점수는 " + score[i]);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                System.out.println("없는 과목입니다.");
            }
            i = 0;//예외 생성용 초기화
        }

    }
}

