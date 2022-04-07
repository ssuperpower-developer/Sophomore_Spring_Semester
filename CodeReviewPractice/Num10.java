import java.util.Scanner;
public class Num10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("첫번째 원의 중심과 반지름 입력");
        int x1= scanner.nextInt();
        int y1= scanner.nextInt();
        int r1= scanner.nextInt();

        System.out.println("두번째 원의 중심과 반지름 입력");
        int x2= scanner.nextInt();
        int y2= scanner.nextInt();
        int r2= scanner.nextInt();
        if(checkCircleR(getLength(x1,y1,x2,y2),r1,r2)==true) System.out.println("두 원은 서로 겹치지 않습니다.");
        else System.out.println("두 원은 서로 겹칩니다.");
        ;


    }
    public static boolean checkCircleR(int length,int r1, int r2){
        if(length>r1*r1+r2*r2+2*r1*r2){//점과 점 사이의 거리 공식 값은 원래 루트값-> 제곱값을 이용하여 연산, 따라서 완전제곱식 사용
            return true;               //루트값을 사용하긴 어려우므로 양변을 제곱함, 제곱하더라도 논리 연산은 동일
        }
        else{
            return false;
        }
    }
    public static int getLength(int x1,int y1, int x2, int y2){//점과 점사이의 거리 공식
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);

    }

}
