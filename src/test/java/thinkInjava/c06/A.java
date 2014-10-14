package thinkInjava.c06;

class C {
	private B b = new B(5);

}

class B {
	B(int i) {
		System.out.println("B constructor");
	}
}

public class A extends C {

	A(int i) {
		System.out.println("A constructor");
	}

	public static void main(String[] args) {
		C c = new C();
	}
}
