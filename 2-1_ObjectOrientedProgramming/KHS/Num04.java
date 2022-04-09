import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;
public class Num04 {
    public static void main(String[] args) {
        //중간값 출력
        Scanner scanner=new Scanner(System.in);
        int intarray[];
        intarray=new int[3];
        System.out.println("put 3 number");

        for(int i=0;i<intarray.length;i++){
            intarray[i]= scanner.nextInt();
        }
        Arrays.sort(intarray);

        System.out.println(intarray[1]);

    }
}