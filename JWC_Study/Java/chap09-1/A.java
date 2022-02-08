public class A {
  A() { System.out.println("Create A Object"); }

  class B {
    B() { System.out.println("Create B Object"); }

    int field1;

    void method1() {}
  }

  static class C {
    C() { System.out.println("Create C Object"); }

    int field1;
    static int field2;

    void method1() {}

    static void method2() {}
  }

  void method() {
    class D {
      D() { System.out.println("Create D Object"); }

      int field1;

      void method1() {}
    }

    D d = new D();
    d.field1 = 3;
    d.method1();
  }
}
