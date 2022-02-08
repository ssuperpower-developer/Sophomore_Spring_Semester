public class MemberServiceExample {
  public static void main(String args[]) {
    MemberService memberService = new MemberService();

    boolean result = memberService.login("hong", "12345");

    if (result) {
      System.out.println("Login Completed");
    } else {
      System.out.println("Id or PSCode is incorrect");
    }
  }
}
