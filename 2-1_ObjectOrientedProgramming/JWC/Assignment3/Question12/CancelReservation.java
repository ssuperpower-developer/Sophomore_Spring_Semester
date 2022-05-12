import java.util.Scanner;

public class CancelReservation {
  Scanner sc = new Scanner(System.in);
  private int seatClassNumber;
  private String userName;

  public void chooseSeatClass() {
    System.out.print("좌석구분 S(1) A(2) B(3) >> ");
    seatClassNumber = sc.nextInt();
    --seatClassNumber;
    DataBase.showSeatStatus(seatClassNumber);
  }

  public void cancelReservation() {
    System.out.print("이름 >> ");
    userName = sc.next();
    DataBase.deleteUserInfo(seatClassNumber, userName);
  }
}
