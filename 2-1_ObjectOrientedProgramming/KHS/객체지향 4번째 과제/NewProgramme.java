import java.util.InputMismatchException;
import java.util.Scanner;

public class NewProgramme {
    static Scanner scanner = new Scanner(System.in);
    static private String[][] seat = new String[3][10];

    public static void main(String[] args) {
        NewProgramme a = new NewProgramme();
    }

    NewProgramme() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) seat[i][j] = "---";
        }
        Status();
    }

    void Status() {
        System.out.println("명품콘서트 홀 예약시스템입니다.");
        System.out.println("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
        String input = scanner.next();
        if (input.charAt(0) == '1') Reserve();
        else if (input.charAt(0) == '2') Search();
        else if (input.charAt(0) == '3') Cancel();
        else if (input.charAt(0) == '4') {
            System.out.println("프로그램 종료");
            return;
        } else {
            System.out.println("없는 메뉴입니다. 재입력 바랍니다.");
        }
        Status();
    }

    void Reserve() {
        try {
            MakeReserve(SelectSeat());
        } catch (InputMismatchException e) {
            System.out.println("좌석번호를 숫자로 입력하세요");
        }
    }

    void Search() throws InputMismatchException{
        for (int i = 0; i < seat.length; i++) {
            if (i == 0) System.out.print("S>> ");
            else if (i == 1) System.out.print("A>> ");
            else if (i == 2) System.out.print("B>> ");
            for (int j = 0; j < seat[i].length; j++) System.out.print(seat[i][j] + " ");
            System.out.println(" ");
        }
        System.out.println("조회를 완료하였습니다");
    }

    void Search(int num) throws InputMismatchException {
        if (num == 1) System.out.print("S>> ");
        else if (num == 2) System.out.print("A>> ");
        else if (num == 3) System.out.print("B>> ");
        for (int i = 0; i < seat[num - 1].length; i++) {
            System.out.print(seat[num - 1][i] + " ");
        }
    }

    void Cancel() {

    }

    String SelectSeat() {
        System.out.println("좌석 구분 S(1), A(2), B(3)");
        String input = scanner.next();
        try{
        Search(input.charAt(0));
        if (input.charAt(0) == '1') {
            return input;
        } else if (input.charAt(0) == '2') {
            return input;
        } else if (input.charAt(0) == '3') {
            return input;
        } else {
            System.out.println("잘못된 좌석 번호입니다. 재입력 바랍니다.");
            return input;
        }}catch (InputMismatchException e){
            return input;//고쳐야함
        }
    }


    String CheckName() {
        System.out.println("이름>>");
        String name = scanner.next();
        return name;
    }

    int CheckNum() {
        System.out.println("번호>>");
        int num = scanner.nextInt();
        return num;
    }

    void MakeReserve(String Seatnum) {
        int Seat = Integer.parseInt(Seatnum);
        String tempname = CheckName();
        int tempnum = CheckNum();
        if (seat[Seat - 1][tempnum - 1].equals("---")) seat[Seat - 1][tempnum - 1] = tempname;
        else System.out.println("이미 예약되었습니다. 재입력해주세요");
        //seat[show][CheckNum(scanner.nextInt())]=CheckName(scanner.next());
    }

}
