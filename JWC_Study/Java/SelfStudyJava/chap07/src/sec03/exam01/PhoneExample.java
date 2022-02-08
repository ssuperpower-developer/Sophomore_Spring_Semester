package sec03.exam01;

public class PhoneExample {
	public static void main(String[] args) {
		// Phone phone = new Phone(); (x)

		SmartPhone smartPhone = new SmartPhone("???");

		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}
}
