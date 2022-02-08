package sec02.verify.exam05;

public class Exam05 {
	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
				if (j == i) {
					System.out.println();
				}
			}
		}
	}
}
