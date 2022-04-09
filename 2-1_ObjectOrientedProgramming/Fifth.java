import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("첫번째 원의 중심과 반지름 입력>> ");
        int firstCoreX = scanner.nextInt();
        int firstCoreY = scanner.nextInt();
        int firstRadius = scanner.nextInt();
        System.out.printf("두번째 원의 중심과 반지름 입력>> ");
        int secondCoreX = scanner.nextInt();
        int secondCoreY = scanner.nextInt();
        int secondRadius = scanner.nextInt();
        boolean answer = isOverlap(firstCoreX,firstCoreY,firstRadius,secondCoreX,secondCoreY,secondRadius);
        if(answer==true) System.out.println("두 원은 서로 겹친다.");
        else System.out.println("두 원은 서로 겹치지 않는다.");
    }

    public static boolean isOverlap(int firX,int firY,int firstRadi,int secX,int secY,int secondRadi ){
        int lenghtX= secX-firX;
        int lenghtY= secY-firY;
        int result = firstRadi+secondRadi;
        if(result*result>lenghtX*lenghtX+lenghtY*lenghtY) return true;
        else return false;
    }
}
