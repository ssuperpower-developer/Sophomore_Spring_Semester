package sec02.exam02;

public class ForSumFrom1To100Example1 {
	public static void main(String[] args) {
		int sum = 0; 
		
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		
		System.out.println("1~100 гу : " + sum);
	}
}

