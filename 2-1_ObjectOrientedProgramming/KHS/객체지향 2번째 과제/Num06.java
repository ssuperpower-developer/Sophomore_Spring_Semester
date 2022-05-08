import java.util.Scanner;
public class Num06 {
    public static void main(String[] args) {
        int [] init={50000,10000,1000,500,100,50,10,1};
        Scanner scanner=new Scanner(System.in);
        System.out.println("금액을 입력하세요 >>");
        int inputNum= scanner.nextInt();
        for (int i=0;i<init.length;i++){
            System.out.println(init[i]+"원 짜리 :"+inputNum/init[i]);
            inputNum-=(inputNum/init[i])*init[i];

        }
    }
}
