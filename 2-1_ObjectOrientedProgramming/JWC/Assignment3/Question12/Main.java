import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static final int MAKE_RESERVATION = 1, CHECK_RESERVATION = 2,
      CANCEL_RESERVATION = 3, SHUT_DOWN_PROGRAM = 4;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MakeReservation makeReservationSystem = new MakeReservation();
    CheckReservation checkReservationSystem = new CheckReservation();
    CancelReservation cancelReservationSystem = new CancelReservation();

    int menuOption = 0;
    System.out.println("명품콘서트홀 예약시스템입니다.");

    while (true) {
      /*
      Refactoring Question!!
      메뉴 옵션을 입력받으려고 하는 상황에서 정수가 아닌 문자열을 입력받았을 때
      정상적으로 처리되지 않는 상황입니다. 해결방법이 있을까요??
      */
      try {
        System.out.print("예약 : 1, 조회 : 2, 취소 : 3, 끝내기 : 4 >> ");
        menuOption = sc.nextInt();

        switch (menuOption) {
          case MAKE_RESERVATION:
            makeReservationSystem.chooseSeatClass();
            makeReservationSystem.chooseSeatNumber();
            makeReservationSystem.makeReservation();
            break;

          case CHECK_RESERVATION:
            checkReservationSystem.showSeatStatus();
            break;

          case CANCEL_RESERVATION:
            cancelReservationSystem.chooseSeatClass();
            cancelReservationSystem.cancelReservation();
            break;
        }

        if (menuOption == SHUT_DOWN_PROGRAM)
          break;

      } catch (InputMismatchException e) {
        System.out.println("잘못된 형식의 입력입니다. 다시 입력해주세요.");
        menuOption = sc.nextInt();
      }
    }

    sc.close();
  }
}
