package sec06.exam05.package1;

public class A {
	// 필드
	public int field1;
	int field2;
	private int field3;

	// 생성자
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;

		method1();
		method2();
		method3();
	}

	// 매서드
	public void method1() {
		System.out.println("This is Method1");
	}

	void method2() {
		System.out.println("This is Method2");
	}

	private void method3() {
		System.out.println("This is Method3");
	}
}
