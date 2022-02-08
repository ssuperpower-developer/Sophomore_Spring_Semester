package sec05.exam02;

public class CalculatorExample {
	public static void main(String[] args) {
		// 이런 식으로 파이값은 정적 데이터로 사용할 수 있다.
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);

		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
	}
}
