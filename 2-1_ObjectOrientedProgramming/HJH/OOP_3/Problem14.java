import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        String[] course = {"Java","C++","HTML5","컴퓨터구조","안드로이드"};
        int[] score = {95,88,76,62,55};
        Scanner scanner = new Scanner(System.in);
        outer: while(true){
            System.out.print("과목 이름>>");
            String input = scanner.next();
            if(input.equals("그만"))   break;
            for(int i=0;i<5;i++) {
                if (course[i].equals(input)) {
                    System.out.printf("%s의 점수는 %d", input, score[i]);
                    System.out.println();
                    continue outer;
                }
            }
            System.out.println("없는 과목입니다.");
        }





//        do{
//            System.out.printf("과목 이름>>");
//            input = scanner.next();
//            for(int i=0;i<5;i++) {
//                if (course[i] == input)
//                    System.out.printf("%s의 점수는 %d", input, score[i]);
//            }
//        }while(input == "그만");








//        while(input != "그만"){
//            System.out.printf("과목 이름>>");
//            input = scanner.next();
//            for(int i=0;i<5;i++) {
//                if (course[i] == input) System.out.printf("%s의 점수는 %d", input, score[i]);
//            }
//        }
    }
}
