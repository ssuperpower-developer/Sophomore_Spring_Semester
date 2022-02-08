public class AnonymousExample {
  public static void main(String args[]) {
    Anonymous anony = new Anonymous();

    anony.field.wake();

    anony.method1();

    anony.method2(new Person() {
      void study() { System.out.println("Studying"); }

      @Override
      void wake() {
        System.out.println("Wakeup at 8am");
        study();
      }
    });
  }
}
