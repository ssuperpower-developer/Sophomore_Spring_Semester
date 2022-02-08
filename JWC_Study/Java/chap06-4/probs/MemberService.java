public class MemberService {
  private String id = "hong", pw = "12345";

  public boolean login(String pId, String pPW) {
    if (id == pId && pw == pPW) {
      return true;
    } else {
      return false;
    }
  }
}
