import java.util.Random;
import java.util.Scanner;

public class Luxury3_10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random rm = new Random();
        int[][] array ={{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        // array에 0이 아닌 값을 넣어주지 않으면 array[a][b] == 0 부분에 문제가 생겨서 전부 1로 초기화하였다.
        for(int i = 0; i < 6; i++){     // 6번 반복하여 0 6개 넣기.
            int a = rm.nextInt(4);  // 랜덤 행
            int b = rm.nextInt(4);  // 랜덤 열
            if(array[a][b] == 0) i--;       // 만약 이미 0인 경우 다시 다시 뽑기
            else array[a][b] = 0;       // 0이 아닌 경우 0 넣기
        }
        for(int i = 0; i < 4; i++){     // 행만큼 실행
            for(int j = 0; j < 4; j++){     // 열만큼 실행
                if(array[i][j] == 0){       // 만약 0이면 그냥 0 출력
                    System.out.print(array[i][j] + "\t");
                }
                else{       // 0이 아니면
                    array[i][j] = rm.nextInt(10) + 1;       // 1 ~ 10 사이의 값 넣기
                    System.out.print(array[i][j] + "\t");       // 값 출력
                }
            }
            System.out.println();
        }
        s.close();
    }
}
