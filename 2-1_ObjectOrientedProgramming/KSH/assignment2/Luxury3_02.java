public class Luxury3_02 {
    public static void main(String[] args) {
        int n[][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};    // 2차원 배열 초기화
        for(int i = 0; i < n.length; i++) {     // 행의 개수만큼 반복
            for (int j = 0; j < n[i].length; j++)       // 각 행의 열의 개수만큼 반복
                System.out.print(n[i][j] + " ");    // 한 행 출력
            System.out.println();       // 개행
        }
    }
}
