package sec06.exam06;

public class Car {
	// Field
	private int speed;
	private boolean stop;

	// Constructor

	// Method
	// Below Method is Getter
	public int getSpeed() {
		return speed;
	}

	// Below Method is Setter
	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	}
}
