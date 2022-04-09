import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("정수 3개 입력 >> ");
        int[] inputArray = new int[3];
        for(int i=0;i<inputArray.length;i++)
            inputArray[i]=scanner.nextInt();

        for(int i=0; i<inputArray.length;i++){
            for(int j=i+1;j< inputArray.length;j++){
                if(inputArray[i]>inputArray[j]) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
        System.out.println("중간 값은 " + inputArray[1]);
    }
}
