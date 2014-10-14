package thinkInjava.c06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//: Bath.java
// Constructor initialization with composition

class Art {
	Art() {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art {
	Drawing() {
		System.out.println("Dwawing constructor");
	}
}

public class Cartoon extends Drawing {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	Cartoon() {
		System.out.println("Cartoon constructor");
	}

	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}

	@Test
	public void test() {
		Cartoon x = new Cartoon();
	}

}
