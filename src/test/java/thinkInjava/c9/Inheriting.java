package thinkInjava.c9;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myutil.Prt;

public class Inheriting {

	public static void f() throws MyException {
		Prt.outln("Throwing MyException from f()");
		throw new MyException();
	}

	public static void g() throws MyException {
		Prt.outln("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (MyException e) {
			e.printStackTrace();
		}

		try {
			g();
		} catch (MyException e) {
			e.printStackTrace();
		}
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
			f();
		} catch (MyException e) {
			e.printStackTrace();
		}

		try {
			g();
		} catch (MyException e) {
			e.printStackTrace();
		}

	}
} // /:~
