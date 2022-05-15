import java.util.Scanner;

public class CancelReservation {
  Scanner sc = new Scanner(System.in);
  private int seatClassNumber;
  private String userName;

  public void chooseSeatClass() {
    while (true) {
      try {
        System.out.print("좌석구분 S(1) A(2) B(3) >> ");
        seatClassNumber = sc.nextInt();
        --seatClassNumber;
        DataBase.showSeatStatus(seatClassNumber);
        break;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("잘못된 좌석을 선택하셨습니다. 다시 선택하세요.");
      }
    }
  }

  public void cancelReservation() {
    while (true) {
      try {
        System.out.print("이름 >> ");
        userName = sc.next();
        DataBase.deleteUserInfo(seatClassNumber, userName);
        break;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("잘못된 좌석을 선택하셨습니다. 다시 선택하세요.");
      }
    }
  }
}
