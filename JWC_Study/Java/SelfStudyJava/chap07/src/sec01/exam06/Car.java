package sec01.exam06;

public class Car {
	// 필드
	public int speed;

	// 메소드
	public void speedUp() {
		speed += 1;
	}

	// final 메소드
	public final void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
