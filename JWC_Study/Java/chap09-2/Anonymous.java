public class Anonymous {
  Person field = new Person() {
    void work() { System.out.println("Go to work"); }

    @Override
    void wake() {
      System.out.println("Wakeup at 6am");
      work();
    }
  };

  void method1() {
    Person localVar = new Person() {
      void walk() { System.out.println("Go for a walk"); }

      @Override
      void wake() {
        System.out.println("Wakeup at 7am");
        walk();
      }
    };

    localVar.wake();
  }

  void method2(Person person) { person.wake(); }
}
