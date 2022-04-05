import java.util.Scanner;
public class Num12_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("연산>>");
        float firstNum= scanner.nextInt();
        String operator = scanner.next();
        float secNum= scanner.nextInt();
        float result=0;
        if (operator.equals("+"))result=firstNum+secNum;
        else if(operator.equals("-"))result=firstNum-secNum;
        else if(operator.equals("*"))result=firstNum*secNum;
        else if(operator.equals("/"))result=firstNum/secNum;

        System.out.println(firstNum+operator+secNum+"의 계산결과는 "+result);

    }
}
