public class CheckReservation {
  public void showSeatStatus() {
    DataBase.showSeatStatus(0);
    DataBase.showSeatStatus(1);
    DataBase.showSeatStatus(2);
    System.out.println("<<<조회를 완료하였습니다.>>>");
  }
}
