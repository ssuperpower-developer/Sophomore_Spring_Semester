import java.util.Scanner;

public class Programme {
    static Scanner scanner = new Scanner(System.in);
    static private String[][] seat = new String[3][10];

    public static void main(String[] args) {
        Programme a = new Programme();
    }

    public void Status() {
        System.out.println("명품콘서트 홀 예약시스템입니다.");
        System.out.println("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
        Choose(scanner.nextInt());
    }

    Programme() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) seat[i][j] = "---";
        }
        Status();
    }

    public void Choose(int input) {
        if (input == 1) Reserve();
        else if (input == 2) Search();
        else if (input == 3) Cancel();
        else if (input == 4) {
            System.out.println("프로그램 종료");
            return;
        } else {
            System.out.println("없는 메뉴입니다. 재입력 바랍니다.");
        }
        Status();
    }

    void Reserve() {
        System.out.println("좌석 구분 S(1), A(2), B(3)");
        MakeReserve(Show(scanner.nextInt()));
    }

    void Search() {
        Show();
    }

    void Cancel() {
        int num=CheckNum();
        Show(num);
        String name=CheckName();
        for (int i=0;i<seat[num-1].length;i++){
            if(seat[num-1][i].equals(name))seat[num-1][i]="---";
        }
    }
    int Show(int a){
        for (int i=0;i<seat[a-1].length;i++){
            System.out.print(seat[a-1][i]+" ");
        }
        System.out.println("");
        return a-1;
    }
    void Show(){
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) System.out.print(seat[i][j]+" ");
            System.out.println(" ");
        }
        System.out.println("조회를 완료하였습니다");
    }
    void MakeReserve(int show){
        String tempname=CheckName();
        int tempnum=CheckNum();
        seat[show][tempnum-1]=tempname;
        //seat[show][CheckNum(scanner.nextInt())]=CheckName(scanner.next());
    }
    String CheckName(){
        System.out.println("이름>>");
        String name= scanner.next();
        return name;
    }
    int CheckNum(){
        System.out.println("번호>>");
        int num= scanner.nextInt();
        return num;
    }

}
