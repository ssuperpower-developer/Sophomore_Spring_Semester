import java.util.Scanner;

public class sixth {
    public static void main(String[] args) {
        System.out.printf("연산>> ");
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        String how = scanner.next();
        int second = scanner.nextInt();

        switch (how){
            case "+":
                System.out.printf("%d+%d의 계산 결과는 %d",first,second,first+second);
                break;
            case "-":
                System.out.printf("%d-%d의 계산 결과는 %d",first,second,first-second);
                break;
            case "*":
                System.out.printf("%d*%d의 계산 결과는 %d",first,second,first*second);
                break;
            case "/":
                if(second==0){
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                System.out.printf("%d/%d의 계산 결과는 %d",first,second,first/second);
                break;
        }

    }
}
