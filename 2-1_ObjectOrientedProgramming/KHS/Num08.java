import java.util.Scanner;
import java.util.Arrays;
public class Num08 {
    public static void main(String[] args) {
        //직사각형 문제
        Scanner scanner=new Scanner(System.in);
        System.out.println("왼쪽 하단 모서리 입력");
        int x1= scanner.nextInt();
        int y1= scanner.nextInt();
        System.out.println("오른쪽 상단 모서리 입력");
        int x2= scanner.nextInt();
        int y2= scanner.nextInt();
        int xarray[]={x1,x1,x2,x2};//좌하 좌상 우상 우하
        int yarray[]={y1,y2,y2,y1};//동일

        int checker=0;
        for(int i=0;i<4;i++){
            if(inRect(xarray[i],yarray[i],100,100,200,200)==true) checker++;
        }
        if(checker>0) System.out.println("충돌합니다");
    }
    public static boolean inRect(int x,int y,int rectx1,int recty1,int rectx2,int recty2){
        if((x>=rectx1&&x<=rectx2)&&(y>=recty1&&y<=recty2))
            return true;
        else
            return false;

    }
}
