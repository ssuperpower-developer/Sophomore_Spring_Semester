import java.util.Scanner;
class seatDataBase{
    static String[][] seatStatement = new String[3][10];
    seatDataBase(){
        for(int i=0;i<3;i++) {
            for (int k = 0; k < 10; k++) {
                seatStatement[i][k] = "---";
            }
        }
    }
    static public void reservationMethod(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        int seatTypeForInput = scanner.nextInt();
        char seatStyleInChar = 'a';
        switch (seatTypeForInput){
            case 1:
                seatStyleInChar = 'S';
                break;
            case 2:
                seatStyleInChar = 'A';
                break;
            case 3:
                seatStyleInChar = 'B';
                break;
        }
        int seatTypeForIndex = seatTypeForInput - 1;
        System.out.printf("%c >>",seatStyleInChar);
        for(int i=0;i<10;i++){
            System.out.print(seatDataBase.seatStatement[seatTypeForIndex][i]);
            System.out.print(" ");
        }
        System.out.println();
        // 여기까지 상태 출력
        System.out.print("이름>>");
        String inputName = scanner.next();
        System.out.print("번호>>");
        int inputSeatNumber = scanner.nextInt();
        int inputSeatNumberForIndex = inputSeatNumber - 1;
        seatDataBase.seatStatement[seatTypeForIndex][inputSeatNumberForIndex] = inputName;
    }
    static public void funtionForGooglingSeat(){
        System.out.print("S>> ");
        for(int i=0;i<10;i++){
            System.out.print(seatDataBase.seatStatement[0][i]);
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("A>> ");
        for(int i=0;i<10;i++){
            System.out.print(seatDataBase.seatStatement[1][i]);
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("B>> ");
        for(int i=0;i<10;i++){
            System.out.print(seatDataBase.seatStatement[2][i]);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
    static public void funtionForcancelReservation(){
        System.out.print("좌석 S:1, A:2, B:3>>");
        Scanner scanner = new Scanner(System.in);
        int seatTypeForCancel = scanner.nextInt();
        int seatTypeForCancelInIndex = seatTypeForCancel - 1;
        switch (seatTypeForCancel){
            case 1:
                System.out.print("S>>");
                for(int i=0;i<10;i++){
                    System.out.print(seatDataBase.seatStatement[seatTypeForCancelInIndex][i]);
                    System.out.print(" ");
                }
                System.out.println();
                break;
            case 2:
                System.out.print("A>>");
                for(int i=0;i<10;i++){
                    System.out.print(seatDataBase.seatStatement[seatTypeForCancelInIndex][i]);
                    System.out.print(" ");
                }
                System.out.println();
                break;
            case 3:
                System.out.print("B>>");
                for(int i=0;i<10;i++){
                    System.out.print(seatDataBase.seatStatement[seatTypeForCancelInIndex][i]);
                    System.out.print(" ");
                }
                System.out.println();
                break;
        }
        System.out.print("이름>>");
        String nameForSeatCancel = scanner.next();
        for(int i=0;i<10;i++){
            if(seatDataBase.seatStatement[seatTypeForCancelInIndex][i].equals(nameForSeatCancel)){
                seatDataBase.seatStatement[seatTypeForCancelInIndex][i] = "---";
            }
        }
    }
}
public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        seatDataBase myDB = new seatDataBase();
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        outer: while(true){
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int numForChooseOption = scanner.nextInt();
            switch (numForChooseOption){
                case 1:
                    myDB.reservationMethod();
                    break;
                case 2:
                    myDB.funtionForGooglingSeat();
                    break;
                case 3:
                    myDB.funtionForcancelReservation();
                    break;
                case 4:
                    break outer;
            }
        }
    }
}