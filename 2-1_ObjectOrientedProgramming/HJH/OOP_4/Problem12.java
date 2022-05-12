import java.util.Scanner;
class Problem12{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chooseOption;
        seatS s = new seatS();
        seatA a = new seatA();
        seatB b = new seatB();
        boolean stopWhile = true;

        System.out.println("명품콘서홀 예약 시스템입니다.");
        while(stopWhile) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            chooseOption = scanner.nextInt();
            switch (chooseOption){
                case 1:
                    System.out.print("좌석구분 S(1), A(2), B(3)>>");
                    int case1Input = scanner.nextInt();
                    if(case1Input == 1) {
                        System.out.print("S>>");
                        s.showSeatState();
                        System.out.print("이름:");
                        String inputname1 = scanner.next();
                        System.out.print("번호:");
                        int inputnum1 = scanner.nextInt();
                        s.booking("s",inputname1,inputnum1);

                    }
                    else if (case1Input == 2) {
                        System.out.print("A>>");
                        a.showSeatState();
                        System.out.print("이름:");
                        String inputname1 = scanner.next();
                        System.out.print("번호:");
                        int inputnum1 = scanner.nextInt();
                        a.booking("a",inputname1,inputnum1);
                    }
                    else if (case1Input == 3) {
                        System.out.print("B>>");
                        b.showSeatState();
                        System.out.print("이름:");
                        String inputname1 = scanner.next();
                        System.out.print("번호:");
                        int inputnum1 = scanner.nextInt();
                        b.booking("b",inputname1,inputnum1);
                    }
                    break;
                case 2:
                    seat.googling(s,a,b);
                    break;
                case 3:
                    System.out.print("좌석 S:1, A:2, B:3>>");
                    int input3num = scanner.nextInt();
                    if(input3num == 1) s.bookCanel(s);
                    else if (input3num == 2) a.bookCanel(a);
                    else if (input3num == 3) b.bookCanel(b);
                    break;
                case 4:
                    stopWhile = seat.finish();
                    break;
            }
        }
    }
}

class person{
    String name;
    String typeOfSeat;
//    int numberOfSeat;
    boolean IsGetSeat = false;
    String getName(){
        return name;
    }
    String getTypeOfSeat() {
        return typeOfSeat;
    }
//    int getNumberOfSeat(){
//        return numberOfSeat;
//    }
    boolean isGetSeat(){
        return IsGetSeat;
    }
}
class seat{
    // 생성자를 안 만들어서 그런가....
    char[] seatState = {'-','-','-',' ','-','-','-',' ','-','-','-',' ','-','-','-',' ','-','-','-',' ','-','-','-',' ','-','-','-',' ','-','-','-',' ','-','-','-',' ','-','-','-',' '};
    person[] table = new person[10];
    int howManyPeople;
    void showSeatState(){
        for(int i=0;i<40;i++){
            System.out.print(seatState[i]);
        }
        System.out.println();
    }

    void booking(String typeOfSeat,String name,int seatnum){
        this.table[howManyPeople].name = name;
//        this.table[howManyPeople].numberOfSeat = seatnum;
        this.table[howManyPeople].IsGetSeat = true;
        this.table[howManyPeople].typeOfSeat = typeOfSeat;
        for(int i=0;i<3;i++){
            this.seatState[(seatnum-1)*4+i] = name.charAt(i);
        }
        howManyPeople++;
    }
    final static void googling(seat S,seat A,seat B){
        System.out.print("S>>");
        System.out.println(S.seatState);
        System.out.print("A>>");
        System.out.println(A.seatState);
        System.out.print("B>>");
        System.out.println(B.seatState);
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
    void bookCanel(seat K){
        System.out.print(K.seatState);
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름>>");
        String inputName = scanner.next();
        for(int i=0;i<10;i++){
            if(K.table[i].name.equals(inputName)) {
                K.table[i].name = null;
                K.table[i].typeOfSeat = null;
                K.table[i].IsGetSeat = false;
                howManyPeople--;
                for (int k = i; k < i + 3; k++) {
                    this.seatState[k * 4 + k] = '-';
                }
            }
        }
    }
    static boolean finish(){
        return false;
    }
}
class seatS extends seat{ }
class seatA extends seat { }
class seatB extends seat{ }


// 조회, 끝내기는 잘 돌아가는데, 예약이 안됨 - 계속 nullpointexception 뜸