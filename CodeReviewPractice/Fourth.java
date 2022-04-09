import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        int x1,x2,y1,y2;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("두 점(x1,y1),(x2,y2)의 좌표를 입력하시오 >> ");
        x1=scanner.nextInt();
        y1=scanner.nextInt();
        x2=scanner.nextInt();
        y2=scanner.nextInt();
        boolean resultFor1 = inRect(x1,y1,100,100,200,200);
        boolean resultFor2 = inRect(x2,y2,100,100,200,200);
        boolean resulFor3 = inRect(x1,y2,100,100,200,200);
        boolean resulFor4 = inRect(x2,y1,100,100,200,200);
        if(resultFor1==true || resultFor2==true||resulFor3==true||resulFor4==true) System.out.println("(100,100),(200,200)의 두점으로 이루어진 직사각형과 충돌한다.");
        else System.out.println("(100,100),(200,200)의 두점으로 이루어진 직사각형과 충돌하지 않는다.");

    }

    public static boolean inRect(int x,int y,int rectx1,int recty1,int rectx2,int recty2){
        if((x>=rectx1 && x<=rectx2) && (y>=recty1 && y<=recty2)) return true;
        else return false;
    }

}
