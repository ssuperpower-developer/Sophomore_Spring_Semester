public class NestedClassExample {
  public static void main(String args[]) {
    Car myCar = new Car();

    // Why?
    Car.Tire tire = myCar.new Tire();

    Car.Engine engine = new Car.Engine();
  }
}
