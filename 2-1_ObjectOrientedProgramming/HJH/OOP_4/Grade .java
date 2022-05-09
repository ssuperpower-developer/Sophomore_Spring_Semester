import java.util.Scanner;

public class Grade {
    private int math;
    private int science;
    private int english;
    Grade(int math,int science,int english){
        this.math = math;
        this.science = science;
        this.english = english;
    }
    public int average() {
        int ave = 0;
        ave = (math + science + english) / 3;
        return ave;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수학,과학,영어 순으로 3개의 점수 입력>>");
        int math = scanner.nextInt();
        int science = scanner.nextInt();
        int english = scanner.nextInt();
        Grade me = new Grade(math,science,english);
        System.out.println("평균은 "+me.average());

        scanner.close();
    }
}

