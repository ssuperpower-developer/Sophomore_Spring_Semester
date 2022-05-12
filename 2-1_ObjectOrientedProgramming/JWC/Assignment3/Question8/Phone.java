public class Phone {
  private String name;
  private String tel;

  Phone() {
  }

  Phone(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }

  String getName() {
    return this.name;
  }

  void showPersonInfo() {
    System.out.println(this.name + "의 전화번호는 " + this.tel + "입니다.");
  }
}
