public class Problem10 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int[][] alreadyIn = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                alreadyIn[i][j]=-1;
            }
        }
        int time=1;
        while(time<=10){
//            (int) Math.random() * (최댓값-최소값+1) + 최소값
            int input=(int)(Math.random()*(10-1+1)+1);
            int x = (int)(Math.random()*(3-0+1)+0);
            int y = (int)(Math.random()*(3-0+1)+0);
            if(alreadyIn[x][y]==-1){
                alreadyIn[x][y]=1;
                arr[x][y]=input;
                ++time;
            }
            else if(alreadyIn[x][y]==1){
                continue;
            }
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}
