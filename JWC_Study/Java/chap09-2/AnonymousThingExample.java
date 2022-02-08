public class AnonymousThingExample {
  public static void main(String args[]) {
    AnonymousThing anony = new AnonymousThing();

    anony.field.turnOn();

    anony.method1();

    anony.method2(new RemoteControl() {
      @Override
      public void turnOn() {
        System.out.println("Turn on smartTV");
      }

      @Override
      public void turnOff() {
        System.out.println("Turn off smartTV");
      }
    });
  }
}
