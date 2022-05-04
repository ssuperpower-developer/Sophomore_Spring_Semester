import java.util.Scanner;

public class Luxury10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("첫번째 원의 중심과 반지름 입력>>");
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int radius1 = s.nextInt();
        System.out.print("두번째 원의 중심과 반지름 입력>>");
        int x2 = s.nextInt();
        int y2 = s.nextInt();
        int radius2 = s.nextInt();
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        int addRadius = radius1 + radius2;
        if(distance < addRadius) System.out.println("두 원은 서로 겹친다.");
        else if(distance == addRadius) System.out.println("두 원은 한 점에서 만난다.");
        else System.out.println("두 원은 서로 겹치지 않는다.");
        s.close();
    }
}
