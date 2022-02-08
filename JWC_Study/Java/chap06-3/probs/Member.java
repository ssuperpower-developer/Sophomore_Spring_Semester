public class Member {
  String Name, firstName;

  Member(String pName, String pFirstName) {
    Name = pName;
    firstName = pFirstName;
  }

  public void printUser() { System.out.println(Name + firstName); }
}
