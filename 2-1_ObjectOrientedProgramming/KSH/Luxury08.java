import java.util.Scanner;

public class Luxury08 {
    public static boolean inRect(int x, int y) {
        if((x >= 100 && x <= 200) && (y >= 100 && y <= 200))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("점(x1, y1)의 좌표를 입력하시오>>");
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        System.out.print("점(x2, y2)의 좌표를 입력하시오>>");
        int x2 = s.nextInt();
        int y2 = s.nextInt();
        if(inRect(x1, y1) || inRect(x2, y2)) System.out.println("두 사각형은 충돌한다.");
        else System.out.println("두 사각형은 충돌하지 않는다.");
        s.close();
    }
}

