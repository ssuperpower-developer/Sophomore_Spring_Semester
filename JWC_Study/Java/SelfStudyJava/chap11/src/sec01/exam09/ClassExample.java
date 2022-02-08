package sec01.exam09;

public class ClassExample {
	public static void main(String[] args) throws Exception {
		//how1
		Class clazz = Car.class;
		
		//how2
		//Class clazz = Class.forName("sec01.exam09.Car");
		
		//how3
		//Car car = new Car();
		//Class clazz = car.getClass();
		
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
	}
}
