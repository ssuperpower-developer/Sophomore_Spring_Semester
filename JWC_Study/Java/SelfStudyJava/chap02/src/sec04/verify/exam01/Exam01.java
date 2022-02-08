package sec04.verify.exam01;

public class Exam01 {
	public static void main(String[] args) {
		String name = "감자바";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %1$s-%2$s-%3$s", tel1, tel2, tel3);
	}
}
