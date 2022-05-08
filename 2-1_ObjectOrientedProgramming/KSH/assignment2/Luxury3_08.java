import java.util.Random;
import java.util.Scanner;

public class Luxury3_08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random rm = new Random();
        System.out.print("정수 몇개?");
        int num = s.nextInt();  // numAry의 크기 결정
        int[] numAry = new int[num];    // numAry 배열 생성
        for(int i = 0; i < num; i++){   // num번 실행
            numAry[i] = rm.nextInt(100) + 1;  // 1 ~ 100 사이의 숫자 저장
            for(int j = 0; j < i; j++){ // i번 앞에 있는 값들과 비교
                if(numAry[j] == numAry[i]){ // 만약 같은 값이 나오면
                    i--;    // numAry[i]에 다시 값을 넣기 위해 i--를 한다.
                    break;
                }
            }
        }
        for(int i = 0; i < numAry.length; i++){ // numAry를 출력
            System.out.print(numAry[i] + "\t");
            if(i % 10 == 9){    // 한줄에 10개씩 출력
                System.out.println();   // 개행
            }
        }
        s.close();
    }
}

