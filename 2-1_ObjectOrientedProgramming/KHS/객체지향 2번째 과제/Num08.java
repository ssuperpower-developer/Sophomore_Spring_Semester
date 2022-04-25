import java.util.Scanner;
import java.util.Random;
public class Num08 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        System.out.println("정수 몇개?");
        int num= scanner.nextInt();
        int a[]=new int[num];
        for (int i=0;i<a.length;i++){
            a[i]= random.nextInt(num);
            for (int j=0;j<i;j++){
                if (a[j]==a[i]){
                    i--;
                    break;
                }
            }
        }
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
