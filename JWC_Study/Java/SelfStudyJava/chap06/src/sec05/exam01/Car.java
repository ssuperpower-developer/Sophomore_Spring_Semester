package sec05.exam01;

public class Car {
	// 필드
	String model;
	int speed;

	// 생성자
	Car(String pmodel) {
		this.model = pmodel;
	}

	// 메소드
	void setSpeed(int pspeed) {
		this.speed = pspeed;
	}

	void run() {
		for (int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속:" + this.speed + "km/h)");
		}
	}
}
