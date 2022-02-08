package sec01.exam05;

public class SmartTelevisionExample {
	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();
		
		RemoteControl rc = tv;
		Searchable searchable = tv;
	}
}
