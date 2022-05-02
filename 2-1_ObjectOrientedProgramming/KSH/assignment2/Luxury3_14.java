import java.util.Scanner;

public class Luxury3_14 {
    public static void main(String[] args) {
        String[] course = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
        int[] score = {95, 88, 76, 62, 55};
        String name;
        Scanner s = new Scanner(System.in);
        while(true){
            int count = 0;
            int n = 0;
            System.out.print("과목이름>>");
            name = s.nextLine();    // name에 값 입력
            if(name.equals("그만")) break;    // 만약 입력한 값이 그만일 경우 반복문 탈출
            for(int i = 0; i < course.length; i++) {    // course 크기만큼 반복
                if (name.equals(course[i])){    // 입력 값과 같은 값이 있는지 찾는다
                    n = score[i];       // 값이 같을 경우 n에 넣음
                    System.out.println(course[i] + "의 점수는 " + n);
                }
                count++;        // for문 한번 돌 때마다 count 1 증가
            }
            if(count == course.length && n == 0) System.out.println("없는 과목입니다.");
            // 만약 for문이 끝까지 돌아 count가 course의 크기이고 n에 값이 들어오지 않았을 경우
            // 없는 과목 출력.
        }
        s.close();
    }
}
