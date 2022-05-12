import java.util.Scanner;

public class PhoneBook {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int userCnt;
    System.out.print("인원수 >> ");
    userCnt = sc.nextInt();

    Phone[] phoneDataBase = new Phone[userCnt];
    String tempName, tempTel;
    for (int i = 0; i < userCnt; ++i) {
      System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력) >> ");
      tempName = sc.next();
      tempTel = sc.next();

      phoneDataBase[i] = new Phone(tempName, tempTel);
    }

    System.out.println("저장되었습니다...");

    String userSearchString;

    do {
      System.out.print("검색할 이름 >> ");
      userSearchString = sc.next();
      for (int i = 0; i < userCnt; ++i) {
        String phoneUserName = phoneDataBase[i].getName();
        if (phoneUserName.equals(userSearchString)) {
          phoneDataBase[i].showPersonInfo();
          break;
        } else {
          //
        }
      }
    } while (!userSearchString.equals("그만"));

    sc.close();
  }
}