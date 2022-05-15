import java.util.Scanner;

public class MakeReservation {
  // sc를 close 하지 않아도 경고 메세지가 뜨지 않는다. 이유는?
  Scanner sc = new Scanner(System.in);
  private int seatClass;
  private int seatNumber;
  private String userName;

  public void chooseSeatClass() {
    while (true) {
      try {
        System.out.print("좌석구분 S(1) A(2) B(3) >> ");
        seatClass = sc.nextInt();
        --seatClass;
        DataBase.showSeatStatus(seatClass);
        break;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("잘못된 좌석을 선택하셨습니다. 다시 선택하세요.");
      }
    }
  }

  public void chooseSeatNumber() {
    System.out.print("이름 >> ");
    userName = sc.next();
  }

  public void makeReservation() {
    while (true) {
      try {
        System.out.print("번호 >> ");
        seatNumber = sc.nextInt();
        --seatNumber;
        DataBase.addUserInfo(userName, seatClass, seatNumber);
        break;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("잘못된 좌석을 선택하셨습니다. 다시 선택하세요.");
      }
    }
  }
}
