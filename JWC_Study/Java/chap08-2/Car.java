public class Car {
  Tire frontLeftTire = new HankookTire();
  Tire frontRightTire = new HankookTire();
  Tire backLeftTire = new HankookTire();
  Tire backtRightTire = new HankookTire();

  void run() {
    frontLeftTire.roll();
    frontRightTire.roll();
    backLeftTire.roll();
    backtRightTire.roll();
  }
}
