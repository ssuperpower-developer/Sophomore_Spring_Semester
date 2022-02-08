package sec05.exam03;

public class Car {
	int speed;

	void run() {
		System.out.println(speed + "으로 달립니다.");
	}

	// 메인함수도 정적 메서드이기 때문에, 필드를 사용하려면 객체를 생성해야 한다
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();
	}
}
