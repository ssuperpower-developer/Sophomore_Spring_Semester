import java.util.Random;
import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("정수 몇개?");
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = (int)(Math.random()*100+1);
            for(int j=0;j<i;j++) {
                if (arr[j] == arr[i]) i = i - 1;    // 중복을 제거 할 수 있게 한다
            }
        }
        for(int i=0;i<num;i++){
            System.out.printf("%d ",arr[i]);
            if(i%10 == 9) System.out.println();
        }
    }
}
