package thinkInjava.c05.dessert.test;

import thinkInjava.c05.dessert.Cookie;

public class ChocolateChip extends Cookie {
	public ChocolateChip() {
		System.out.println("ChocolateChip constructor");
	}

	public static void main(String[] args) {
		System.out.println("##############################################################################");
		System.out.println("##############################################################################");
		ChocolateChip x = new ChocolateChip();
		x.foo(); // Can't access foo
	}
} // /:~
