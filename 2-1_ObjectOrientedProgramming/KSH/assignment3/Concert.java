import java.util.Scanner;

class Reservation {
    private static  final String[] sSeat = new String[10];
    private static final String[] aSeat = new String[10];
    private static final String[] bSeat = new String[10];
    public static void reset(){
        for(int i = 0; i < 10; i++){
            sSeat[i] = aSeat[i] = bSeat[i] = "---";
        }
    }
    private static void showS(){
        System.out.print("S>> ");
        for(int i = 0; i < 10; i++){
            System.out.print(sSeat[i] + "\t");
        }
        System.out.println();
    }
    private static void showA(){
        System.out.print("A>> ");
        for(int i = 0; i < 10; i++){
            System.out.print(aSeat[i] + "\t");
        }
        System.out.println();
    }
    private static void showB(){
        System.out.print("B>> ");
        for(int i = 0; i < 10; i++){
            System.out.print(bSeat[i] + "\t");
        }
        System.out.println();
    }
    public static void rsv(){
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.print("좌석구분 S(1), A(2), B(3)>>");
            int seat = s.nextInt();
            if(seat <= 0 || seat >= 4) {
                System.out.println("없는 좌석입니다.");
                continue;
            }
            if (seat == 1) {
                showS();
                System.out.print("이름>>");
                String name = s.next();
                System.out.print("번호>>");
                int num = s.nextInt();
                if(num < 1 || num > 10){
                    System.out.println("없는 번호입니다.");
                    continue;
                }
                if(!sSeat[num - 1].equals("---")){
                    System.out.println("이미 예약된 좌석입니다.");
                    continue;
                }
                sSeat[num - 1] = name;
                break;
            }
            else if (seat == 2) {
                showA();
                System.out.print("이름>>");
                String name = s.next();
                System.out.print("번호>>");
                int num = s.nextInt();
                if(num < 1 || num > 10){
                    System.out.println("없는 번호입니다.");
                    continue;
                }
                if(!aSeat[num - 1].equals("---")) {
                    System.out.println("이미 예약된 좌석입니다.");
                    continue;
                }
                aSeat[num - 1] = name;
                break;
            }
            else {
                showB();
                System.out.print("이름>>");
                String name = s.next();
                System.out.print("번호>>");
                int num = s.nextInt();
                if(num < 1 || num > 10){
                    System.out.println("없는 번호입니다.");
                    continue;
                }
                if(!bSeat[num - 1].equals("---")) {
                    System.out.println("이미 예약된 좌석입니다.");
                    continue;
                }
                bSeat[num - 1] = name;
                break;
            }
        }
    }
    public static void show(){
        showS();
        showA();
        showB();
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
    public static void del(){
        int i;
        Scanner s = new Scanner(System.in);
        OUTER:
        while(true) {
            System.out.print("좌석 S:1, A:2, B:3>>");
            int num = s.nextInt();
            if(num <= 0 || num >= 4){
                System.out.println("없는 좌석입니다.");
                continue;
            }
            if (num == 1) {
                showS();
            }
            if (num == 2) {
                showA();
            }
            if (num == 3) {
                showB();
            }
            System.out.print("이름>>");
            String name = s.next();
            for(i = 0; i < 10; i++){
                if(num == 1 && name.equals(sSeat[i])){
                    sSeat[i] = "---";
                    break OUTER;
                }
                if(num == 2 && name.equals(aSeat[i])){
                    aSeat[i] = "---";
                    break OUTER;
                }
                if(num == 3 && name.equals(bSeat[i])){
                    bSeat[i] = "---";
                    break OUTER;
                }
            }
            if (i == 10) {
                System.out.println("없는 이름입니다.");
            }
        }
    }
}

public class Concert {
    public static void main(String[] args) {
        Reservation.reset();
        Scanner s = new Scanner(System.in);
        System.out.println("명품콘서트 예약 시스템입니다.");
        while(true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int menu = s.nextInt();
            if(menu >= 5 || menu <= 0){
                System.out.println("없는 메뉴입니다.");
                continue;
            }
            if (menu == 1) Reservation.rsv();
            if(menu == 2) Reservation.show();
            if(menu == 3) Reservation.del();
            if(menu == 4) break;
        }
    }
}
