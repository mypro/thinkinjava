package thinkInjava.c9;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyException extends Exception {

	public MyException (){}
	public MyException(String msg){
		super(msg);
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

	}
} // /:~
