package com.test;

public class Demo {
	Demo(int i) {
	}

	Demo(double d) {
	}

	Demo() {
	}

	public static void main(String[] args) {
		char a = 'a';
		char A = 'A';
		char b = 'b';
		System.out.println((int) A);
		System.out.println((int) a);
		System.out.println((int) b);
		Demo d = new Demo();
	}
}
