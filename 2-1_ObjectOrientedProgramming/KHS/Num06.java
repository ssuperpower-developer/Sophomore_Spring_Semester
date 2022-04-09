import java.util.Scanner;
public class Num06 {
    public static void main(String[] args) {
        //369게임
        Scanner scanner=new Scanner(System.in);
        int number= scanner.nextInt();
        int tennumber=number/10;
        int onenumber=number%10;
        int checker=0;
        for(int i=1;i<4;i++){
            if (tennumber==3*i)checker++;
            if (onenumber==3*i)checker++;
        }

        if (checker>0){
            System.out.print("박수");
        }
        if (checker==1) System.out.println("짝");
        if (checker==2) System.out.println("짝짝");


    }
}
