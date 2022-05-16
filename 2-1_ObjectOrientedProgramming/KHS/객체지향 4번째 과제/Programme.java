import java.util.ArrayList;
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
            System.out.println("명품콘서트 홀 예약시스템입니다.");
            System.out.println("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
            String input = scanner.next();
            if (input.charAt(0)=='1') Reserve();
            else if (input.charAt(0) == '2') Search();
            else if (input.charAt(0) == '3') Cancel();
            else if (input.charAt(0) == '4') {
                System.out.println("프로그램 종료");
                return;
            } else {
                System.out.println("없는 메뉴입니다. 재입력 바랍니다.");
            }
            Status();
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("잘못된 입력입니다.");
            Status();
        }catch (ArrayIndexOutOfBoundsException e){
            scanner.next();
            System.out.println("잘못된 입력입니다.");
            Status();
        }
    }
    Programme() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) seat[i][j] = "---";
        }
        Status();
    }

    /*public void Choose(int input) {
        try {
            if (input == 1) Reserve();
            else if (input == 2) Search();
            else if (input == 3) Cancel();
            else if (input == 4) {
                System.out.println("프로그램 종료");
                return;
            } else {
                System.out.println("없는 메뉴입니다. 재입력 바랍니다.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("없는 번호입니다. 재입력바랍니다.");
        }
        catch (InputMismatchException e){
            System.out.println("숫자로 입력해주세요. 재입력바랍니다");
        }finally {
            Status();
        }
    }*/

    void Reserve() {
        System.out.println("좌석 구분 S(1), A(2), B(3)");
        MakeReserve(Show(scanner.nextInt()));
    }

    void Search() {
        Show();
    }

    void Cancel() {
        boolean ExceptionChecker = true;
        int num = CheckNum();
        if (1 <= num && num <= 10) Show(num);
        else {
            System.out.println("없는 번호입니다.");
            return;
        }
        String name = CheckName();
        for (int i = 0; i < seat[num - 1].length; i++) {
            if (seat[num - 1][i].equals(name)) {
                seat[num - 1][i] = "---";
                ExceptionChecker = false;
            }
        }
        if (ExceptionChecker) System.out.println("없는 이름입니다. 다시 입력해주세요.");
    }

    int Show(int a) throws ArrayIndexOutOfBoundsException {

        for (int i = 0; i < seat[a - 1].length; i++) {
            System.out.print(seat[a - 1][i] + " ");
        }
        System.out.println("");
        return a - 1;

    }

    void Show() {
        for (int i = 0; i < seat.length; i++) {
            if(i==0) System.out.print("S>> ");
            else if(i==1) System.out.print("A>> ");
            else if(i==2) System.out.print("B>> ");
            for (int j = 0; j < seat[i].length; j++) System.out.print(seat[i][j] + " ");
            System.out.println(" ");
        }
        System.out.println("조회를 완료하였습니다");
    }

    void MakeReserve(int show) {
        String tempname = CheckName();
        int tempnum = CheckNum();
        if (seat[show][tempnum - 1].equals("---")) seat[show][tempnum - 1] = tempname;
        else System.out.println("이미 예약되었습니다. 재입력해주세요");
        //seat[show][CheckNum(scanner.nextInt())]=CheckName(scanner.next());
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

}
