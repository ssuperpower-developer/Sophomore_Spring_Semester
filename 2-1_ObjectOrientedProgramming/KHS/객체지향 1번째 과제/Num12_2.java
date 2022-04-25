import java.util.Scanner;
public class Num12_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("연산>>");
        float firstNum= scanner.nextInt();
        String operator = scanner.next();
        float secNum= scanner.nextInt();
        float result=0;
        switch(operator){
            case ("+"):
                result=firstNum+secNum;
            break;
            case ("-"):
                result=firstNum-secNum;
                break;
            case ("*"):
                result=firstNum*secNum;
                break;
            case ("/"):
                result=firstNum/secNum;
                break;
        }
        System.out.println(firstNum+operator+secNum+"의 계산결과는 "+result);

    }
}
