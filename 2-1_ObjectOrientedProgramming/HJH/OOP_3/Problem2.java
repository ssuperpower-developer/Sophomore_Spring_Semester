public class Problem2 {
    public static void main(String[] args) {
        int[][] n = new int[5][];
        n[0] = new int[1];
        n[1] = new int[3];
        n[2] = new int[1];
        n[3] = new int[4];
        n[4] = new int[2];
        for(int i=0;i<5;i++){
            for(int j=0;j<n[i].length;j++) {
                n[i][j] = j + 1;
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<n[i].length;j++) {
                System.out.printf("%d ",n[i][j]);
            }
            System.out.println();
        }

    }
}

