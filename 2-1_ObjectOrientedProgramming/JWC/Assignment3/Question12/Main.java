import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MakeReservation makeReservationSystem = new MakeReservation();
    CheckReservation checkReservationSystem = new CheckReservation();
    CancelReservation cancelReservationSystem = new CancelReservation();

    int menuOption;
    System.out.println("명품콘서트홀 예약시스템입니다.");

    while (true) {
      System.out.print("예약 : 1, 조회 : 2, 취소 : 3, 끝내기 : 4 >> ");
      menuOption = sc.nextInt();

      switch (menuOption) {
        case 1:
          makeReservationSystem.chooseSeatClass();
          makeReservationSystem.chooseSeatNumber();
          makeReservationSystem.makeReservation();
          break;

        case 2:
          checkReservationSystem.showSeatStatus();
          break;

        case 3:
          cancelReservationSystem.chooseSeatClass();
          cancelReservationSystem.cancelReservation();
          break;
      }

      if (menuOption == 4)
        break;

    }

    sc.close();
  }
}
