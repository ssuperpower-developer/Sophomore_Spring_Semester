class DataBase {
  // This class is for Seat Data Base
  static private String[][] seat = {
      { "---", "---", "---", "---", "---", "---", "---", "---", "---", "---" },
      { "---", "---", "---", "---", "---", "---", "---", "---", "---", "---" },
      { "---", "---", "---", "---", "---", "---", "---", "---", "---", "---" } };

  static public String returnSeatClass(int seatClassNumber) {
    if (seatClassNumber == 0)
      return "S >>> ";
    else if (seatClassNumber == 1)
      return "A >>> ";
    else if (seatClassNumber == 2)
      return "B >>> ";
    else
      return null;
  }

  static public void showSeatStatus(int seatClassNumber) {
    System.out.print(returnSeatClass(seatClassNumber));
    for (int i = 0; i < seat[seatClassNumber].length; ++i) {
      System.out.print(seat[seatClassNumber][i] + " ");
    }
    System.out.println(" ");
  }

  static public void addUserInfo(String name, int seatClassNumber,
      int seatNumber) {
    seat[seatClassNumber][seatNumber] = name;
  }

  static public void deleteUserInfo(int seatClassNumber, String name) {
    for (int i = 0; i < seat[seatClassNumber].length; ++i) {
      if (seat[seatClassNumber][i].equals(name)) {
        seat[seatClassNumber][i] = "---";
        break;
      }
    }
  }

}
