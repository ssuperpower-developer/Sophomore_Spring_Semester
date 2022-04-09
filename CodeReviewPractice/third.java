import java.util.Scanner;

public class third {
    public static void main(String[] args) {
        System.out.printf("1~99 사이의 정수를 입력하시오 >> ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int one = input%10;
        int ten = input/10;
        int[] clapTime = new int[2];
        if(one==3||one==6||one==9)
            clapTime[0]=1;
        if(ten==3||ten==6||ten==9)
            clapTime[1]=1;
        System.out.printf("박수");
        for(int i=0;i<clapTime.length;i++)
            if(clapTime[i]==1) System.out.printf("짝");
    }
}

