import java.util.Scanner;
public class Num04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("소문자 알파벳 하나를 입력하시오 >>");
        char input=sc.next().charAt(0);
        String abc= "abcdefghijklmnopqrstuvwxyz";
        for (int a=0;a<=(int)input-97;a++){
            System.out.println(abc.substring(0,(int)input-96-a));
        }
    }
}
