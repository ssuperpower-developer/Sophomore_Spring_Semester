public class TryCatchFinallyExample {
  public static void main(String args[]) {
    try {
      Class clazz = Class.forName("java.lang.string2");
    } catch (ClassNotFoundException e) {
      System.out.println("There is NO class");
    }
  }
}
