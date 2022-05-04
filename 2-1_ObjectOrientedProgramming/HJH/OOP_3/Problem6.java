import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        System.out.printf("금액을 입력하시오>>");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int [] unit = {50000,10000,1000,500,100,50,10,1};
        for(int i=0;i<8;i++){
            if(input/unit[i]==0) continue;
            System.out.printf("%d원 짜리 : %d개",unit[i],input/unit[i]);
            input = input - unit[i]*(input/unit[i]);
            System.out.println();
        }
    }
}
