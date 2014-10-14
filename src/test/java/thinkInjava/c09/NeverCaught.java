//: NeverCaught.java
// Ignoring RuntimeExceptions
package thinkInjava.c09;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NeverCaught {
	static void f() {
		throw new RuntimeException("From f()");
	}

	static void g() {
		f();
	}

	public static void main(String[] args) {
		g();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before test##########################################");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass test##########################################");
	}

	@Test
	public void test() {
		try {
			g();
		} catch (Exception e) {
			System.out.println("Caught in main, e.printStackTrace()");
			e.printStackTrace();
		}
	}
} // /:~
