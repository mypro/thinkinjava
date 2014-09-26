package thinkInjava.c5.dessert;

public class Cookie {

	public String name1;
	protected String name2;
	String name3;
	private String name4;

	public Cookie() {
		System.out.println(" new Cookie");
	}

	protected void foo() {
		System.out.println("give you foo");
	}
	// void foo() {
	// System.out.println("give you foo");
	// }
}
