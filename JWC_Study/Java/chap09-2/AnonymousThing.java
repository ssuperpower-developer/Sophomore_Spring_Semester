public class AnonymousThing {
  RemoteControl field = new RemoteControl() {
    @Override
    public void turnOn() {
      System.out.println("Turn on TV");
    }

    @Override
    public void turnOff() {
      System.out.println("Turn off TV");
    }
  };

  void method1() {
    RemoteControl localVar = new RemoteControl() {
      @Override
      public void turnOn() {
        System.out.println("Turn on Audio");
      }

      @Override
      public void turnOff() {
        System.out.println("Turn off Audio");
      }
    };

    localVar.turnOn();
  }

  void method2(RemoteControl rc) { rc.turnOn(); }
}
