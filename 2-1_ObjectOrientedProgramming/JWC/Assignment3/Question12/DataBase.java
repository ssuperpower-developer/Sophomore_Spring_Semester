class DataBase {
  // This class is for Seat Data Base
  static private String[][] seat = {
      { "---", "---", "---", "---", "---", "---", "---", "---", "---", "---" },
      { "---", "---", "---", "---", "---", "---", "---", "---", "---", "---" },
      { "---", "---", "---", "---", "---", "---", "---", "---", "---", "---" } };

  static public String[] seatClassIndex = { "S >>> ", "A >>> ", "B >>> " };

  static public void showSeatStatus(int seatClassNumber) throws ArrayIndexOutOfBoundsException {
    System.out.print(seatClassIndex[seatClassNumber]);

    for (int i = 0; i < seat[seatClassNumber].length; ++i) {
      System.out.print(seat[seatClassNumber][i] + " ");
    }
    System.out.println(" ");
  }

  static public void addUserInfo(String name, int seatClassNumber,
      int seatNumber) throws ArrayIndexOutOfBoundsException {
    seat[seatClassNumber][seatNumber] = name;
  }

  static public void deleteUserInfo(int seatClassNumber, String name) throws ArrayIndexOutOfBoundsException {
    for (int i = 0; i < seat[seatClassNumber].length; ++i) {
      if (seat[seatClassNumber][i].equals(name)) {
        seat[seatClassNumber][i] = "---";
        break;
      }
    }
  }

}
