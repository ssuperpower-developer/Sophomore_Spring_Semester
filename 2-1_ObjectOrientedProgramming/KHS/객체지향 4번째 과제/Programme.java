import java.util.InputMismatchException;
import java.util.Scanner;

public class Programme {
    static Scanner scanner = new Scanner(System.in);
    static private String[][] seat = new String[3][10];

    public static void main(String[] args) {
        Programme a = new Programme();
    }

    public void Status() {
        try {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
            Choose(scanner.nextInt());
        } catch (InputMismatchException a) {
            System.out.println("입력 오류입니다. 메뉴로 돌아가겠습니다.");
            scanner.nextLine();//버퍼 비우기용
            Status();
        } catch (ArrayIndexOutOfBoundsException b) {
            System.out.println("입력 오류입니다. 메뉴로 돌아가겠습니다.");
            scanner.nextLine();//버퍼 비우기용
            Status();
        }
    }

    Programme() {
        System.out.println("명품콘서트 홀 예약시스템입니다.");
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) seat[i][j] = "---";
        }
        Status();
    }

    public void Choose(int input) {
        if (input == 1) Reserve();
        else if (input == 2) Show();
        else if (input == 3) Cancel();
        else if (input == 4) {
            System.out.println("프로그램 종료");
            return;
        } else {
            System.out.println("없는 메뉴입니다. 재입력 바랍니다.");
        }
        Status();
    }

    void Reserve() throws InputMismatchException {
        System.out.print("좌석 구분 S(1), A(2), B(3)>>");
        MakeReserve(Show(scanner.nextInt()));
    }

    void Cancel() {
        System.out.print("좌석 구분 S(1), A(2), B(3)>>");
        int num = scanner.nextInt();
        Show(num);
        String name = CheckName();
        boolean NoCancel=true;
        for (int i = 0; i < seat[num - 1].length; i++) {
            if (seat[num - 1][i].equals(name)) {seat[num - 1][i] = "---";NoCancel=false;}
        }
        if (NoCancel) System.out.println("해당하는 이름을 찾지 못했습니다. 메뉴로 돌아가겠습니다.");
    }

    int Show(int a) {
        if (a == 1) System.out.print("S>> ");
        else if (a == 2) System.out.print("A>> ");
        else if (a == 3) System.out.print("B>> ");
        for (int i = 0; i < seat[a - 1].length; i++) {
            System.out.print(seat[a - 1][i] + " ");
        }
        System.out.println("");
        return a - 1;
    }

    void Show() {
        for (int i = 0; i < seat.length; i++) {
            if (i == 0) System.out.print("S>> ");
            else if (i == 1) System.out.print("A>> ");
            else if (i == 2) System.out.print("B>> ");
            for (int j = 0; j < seat[i].length; j++) System.out.print(seat[i][j] + " ");
            System.out.println(" ");
        }
        System.out.println("<<조회를 완료하였습니다>>");
    }

    void MakeReserve(int show) {
        String tempname = CheckName();
        int tempnum = CheckNum();
        if (seat[show][tempnum - 1].equals("---")) seat[show][tempnum - 1] = tempname;
        else System.out.println("이미 예약되었습니다. 재입력해주세요");
        //seat[show][CheckNum(scanner.nextInt())]=CheckName(scanner.next());
    }

    String CheckName() {
        System.out.print("이름>>");
        String name = scanner.next();
        return name;
    }

    int CheckNum() {
        System.out.print("번호>>");
        int num = scanner.nextInt();
        return num;
    }
}