package sec02.exam02;

public class StopFlagExample {
	public static void main(String[] args)  {
		PrintThread printThread = new PrintThread();
		printThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		printThread.setStop(true);
	}
}

