import java.util.Scanner;

public class Luxury12_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("연산>>");
        var num1 = s.nextInt();
        String operator = s.next();
        var num2 = s.nextInt();
        var result = 0;
        switch (operator){
            case "+":
                result = num1 + num2;
                System.out.println(num1+operator+num2+"의 계산 결과는" + result);
            case "-":
                result = num1 - num2;
                System.out.println(num1+operator+num2+"의 계산 결과는" + result);
            case"*":
                result = num1 * num2;
            case"/":
                if(num2 == 0) System.out.println("0으로 나눌 수 없습니다.");
                else{
                    result = num1 / num2;
                    System.out.println(num1+operator+num2+"의 계산 결과는" + result);
                }
        }
        s.close();
    }
}
